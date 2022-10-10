package com.liuyq.leetcode;

/**
 * https://leetcode.cn/problems/find-the-difference/
 *
 * @author liuyuqing
 * @className 找不同
 * @description
 * @date 2022/7/7 5:26 下午
 */
public class 找不同 {
    public static char findTheDifference(String s, String t) {

        if (s.length() == 0 && t.length() == 1) {
            return t.toCharArray()[0];
        }

        char[] t1 = t.toCharArray();
        char[] s1 = s.toCharArray();
        char result = 0;
        for (int i = 0; i <= t1.length - 1; i++) {
            char ttemp = t1[i];
            for (int j = 0; j <= s1.length - 1; j++) {
                if (ttemp == s1[j]) {
                    s1[j] = 0;
                    t1[i] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i <= t1.length - 1; i++) {
            char ttemp = t1[i];
            if (ttemp != 0) {
                result = ttemp;
            }

        }
        return result;
    }

    public static void main(String[] ahrs) throws Exception {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
