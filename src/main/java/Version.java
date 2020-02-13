import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Auther: liuyuqing
 * @Date: 2020/2/3 10:50
 * @Description:
 */
public class Version {
    private static String JSON = "{\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";

    private static String MAPPING_FILE = "/conf/mapping.txt";

    private static Map<String, String> mapping = new HashMap<>();

    private static void initMappingMap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(MAPPING_FILE));
            String s = null;
            while ((s = br.readLine()) != null) {
                String[] arr = s.split(":");
                mapping.put(arr[0], arr[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        initMappingMap();

        //args = new String[]{"master", "1-2-3", "", "/Users/lycs/workspace/meijian-login", "meijian-login-app"};
        String branch = args[0];
        String printType = args[1];
        String dir = args[2];
        String dingdingToken = args[3];
        if (null == dingdingToken || dingdingToken.length() == 0) {
            System.out.printf("钉钉通知群token为空");
            return;
        }
        Set<String> projects = new LinkedHashSet<>();
        for (int i = 4; i < args.length; i++) {
            projects.add(args[i]);
            System.out.println("要检测:" + args[i]);
        }

        String[] printTypes = printType.split("-");
        Set<String> printTypeSet = new HashSet<>();
        for (String s : printTypes) {
            printTypeSet.add(s);
        }
        File file = new File(dir);
        for (String fileName : file.list()) {
            if (!projects.contains(fileName)) {
                continue;
            }
            String targetDir = dir + File.separator + fileName + File.separator + "target";
            System.out.println(targetDir);
            for (String subFileName : new File(targetDir).list()) {
                if (subFileName.endsWith("jar")) {
                    String jarFile = targetDir + File.separator + subFileName;
                    System.out.println(jarFile);
                    BufferedReader br = null;
                    Reader in = null;
                    InputStream is = null;
                    try {
                        Process process = Runtime.getRuntime().exec("jar -xvf " + jarFile);
                        process.getOutputStream();
                        is = process.getInputStream();
                        in = new InputStreamReader(is);
                        br = new BufferedReader(in);
                        StringBuilder sb = new StringBuilder();
                        StringBuilder SNAPSHOT = new StringBuilder();
                        StringBuilder lessMaxVersion = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.endsWith("jar")) {
                                if (!line.contains("meijian") && !line.contains("mj")) {
                                    continue;
                                }
                                int idx = line.indexOf("meijian") == -1 ? line.indexOf("mj") : line.indexOf("meijian");
                                String jar = line.substring(idx);
                                boolean hasLessVersion = false;
                                for (String key : mapping.keySet()) {
                                    if (Pattern.compile(key + "-\\d+(.\\d+){0,2}(\\.|-)(RELEASE|SNAPSHOT)\\.jar").matcher(jar).matches()) {
                                        String currentVersion = getJarVersion(key, jar);
                                        if (currentVersion == null) {
                                            continue;
                                        }
                                        String maxVersion = getLastVersion(key, mapping.get(key));
                                        if (maxVersion == null) {
                                            continue;
                                        }
                                        String $maxVersion = getVersion(maxVersion);
                                        if ($maxVersion == null) {
                                            continue;
                                        }
                                        if (lessThan(currentVersion, $maxVersion)) {
                                            lessMaxVersion.append(jar).append("|当前最大版本:").append(maxVersion).append("\n");
                                            hasLessVersion = true;
                                            continue;
                                        }
                                    }
                                }
                                if (jar.contains("SNAPSHOT")) {
                                    SNAPSHOT.append(jar).append("\n");
                                }
                                if (!hasLessVersion) {
                                    sb.append(jar).append("\n");
                                }
                            }
                        }
                        String message = fileName + "\n当前分支:" + branch+"\n";
                        if (printTypeSet.contains("1")) {
                            message = message + "\n依赖的release的最高版本的jar 包 \n" + sb.toString();
                        }

                        if (printTypeSet.contains("2")) {
                            if (SNAPSHOT.length() > 0) {
                                message = message + " 快照包\n" + SNAPSHOT.toString();
                            } else {
                                message = message + " 无快照包\n";
                            }
                        }

                        if (printTypeSet.contains("3")) {
                            if (lessMaxVersion.length() > 0) {
                                message = message + " 低于最大release版本的包\n" + lessMaxVersion.toString();
                            } else {
                                message = message + " 无低于最大release版本的包";
                            }
                        }

                        postDingDing("https://oapi.dingtalk.com/robot/send?access_token=" + dingdingToken,
                                String.format(JSON, message));

                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } finally {
                        close(br, in, is);

                    }
                }
            }

        }
    }


    public static boolean postDingDing(String urlStr, String content) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(5000);
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "text/plain");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
            byte[] bytes = content.getBytes("UTF-8");
            conn.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

            conn.getOutputStream().write(bytes);
            int code = conn.getResponseCode();
            if (code == 200) {
                return true;
            }
            System.out.println("dingding return code " + code);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private static String getLastVersion(String key, String groupId) {
        try {
            String str = null;
            if (!key.contains("mj")) {
                str = execute("curl http://192.168.1.75:8081/nexus/content/groups/public/com/meijian/" + groupId + "/" + key + "/maven-metadata.xml");
            } else {
                str = execute("curl http://192.168.1.75:8081/nexus/content/groups/public/" + groupId + "/" + key + "/maven-metadata.xml");
            }
            int idx = str.lastIndexOf("<release>");
            if (idx < 0) {
                System.out.println(key + "找不到最大的release包");
                return null;
            }
            int idx2 = str.lastIndexOf("</release>");
            String lastVersion = str.substring(idx + 9, idx2);
            return lastVersion;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getVersion(String version) {
        if (version == null || !version.endsWith(".RELEASE")) {
            System.out.println(version + "不是.RELEASE");
            return null;
        }
        return version.substring(0, version.indexOf(".RELEASE"));
    }

    private static String getJarVersion(String key, String jar) {
        if (jar.endsWith("SNAPSHOT.jar")) {
            return jar.substring(key.length() + 1, jar.length() - "SNAPSHOT.jar".length() - 1);
        } else if (jar.endsWith("RELEASE.jar")) {
            return jar.substring(key.length() + 1, jar.length() - "RELEASE.jar".length() - 1);
        }
        return null;
    }

    public static String execute(String command) {
        BufferedReader br = null;
        Reader in = null;
        InputStream is = null;
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.getOutputStream();
            is = process.getInputStream();
            in = new InputStreamReader(is);
            br = new BufferedReader(in);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(br, in, is);

        }
    }

    private static void close(BufferedReader br, Reader in, InputStream is) {
        try {
            if (br != null) {
                br.close();
            }
            if (in != null) {
                in.close();
            }
            if (is != null) {
                is.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int version2Int(String version) {
        String[] array = version.split("\\.");
        int versionInt = 0;

        if (array.length > 0) {
            int a = Integer.parseInt(array[0]) * 10000;
            versionInt += a;
        }

        if (array.length > 1) {
            int b = Integer.parseInt(array[1]) * 100;
            versionInt += b;
        }

        if (array.length > 2) {
            int c = Integer.parseInt(array[2]) * 1;
            versionInt += c;
        }

        return versionInt;
    }

    private static boolean lessThan(String current, String version) {
        int currentVersion = version2Int(current);
        return currentVersion < version2Int(version);
    }
}
