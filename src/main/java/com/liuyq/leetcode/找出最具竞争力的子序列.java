package com.liuyq.leetcode;

import java.util.Arrays;

/**
 * @author liuyuqing
 * @className 找出最具竞争力的子序列
 * @description 你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * <p>
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * <p>
 * 在子序列a 和子序列b 第一个不相同的位置上，如果a中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 * <p>
 * <p>
 * <p>
 * eg:
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * <p>
 * <p>
 * https://leetcode.cn/problems/find-the-most-competitive-subsequence/submissions/
 * <p>
 * @date 2022/6/24 4:33 下午
 */
public class 找出最具竞争力的子序列 {

    public static int[] mostCompetitive(int[] nums, int k) {
        if (nums.length < k) {
            return null;
        }
        //默认取最后k个元素为最有竞争的子序列
        int[] bangD = new int[k];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            bangD[index++] = nums[i];
        }


        // 上一个位置所在的指针
        Integer prePoint = nums.length - k;
        Integer yiwaiPoint = nums.length - k;

        for (int p = 0; p < k; p++) {
            //bangD的值
            int temp = bangD[p];
            //往前遍历是否比第一个值要小
            boolean change = Boolean.FALSE;
            for (int i = 0; i < nums.length; i++) {
                if (p == 0) {
                    if (temp > nums[i] && i < nums.length - k + p) {
                        // 遇到比当前bangD要小的值
                        prePoint = i;
                        bangD[p] = nums[i];
                        change = true;
                    }
                } else {
                    if (temp > nums[i] && i > prePoint && i < nums.length - k + p) {
                        // 遇到比当前bangD要小的值
                        prePoint = i;
                        bangD[p] = nums[i];
                        change = true;
                    }
                    // 碰巧
                    if (nums[i] == temp) {
                        yiwaiPoint = i;
                    }
                }
                temp = bangD[p];
            }
            if (!change) {
                prePoint = yiwaiPoint;
            }


        }

        System.out.println(Arrays.toString(bangD));
        return bangD;
    }

    public static void main(String[] args) {
        //  mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
        // System.out.println(mostCompetitive(new int[]{3, 5, 2, 6}, 2));
        //System.out.println(mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3));
        // mostCompetitive(new int[]{84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71}, 24);
        // mostCompetitive(new int[]{11, 52, 57, 91, 47, 95, 86, 46, 87, 47, 70, 56, 54, 61, 89, 44, 3, 73, 1, 7, 87, 48, 17, 25, 49, 54, 6, 72, 97, 62, 16, 11, 47, 34, 68, 58, 14, 36, 46, 65, 2, 15}, 18);
        mostCompetitive(new int[]{2, 10, 3, 5, 9, 4, 2, 0, 6, 7, 8, 0, 6, 5, 8, 1, 6, 1, 5, 5, 2, 10, 9, 5, 7, 7, 3, 2, 1, 4, 0, 7, 0, 3, 10, 10, 5, 10, 4, 7, 0, 2, 10, 9, 0, 2, 6, 10, 6, 9, 2, 1, 9, 8, 7, 2, 0, 7, 3, 6, 2, 1, 8, 0, 0, 0, 10, 4, 3, 5, 0, 8, 1, 8, 5, 1, 6, 0, 4, 4, 10, 2, 0, 5, 1, 1, 3, 3, 5, 2, 6, 5, 6, 0, 3, 8, 0, 1, 7, 0, 0, 9, 6, 10, 5, 9, 8, 9, 8, 7, 8, 10, 6, 3, 8, 0, 5, 7, 4, 3, 5, 7, 7, 0, 3, 10, 1, 3, 10, 2, 10, 3, 2, 6, 3, 10, 8, 10, 6, 0, 7, 6, 2, 10, 4, 0, 7, 4, 8, 8, 1, 7, 1, 4, 9, 7, 7, 8, 9, 8, 7, 2, 4, 9, 8, 8, 0, 8, 2, 10, 7, 3, 10, 8, 5, 1, 1, 3, 0, 5, 1, 7, 1, 7, 9, 2, 6, 9, 6, 10, 6, 1, 7, 8, 3, 6, 9, 3, 5, 9, 0, 9, 3, 5, 8, 4, 6, 8, 10, 8, 0, 9, 3, 7, 10, 4, 4, 2, 3, 7, 2, 10, 3, 5, 4, 9, 9, 2, 1, 2, 10, 4, 4, 4, 3, 5, 9, 7, 2, 0, 3, 6, 6, 7, 3, 9, 4, 6, 9, 7, 1, 3, 2, 3, 6, 6, 1, 7, 10, 0, 4, 10, 3, 5, 0, 10, 3, 10, 3, 0, 0, 1, 6, 6, 5, 9, 10, 5, 5, 9, 0, 5, 4, 1, 10, 2, 3, 1, 7, 9, 10, 10, 4, 3, 5, 9, 5, 4, 4, 8, 0, 1, 8, 1, 4, 6, 5, 6, 0, 6, 8, 6, 5, 6, 5, 7, 9, 5, 8, 8, 4, 2, 0, 0, 2, 9, 4, 9, 2, 6, 5, 2, 2, 8, 5, 4, 10, 8, 7, 7, 3, 4, 2, 0, 4, 3, 8, 6, 1, 7, 10, 10, 7, 4, 0, 6, 6, 0, 5, 6, 10, 3, 8, 3, 2, 4, 10, 4, 3, 0, 4, 10, 7, 6, 0, 4, 7, 0, 5, 2, 5, 2, 10, 9, 1, 10, 9, 6, 6, 5, 9, 10, 1, 3, 5, 2, 0, 6, 8, 5, 6, 3, 4, 8, 4, 0, 7, 0, 7, 9, 9, 1, 4, 6, 4, 5, 7, 3, 0, 4, 4, 9, 10, 5, 10, 3, 9, 6, 6, 2, 9, 4, 0, 4, 3, 3, 1, 7, 2, 1, 0, 2, 6, 7, 1, 1, 0, 3, 9, 8, 9, 4, 6, 3, 10, 7, 3, 1, 5, 2, 0, 3, 9, 5, 3, 3, 3, 1, 7, 5, 8, 10, 10, 8, 0, 2, 3, 3, 2, 9, 3, 1, 3, 9, 0, 1, 8, 2, 1, 6, 0, 6, 3, 1, 3, 1, 10, 5, 6, 0, 4, 7, 10}, 79);
    }
}
