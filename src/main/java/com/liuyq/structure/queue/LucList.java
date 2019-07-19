package com.liuyq.structure.queue;

/**
 * Created by liuyq on 2019/7/19.
 *
 *基于单项链表的luc算法实现
 */
public class LucList<T> {

    private static final Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Note<T> head;
    /**
     * 链表长度
     */
    private Integer length;
    /**
     * 容量
     */
    private Integer capacity;


    /**
     * 删除最后一个结点
     */
    public void delectEndNote(){
        /**
         * 空队列
         */
        if(head.getNext() == null){
            return;
        }

        Note note = head;
        do{
            note = note.getNext();
        }while (note.getNext().getNext() == null); //找到倒数第二个结点


        Note end = note.next;
        end = null;

        //倒数第二个结点后继结点为null
        note.next = null;
        length --;
    }

    /**
     * 找到data对应的上一个结点，也就是说  note.next.data = date
     * @param data
     * @return
     */
    public Note findBeforeByData(T data){
        //空链表
        if(head.getNext() == null) return null;

        Note note = head;
        do{
            note = note.getNext();
        }while (!note.getNext().getData().equals(data));

        return note;
    }

    /**
     * 删除指定date的下一个结点
     * @param note
     */
    public void delectNext(Note note){
        Note temp = note.getNext();
        note.setNext(temp.next);
        temp = null;
        length --;
    }

    /**
     * 从头指针插入数据
     * @param data
     */
    public void insertHead(T data){
        Note temp = head.getNext();

        Note note = new Note();
        note.setData(data);
        note.setNext(temp);

        head.setNext(note);
    }

    /**
     * 添加元素，如果链表里面已经有了元素，则先删除元素，在把元素存放到头指针的后继结点
     * @param data
     */
    public void add(T data){
        Note note = findBeforeByData(data); //找到data的上一个节点

        if(note != null){
            delectNext(note); //删除上note的下一个节点
        }else {
            if(length >= capacity){
                delectEndNote();
            }
        }
        insertHead(data);
    }




    static class Note<T>{
        T data;
        Note<T> next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Note getNext() {
            return next;
        }

        public void setNext(Note next) {
            this.next = next;
        }
    }
}
