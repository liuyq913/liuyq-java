package com.liuyq.structure.queue;

/**
 * @author liuyq
 * @date 2019/6/5 0005 下午 22:06
 * 基于链表实现的队列
 */
public class ListQueue {
    private Node head = null;
    private Node tail = null;


    /**
     * 入队
     * @param s
     * @return
     */
    public void enqueue(String s){
        if(tail == null){ //尾节点为null
            Node node =  new Node(s, null);
            head = node;
            tail = node;
        }else{
            Node node =  new Node(s, null);
            tail.next = node;
        }

    }

    /**
     * 出队
     * @return
     */
    public String dequeue(){
        if(head == null) return null;
        Node temp  =  head;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return temp.date;
    }

    /**
     * 节点
     */
    class Node {
        private String date;
        private Node next;

        public Node(String date, Node next) {
            this.date = date;
            this.next = next;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
