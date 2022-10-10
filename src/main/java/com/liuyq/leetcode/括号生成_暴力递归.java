package com.liuyq.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author liuyuqing
 * @className 括号生成
 * @description https://leetcode.cn/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 虽然能解决问题，但是效率太低
 * <p>
 * @date 2022/10/9 2:21 下午
 */
public class 括号生成_暴力递归 {
    public static List<String> generateParenthesis(int n) {

        Integer len = n * 2;
        //构造初始值
        List<String> chuShi = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            chuShi.add(")");
        }


        // 穷举所有可能
        List<List<String>> result = new ArrayList<>();
        getSuiJi(chuShi, result, 0);

        List<String> hh = new ArrayList<>();

        for (List<String> str : result) {
            StringBuffer strB = new StringBuffer();
            str.parallelStream().forEach(t -> strB.append(t));
            if (有效的括号.isValid(strB.toString())) {
                hh.add(strB.toString());
            }
        }

        return hh;
    }


    private static void getSuiJi(List<String> chuShi, List<List<String>> result, Integer index) {
        if ((chuShi == null && chuShi.size() <= 0) || index >= chuShi.size()) {
            return;
        }

        if (!result.contains(chuShi)) {
            result.add(chuShi);
        }

        List<String> temp = new ArrayList<>();
        for (String in : chuShi) {
            temp.add(in);
        }
        Integer currentIndex = index + 1;
        change(temp, index);
        if (!result.contains(temp)) {
            result.add(temp);
        }

        getSuiJi(chuShi, result, currentIndex);
        getSuiJi(temp, result, currentIndex);
    }


    public static void change(List<String> list, Integer index) {
        String num = list.get(index);
        if (Objects.equals(num, ")")) {
            list.set(index, "(");
        } else {
            list.set(index, "(");
        }
    }

    public static void main(String[] ahrs) {
        System.out.println(generateParenthesis(8));
    }

}
