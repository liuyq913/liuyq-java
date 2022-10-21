package com.liuyq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuyuqing
 * @className 字母异位词分组
 * @description https://leetcode.cn/problems/group-anagrams/
 * @date 2022/10/19 10:35 下午
 */
public class 字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        return null;
    }


    public static List<List<String>> hash(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            int[] temp = new int[26];

            for (char c : str.toCharArray()) {
                temp[c - 'a']++;
            }

            StringBuffer stringBuffer = new StringBuffer();
            for (int i : temp) {
                stringBuffer.append("#").append(i);
            }

            List<String> strings = resultMap.getOrDefault(stringBuffer.toString(), new ArrayList<>());
            strings.add(str);
            resultMap.put(stringBuffer.toString(), strings);
        }

        return resultMap.values().stream().collect(Collectors.toList());
    }


    public static List<List<String>> sort(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> strings = map.getOrDefault(sorted, new ArrayList());
            strings.add(s);
            map.put(sorted, strings);
        }


        return map.values().stream().collect(Collectors.toList());
    }

    public static void main(String[] agrs) {
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(sort(str));

        System.out.println(hash(str));

    }
}
