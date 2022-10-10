package com.liuyq.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuqing
 * @className 两数之和_递归
 * @description
 * @date 2022/9/30 5:56 下午
 */
public class 两数之和_递归 {

    public static 两数之和_暴力.ListNode addTwoNumbers(两数之和_暴力.ListNode l1, 两数之和_暴力.ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        两数之和_暴力.ListNode result = new 两数之和_暴力.ListNode();
        merge(l1, l2, result);
        return result.next;
    }

    public static void merge(两数之和_暴力.ListNode l1, 两数之和_暴力.ListNode l2, 两数之和_暴力.ListNode result) {
        if (l1 == null || l2 == null) {

            // 拼接剩余的部分
            if (l1 != null) {
                jinWei(l1, result);
                merge(l1.next, null, result.next);
                return;
            } else if (l2 != null) {
                jinWei(l2, result);
                merge(null, l2.next, result.next);
                return;
            }
            return;
        }


        // 两个节点相加
        Integer sum = l1.val + l2.val;
        Integer jinWei = sum / 10;
        Integer yuShu = sum % 10;

        result.next = new 两数之和_暴力.ListNode(yuShu);

        if (jinWei > 0) {
            if (l2.next == null) {
                l2.next = new 两数之和_暴力.ListNode(jinWei);
            } else {
                Integer l2val = l2.next.val + jinWei;
                l2.next.val = l2val;
            }
        }

        merge(l1.next, l2.next, result.next);

    }


    private static void jinWei(两数之和_暴力.ListNode l1, 两数之和_暴力.ListNode result) {
        if (l1 == null) {
            return;
        }
        if (l1.val >= 10) {
            result.next = new 两数之和_暴力.ListNode(l1.val % 10);
            if (l1.next != null) {
                l1.next.val = l1.next.val + l1.val / 10;
            } else {
                l1.next = new 两数之和_暴力.ListNode(l1.val / 10);
            }
        } else {
            result.next = new 两数之和_暴力.ListNode(l1.val);
        }
    }

    public static 两数之和_暴力.ListNode build(List<Integer> nums) {
        两数之和_暴力.ListNode head = new 两数之和_暴力.ListNode();
        两数之和_暴力.ListNode index = head;
        for (Integer i : nums) {
            两数之和_暴力.ListNode node = new 两数之和_暴力.ListNode(i);
            index.next = node;
            index = node;
        }
        return head.next;
    }

    public static void main(String[] agrs) {
        两数之和_暴力.ListNode node = addTwoNumbers(build(Arrays.asList(9)), build(Arrays.asList(9, 9, 9)));
        System.out.println(JSON.toJSONString(node));
    }
}
