package com.liuyq.structure.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyuqing
 * @className Test2
 * @description
 * @date 2022/4/19 6:38 下午
 */
public class Test2 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //存放最终答案的二维数组
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int len = num.length;
        //特判：长度<3的数组不满足条件
        if (len < 3) {
            return ans;
        }
        //排序O(nlogn)
        Arrays.sort(num);

        for (int i = 0; i < len; i++) {
            //如果nums[i]已经大于0，就没必要继续往后了，因为和就是0啊
            if (num[i] > 0) {
                return ans;
            }
            //注意考虑越界i>0,主要功能是排除重复值
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            //声明指针
            int cur = num[i];
            int left = i + 1;
            //从尾部开始
            int right = len - 1;
            while (left < right) {
                //满足条件的三数和
                int tp_ans = cur + num[left] + num[right];
                //如果已经找到和为0
                if (tp_ans == 0) {
                    //创建一个数组，并将满足条件的三元素放进去
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(num[left]);
                    list.add(num[right]);
                    //将最终的结果存入答案数组ans中
                    ans.add(list);
                    //判断是left指针指向是否重复
                    while (left < right && num[left] == num[left + 1]) {
                        left++;
                    }
                    //判断是right指针指向是否重复
                    while (left < right && num[right] == num[right - 1]) {
                        right--;
                    }
                    //移动指针
                    left++;
                    right--;
                } else if (tp_ans < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }


    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        //存放答案的集合
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int len = num.length;
        //排序O(nlogn)
        Arrays.sort(num);
        //哈希表去重
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(num[i], i);
        }
        //若干变量声明
        int L, M, R;
        for (int i = 0; i < len; i = map.get(L) + 1) {
            //指定L的值
            L = num[i];
            //注意里层循环从i+1开始
            for (int j = i + 1; j < len; j = map.get(M) + 1) {
                M = num[j];
                //注意一下，这里是个容易错的细节..
                R = -L - M;
                if (R < M) {
                    break;
                }
                if (map.get(R) != null && map.get(R) > j) {
                    //创建一个数组，并将满足条件的三元素放进去
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(L);
                    list.add(M);
                    list.add(R);
                    //将最终的结果存入答案数组ans中
                    ans.add(list);
                    //不知道为什么。一下这种写法再牛客平台编译过不了，已经向官方反馈。
                    //ans.add(Arrays.asList(L,M,R));
                }
            }
        }
        return ans;
    }

}
