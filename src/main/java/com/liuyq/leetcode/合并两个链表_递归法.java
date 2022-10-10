package com.liuyq.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuqing
 * @className 合并两个链表_递归法
 * @description
 * @date 2022/10/8 5:56 下午
 */
public class 合并两个链表_递归法 {

    public static ListNode mergeInBetween(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null || list2 == null) {
            return list2 == null ? list1 : list2;
        }


        if (list2.val > list1.val) {
            sort(list1, list2);
            return list1;
        } else {
            sort(list2, list1);
            return list2;
        }

    }


    public static void sort(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return;
        }

        ListNode currentNext = list1.next;
        if (currentNext == null) {
            // list1 已经到底了则吧 list2 全部拼在list1的后面
            list1.next = list2;
            // 从小到大排列   大于等于前面个 小于后面
        } else if (list1.val <= list2.val && currentNext.val > list2.val) {
            ListNode newNode = new ListNode(list2.val);
            newNode.next = currentNext;
            list1.next = newNode;
            sort(list1, list2.next);
        } else {
            // 没找到相应的位置，则list1 往下走一格
            sort(list1.next, list2);
        }
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

    public static void main(String[] ahrs) {
        ListNode node = mergeInBetween(build(Arrays.asList()), build(Arrays.asList(0)));
        System.out.println(JSON.toJSONString(node));
    }
}
