package com.liuyq.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author liuyuqing
 * @className 合并两个链表
 * @description 你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
 * 请你将list1中下标从 a 到 b 的全部节点都删除，并将list2接在被删除节点的位置。
 * @date 2022/6/24 3:27 下午
 */
public class 合并两个链表 {

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        int tempA = 0;
        //list1 只有一个节点，则直接拼在list1的后面
        if (a == b && a == 0) {
            list1.next = list2;
            return list1;
        }

        ListNode tail = list2;
        do {
            tail = tail.next;
        } while (tail.next != null);

        ListNode point = list1;
        ListNode nodeA = null;
        ListNode nodeB = null;
        // 遍历listNode 1
        while (point != null) {
            // 遍历到了list1 下标为 a的位置
            if (tempA == a - 1) {
                nodeA = point;
            }

            if (tempA == b + 1) {
                nodeB = point;
            }
            // 指导下一个节点
            point = point.next;
            tempA = tempA + 1;
        }


        if (nodeA != null) {
            //交换
            nodeA.next = list2;
        }
        if (tail != null) {
            tail.next = nodeB;
        }

        return list1;
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

    public static void printList(ListNode node) {
        List<Integer> list = Lists.newArrayList();
        ListNode tail = node;
        list.add(node.val);
        do {
            tail = tail.next;
            list.add(tail.val);
        } while (tail.next != null);

        System.out.println(list.toString());
    }


    public static void main(String[] args) {
        // list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node000 = new ListNode(1000000);
        ListNode node001 = new ListNode(1000001);
        ListNode node002 = new ListNode(1000002);
        node000.next = node001;
        node001.next = node002;


        node0 = mergeInBetween(node0, 3, 4, node000);
        printList(node0);
    }
}
