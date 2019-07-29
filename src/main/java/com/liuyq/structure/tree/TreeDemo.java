package com.liuyq.structure.tree;

/**
 * Created by liuyq on 2019/7/19.
 *  递归公式：
 *    前序遍历: preOrder(r) = print(r) --> preOrder(r ->left) --> preOrder(r -> right)
 *    中续遍历：inOrder(r) = print(r->left) --> print(r) --> print(r -> right)
 *    后续遍历：postOrder(r) = postOrder(r - > left) --> postOrder(r -> right) -->print(r)
 *
 *
 *                        7
 *                       / \
 *                      5   6
 *                     / \  /
 *                    4   2 1
 *
 *    数组存储   [null, 7 , 5 ,6 ,4, 2, 1]
 *                0   1   2  3   4  5  6
 *      下标为 i 的节点，那么 2*i 就是左子节点， 2*i+1就是右子节点
 *    几种遍历方式demo（数组存储)
 */
public class TreeDemo {
    private Node root;

    private Integer[] date;

    /**
     * 返回 给定数组下标的 右结点在数组的位置
     * @param i
     * @return
     */
    public int findRight(Integer i){
        return 2*i +1;
    }


    public int findLeft(Integer i){
        return 2*i;
    }


    /**
     * 找到父级节点
     * @param i
     * @return
     */
    public int findFather(Integer i ){return i/2;}


    /**
     * 前续
     * @param tree
     */
    public void preOrder(Node tree){
        if(tree == null) return;

        System.out.println(tree.getData());
        preOrder(tree.getLeft());
        preOrder(tree.getRight());
    }

    /**
     * 中续
     * @param tree
     */
    public void inOrder(Node tree){
        if(tree == null) return;

        inOrder(tree.getLeft());
        System.out.println(tree.getData());
        inOrder(tree.getRight());
    }

    /**
     * 后续
     * @param tree
     */
    public void postOrder(Node tree){
        if(tree == null) return;

        postOrder(tree.getLeft());
        postOrder(tree.getRight());
        System.out.println(tree.getData());
    }

    /**
     * 结点
     */
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
