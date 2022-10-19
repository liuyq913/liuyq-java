package com.liuyq.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuqing
 * @className 两两交换链表中的节点
 * @description https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @date 2022/10/10 10:59 上午
 */
public class 两两交换链表中的节点 {


    public static ListNode swapPairs(ListNode head) {


        if (head == null || head.next == null) {
            System.out.println("最终结果" + JSON.toJSONString(buildList(head)));
            return head;
        }

        ListNode right = head.next;
        diGuiSwap(null, head, right, right);
        System.out.println("最终结果" + JSON.toJSONString(buildList(right)));
        return right;
    }


    public static void diGuiSwap(ListNode left,
                                 ListNode center,
                                 ListNode right, ListNode head) {

        if (center == null || right == null) {
            return;
        }

        // 交换位置
        if (left != null) {
            left.next = right;
        }
        if (right != null) {
            center.next = right.next;
            right.next = center;
        }


        System.out.println("处理过程" + JSON.toJSONString(buildList(head)));
        diGuiSwap(center, center.next, center.next == null ? null : center.next.next, head);
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

    public static List<Integer> buildList(ListNode node) {

        List<Integer> list = new ArrayList<>();
        do {
            list.add(node.val);
            node = node.next;
        } while (node != null);

        return list;
    }

    public static void main(String[] args) {
        swapPairs(build(Arrays.asList(1,2,23,34,34,2,1)));
    }

}
