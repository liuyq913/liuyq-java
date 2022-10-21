package com.liuyq.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuyuqing
 * @className 全排列-回溯法
 * @description https://leetcode.cn/problems/permutations/
 * @date 2022/10/20 10:24 下午
 */
public class 全排列 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();


        Map<Integer, Boolean> linkExistMap = Maps.newHashMap();
        // 默认都在链路上不存在
        for (int num : nums) {
            linkExistMap.put(num, Boolean.FALSE);
        }

        diGui(result, nums, linkExistMap, Lists.newArrayList());

        return result;
    }


    private static void diGui(List<List<Integer>> result, int[] nums, Map<Integer, Boolean> linkExistMap, List<Integer> current) {

        if (current.size() == nums.length) {
            result.add(current);
            return;
        }

        for (int num : nums) {


            // 当前链路已经包含了当前值
            if (linkExistMap.get(num)) {
                continue;
            }
            List<Integer> temp = new ArrayList<>(current);
            temp.add(num);

            linkExistMap.put(num, Boolean.TRUE);
            diGui(result, nums, linkExistMap, temp);
            linkExistMap.put(num, Boolean.FALSE);
        }

    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
