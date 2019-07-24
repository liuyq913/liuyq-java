package com.liuyq.structure.tree;

/**
 * Created by liuyq on 2019/7/21.
 * <p>
 * 二叉查找树 : 节点的右边大于根节点，左边大于根节点
 */
public class BinarySearchTree {
    //根节点
    private Node tree;

    //查找
    public Node find(int data) {
        Node p = tree;

        while (p != null) {
            if (p.data == data) return p;

            if (p.data > data) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
        return null;
    }

    //插入  新插入的节点都是存放在叶子结点上的
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data); //为根节点
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                }
                p = p.left;
            }
        }
    }

    /**
     * 删除节点
     * 三种情况：
     * (1)没有子节点， 直接删除
     * （2）只有一个子节点，把要删除的父节点指到要删除的子节点。
     * （3）要删除的有两个子节点，要删除节点的右节点的最小值（没有左节点），和要删除节点交换位置，然后根据（1）（2）来删除节点
     *
     * @param data
     */
    public void delete(int data) {

        Node p = tree;  //要删除的节点
        Node pp = null; //要删除的父节点

        while (p != null && p.data != data) {
            pp = p;
            if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) return; //没有找到


        //要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            //找到右子节点的最小节点
            Node minp = p.right; //最小节点
            Node minpp = p;//最小节点的父节点

            //找到最小值及最小值的父节点
            while (minp.left != null){
                minpp = minp;
                minp = minp.left;
            }

            //仅仅数据交换
            p.data = minp.data;

            p = minp;
            pp = minpp;

        }

        Node childe; //p的子节点
        if (p.left != null) {
            childe = p.left;
        } else if (p.right != null) {
            childe = p.right;
        } else {
            childe = null;
        }

        //删除节点
        if (pp.left == p) {
            pp.left = childe;
        } else if (pp.right == p) {
            pp.right = childe;
        }

        p = null;

    }

    public Node findMin(Node root){
        if(root == null) return null;

        Node  p = root;
        while(root.left != null){
            p = root.left;
        }

        return p;
    }

    public Node findMax(Node root){
        if(root == null) return null;

        Node  p = root;
        while(root.right != null){
            p = root.right;
        }

        return p;
    }

    /**
     *  findHight(h) = findHight（h-1）+1;
     *  findHight（叶子节点）= 1
     * @param root
     * @return
     */
    public int findHight(Node root){

        if(root == null) return 0;

        if(root.left == null && root.left == null) return 1;

        int lefgHight = findHight(root.left);

        int rightHight = findHight(root.right);

        return lefgHight > rightHight ? lefgHight +1: rightHight+1;

    }

    /**
     * 中序遍历一棵树
     * @param tree
     */
    public void inOrder(Node tree){
        if(tree == null) return;

        inOrder(tree.getLeft());
        System.out.println(tree.getData());
        inOrder(tree.getRight());
    }

    /**
     * lowr 和 upper 是父级节点应该位于子节点的位置，应该是大于子节点就是在upper上，小于子节点就是在与lower上（以插查找树为标准）
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(Node node, Integer lower, Integer upper) {
        if (node == null) return true;

        int data = node.data;
        if (lower != null && data <= lower) return false;
        if (upper != null && data >= upper) return false;

        if (! helper(node.right, data, upper)) return false;
        if (! helper(node.left, lower, data)) return false;
        return true;
    }

    /**
     * 是否二叉查找树
     * @param root
     * @return
     */
    public boolean isValidBST(Node root) {
        return helper(root, null, null);
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
