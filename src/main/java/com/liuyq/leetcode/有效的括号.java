package com.liuyq.leetcode;

import java.util.Stack;

/**
 * @author liuyuqing
 * @className 有效的括号
 * @description https://leetcode.cn/problems/valid-parentheses/
 * @date 2022/10/8 5:20 下午
 */
public class 有效的括号 {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Character temp = 'A';
        for (Character c : s.toCharArray()) {
            if (isFH(c)) {
                if (!stack.empty()) {
                    temp = stack.pop();
                }
                if ((temp == '{' && c == '}') || (temp == '(' && c == ')') || (temp == '[' && c == ']')) {
                    temp = 'A';
                    continue;
                } else {
                    if (temp != 'A') {
                        stack.push(temp);
                    }
                }
                stack.push(c);
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;

    }


    private static boolean isFH(Character c) {
        if (c == '{' || c == '}' || c == '(' || c == ')' || c == ']' || c == '[') {
            return true;
        }
        return false;
    }


    public static void main(String[] agrs) {
        System.out.println(isValid("()[]{}"));
    }
}
