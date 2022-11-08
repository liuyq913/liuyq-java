package com.liuyq.leetcode;

/**
 * @author liuyuqing
 * @className 背包问题_回溯
 * @description
 * @date 2022/10/26 9:44 下午
 */
public class 背包问题_回溯 {
    private static int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private static int[] weight = {2, 2, 4, 6, 3}; // 物品重量
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量
    private static boolean[][] mem = new boolean[5][10]; //默认都是false

    /**
     * 回溯算法
     *
     * @param i  准备放的位置
     * @param cw 当前背包的总量
     */
    public static void f(int i, int cw) {
        if (i == n || cw == w) {
            if (maxW < cw) {
                maxW = cw;
            }
            return;
        }

        if (mem[i][cw]) {
            return;
        }


        mem[i][cw] = true;
        // 开始选择或者不选择----

        // 选择不放第i个物品
        f(i + 1, cw);
        // 选择放第i个物品
        if (w >= cw + weight[i]) {
            f(i, cw + weight[i]);
        }
    }

    public static void main(String[] args) {
        f(0, 0);
        System.out.println(maxW);
    }
}
