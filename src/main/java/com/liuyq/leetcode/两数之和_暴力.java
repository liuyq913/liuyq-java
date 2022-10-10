package com.liuyq.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuqing
 * @className 两数只和
 * @description https://leetcode.cn/problems/add-two-numbers/
 * @date 2022/9/30 1:20 下午
 */
public class 两数之和_暴力 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = new ListNode();
        ListNode index = head;
        int jinWei = 0;
        int nextJinWei = 0;
        int yuShu = 0;

        do {

            if (l2 == null) {
                break;
            }
            int sum = l1.val + l2.val + nextJinWei;
            jinWei = sum / 10;
            yuShu = sum % 10;

            ListNode node = new ListNode(yuShu);
            index.next = node;
            index = node;
            nextJinWei = jinWei;

            // 往下走一格
            l1 = l1.next;
            l2 = l2.next;

        } while (l1 != null);

        if (l1 == null && l2 != null) {
            do {
                int sum = l2.val + nextJinWei;
                jinWei = sum / 10;
                yuShu = sum % 10;
                ListNode node = new ListNode(yuShu);
                index.next = node;
                index = node;
                nextJinWei = jinWei;
                l2 = l2.next;
            } while (l2 != null);
        }


        if (l1 != null && l2 == null) {
            do {
                int sum = l1.val + nextJinWei;
                jinWei = sum / 10;
                yuShu = sum % 10;
                ListNode node = new ListNode(yuShu);
                index.next = node;
                index = node;
                nextJinWei = jinWei;
                l1 = l1.next;
            } while (l1 != null);
        }

        if (nextJinWei > 0) {
            ListNode node = new ListNode(nextJinWei);
            index.next = node;
        }


        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode build(List<Integer> nums) {
        ListNode head = new ListNode();
        ListNode index = head;
        for (Integer i : nums) {
            ListNode node = new ListNode(i);
            index.next = node;
            index = node;
        }
        return head.next;
    }

    public static void main(String[] args) {

        ListNode node = addTwoNumbers(build(Arrays.asList(3, 7)), build(Arrays.asList(9, 2)));
        System.out.println(JSON.toJSONString(node));
    }

}
