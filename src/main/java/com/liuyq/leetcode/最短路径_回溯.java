package com.liuyq.leetcode;

/**
 * @author liuyuqing
 * @className 最短路径
 * @description
 * @date 2022/11/8 4:29 下午
 */
public class 最短路径_回溯 {
    private static int minDist = Integer.MAX_VALUE; // 全局变量或者成员变量


    // int[][] item 存放的是走这一格子要多少步   n是item的长和宽
    public static void 最短路径(int i, int j, int dist, int[][] item, int n) {

        //都走到终点
        if (i == n && j == n) {
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        }

        if (i < n) {
            // 往下走一步
            最短路径(i + 1, j, dist + item[i][j], item, n);
        }

        if (j < n) {
            // 往右走一步
            最短路径(i, j + 1, dist + item[i][j], item, n);
        }

    }
}
