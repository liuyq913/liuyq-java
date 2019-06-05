package com.liuyq.thread.dahua;

/**
 * Created by liuyq on 2019/3/15.
 */
public class RotateStr {
    public static String rotate(String s){
        char[] str = s.toCharArray();

        for(int i = 0; i < str.length / 2; i++){
            char tempe = str[str.length-1 - i];
            str[str.length-1 - i] = str[i];
            str[i] = tempe;
        }
        return new String(str);
    }

    /**
     * 递归翻转字符串
     * @param str
     * @return
     */
    public static String reverse2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse2(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] agrs){
        String s = (reverse2("abc"));
        System.out.println(s);
    }
}
