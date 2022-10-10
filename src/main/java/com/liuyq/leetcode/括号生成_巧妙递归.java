package com.liuyq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuqing
 * @className 括号生成
 * @description https://leetcode.cn/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *
 * <p>
 * @date 2022/10/9 2:21 下午
 */
public class 括号生成_巧妙递归 {
    public static List<String> generateParenthesis(int n) {


        List<String> result = new ArrayList<>();


        digui(result, 0, 0, n, "");

        return result;
    }

    /**
     * 左括号的数量要永远小于等于右括号的数量，否则就是无效的匹配
     */
    private static void digui(List<String> result, int left, int right, int n, String str) {
        // 如果右括号数量大于左括号数量
        if (right > left) {  // "())"
            return;
        }

        if (left > n || right > n) {
            return;
        }

        // 满足条件了
        if (left == right && left == n) {
            result.add(str);
            return;
        }

        if (left < n) {
            digui(result, left + 1, right, n, str + "(");
        }

        if (right < left) {
            digui(result, left, right + 1, n, str + ")");
        }


    }


    public static void main(String[] ahrs) {
        System.out.println(generateParenthesis(2));
    }


}
