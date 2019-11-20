package com.liuyq.java8.optional;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by liuyq on 2019/8/13.
 */
public class OptionalTest {

    @Test
    public void test1() {
        //要明确输入值不为null，否则会抛空指针异常
        Optional<User> opt = Optional.of(null);
    }

    @Test
    public void test2() {
        List<User> list = Lists.newArrayList();

        for (Integer i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUser("liuyq");
            list.add(user);
            list.add(null);
        }
    }

    @Test
    public void test3() {
        for (; ; ) {
            System.out.println(1);
        }
    }

    @Test
    public void test4() {
        User user = new User();
        //user.getBirthady() 非null ,转化再设置
        Optional.ofNullable(user.getBirthady()).map(t -> DateFormatUtils.format(t, "yyyy-MM-dd")).ifPresent(user::setBirthdayStr);
        System.out.println(user.getBirthdayStr());

    }

    @Test
    public void test5() throws UnsupportedEncodingException {
        String successHteml = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>邮箱认证成功</title>\n" +
                "    <script>\n" +
                "        function countDown() {\n" +
                "            var time = document.getElementById(\"Time\");\n" +
                "            if (time.innerHTML == 0) {\n" +
                "                window.location.href = \"https://www.meijian.io/discover\";\n" +
                "            } else {\n" +
                "                time.innerHTML = time.innerHTML - 1;\n" +
                "            }\n" +
                "        }\n" +
                "        window.setInterval(\"countDown()\", 1000);\n" +
                "    </script>\n" +
                "    <style>\n" +
                "        {\n" +
                "            font-size: 100px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "    <h3>邮箱验证成功,<span id=\"Time\">5</span>s后<a href=\"${meijian_url}\">进入美间</a></h3></div>\n" +
                "</body>\n" +
                "</html>";
        successHteml = successHteml.replace("${meijian_url}", "www.baidu.com");
        System.out.println(successHteml);
    }

    @Test
    public void test6() {
        System.out.println(UUID.randomUUID().toString().replaceAll("\\-", "").substring(0, 24)); }

}
