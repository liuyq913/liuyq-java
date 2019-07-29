package com.liuyq.structure.heap;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by liuyq on 2019/7/25.
 * 堆
 * 特性：(1)堆是完全二叉树
 * (2)堆每一个节点大于或等于子节点，或者小于等于子节点
 * <p>
 * 以下为大头堆  越往上越大
 */
public class Heap {
    private Integer[] a; //存储的数组， 下标从1 开始存储
    private Integer n;  //堆的容量
    private Integer count; //堆当前存储的数量

    private static Integer changeNum = 0;


    public Heap(Integer capacity) {
        this.n = capacity;
        this.a = new Integer[capacity + 1]; //下标为0的位置没有存储数据
        this.count = 0;
    }

    /**
     * insert 一个节点到堆中 （自下往上）  时间复杂度是O(logn)
     * 思路：先insert到数组的最后一位，然后找到他的父节点，然后比较大小，然后再看是不是需要交换，直到不存在父级节点为止
     *
     * @param node
     */
    public void insert(Integer node) {
        if (a == null) return;

        //堆已满
        if (count >= n) return;
        a[++count] = node;

        Integer father = count / 2;
        Integer son = count;
        //找到父节点  父节点存在并且父节点小于要插入的节点
        while (father > 0 && a[father] < a[son]) {

            //交换
            Integer temp = a[son];
            a[son] = a[father];
            a[father] = temp;
            changeNum++;
            //往上找
            son = father;
            father = father / 2;

        }

        println();
    }

    /**
     * 移除最大元素  时间复杂度是O(logn)
     */
    public void removeMax() {
        if (a == null) return;
        //空堆
        if (count == 0) return;

        //取到数组最后一个值
        Integer last = a[count];
        //最后一个元素与堆顶元素交换
        a[count] = null;
        if (count != 1) { //只有一个元素直接删除就好
            a[1] = last;
        }

        //将栈顶元素找到合适的位置
        Integer farther = 1;
        Integer son = 2 * farther;
        while (son < count && son > 0 && a[son] > a[farther]) {
            Integer temp = a[son];
            a[son] = a[farther];
            a[farther] = temp;
            //往下找
            farther = son;
            son = son * 2;
        }
        count--;
        println();

    }

    /**
     * 构建 堆  自下往上
     *
     * @param a
     */
    public  void buildHeap(Integer a[]) {
        //要先构造heap  堆大小不够
        if (n < a.length) return;

        for (Integer i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    public void println() {
        System.out.println(Arrays.toString(a));
    }

    /**
     * 构建堆  自上往下堆化   时间复杂是O（n）  这种更好
     *
     * @param a  第一个节点是null
     * @param n  n是数组中非空节点个数 也就堆中节点个数
     * */
    public static void buildHeap(Integer[] a, Integer n) {
        /**
         * 对与完全二叉树来说， 如果n是元素的个数，n/2+1 到  n的节点的是叶子节点，叶子节点无需堆化，因为叶子节点只能自己跟自己比较
         *
         * 那么 从1 -- n/2的节点均是非叶子节点
         */
        for (Integer i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 自上往下堆化
     *
     * @param a
     * @param n
     * @param i 需要找到特定位置的节点
     */
    public static void heapify(Integer[] a, Integer n, Integer i) {
        while (true) {
            Integer maxPos = i;
            //找到i的左子节点， 比较 如果左子节点大于父节点  要还的位置是做左子节点
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            //要还的位置是右子节点
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);  //交换
            i = maxPos;
        }
    }

    public static void swap(Integer[] a, Integer i, Integer maxPos) {
        Integer temp = a[i];
        a[i] = a[maxPos];
        a[maxPos] = temp;
        changeNum++;
    }


    /**
     *
     * 排序的时间复杂都是O（nlogn）
     *
     * 排序  取堆顶元素和最后一个元素交换位置 然后最后一个位置之前的元素进行自上向下堆化
     *
     * 比如： {null, 2, 3, 4, 5, 6, 7} 的数组
     *      转成堆之后：
     *      [null, 7, 6, 4, 5, 3, 2]  大顶堆
     *      这个时候7 是堆顶元素，然后和数组最后一个元素进行交换 也就是下标为k的元素
     *      -->[null, 2, 6, 4, 5, 3 ， 7] 然后 2 再进行向下堆化， 这个时候，堆化的元素是n-1 也就是最后一个元素不进行遍历
     *      -->[null 6 ， 5， 4 ， 2 ， 3]  然后 k-- 也就是指到下标为3 的位置
     *       依次进行，知道k = 1 只剩栈顶元素
     *       整个数组就是有序的了
     */
    public static void sort(Integer a[], Integer n) {
        buildHeap(a, n); //构建大顶堆  堆化之后，父级
        // 元素一定大于子元素，所有可以保证数组第一个元素一定是最大的
        Integer k = n;
        while (k > 1){
            swap(a, 1, k);
            heapify(a, k-1, 1);  //时间复杂都是O(logn)
            System.out.println(Arrays.toString(a));
            k--;
        }
    }

    /**
     * 控制台输入 构建一个堆
     */
    @Test
    public void test1() {

    }

    public static void main(String[] agrs) {

      /*  //控制台输出一个堆
        Heap heap = new Heap(6);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            heap.insert(scanner.nextInt());
        }
*/
        /**
         * 移除最大元素
         */
      /*  Heap heap = new Heap(6);
        Integer a[] = {2, 3, 4, 5, 6, 7};
        heap.buildHeap(a);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.nextInt() == 1) {
                heap.removeMax();
            }
        }*/


        /**
         * 自上往下构建一个堆
         */

        Integer[] a ={null, 2, 3, 4, 5, 6, 7};
        sort(a, 6);
        System.out.println("交换次数为："+changeNum);

    }
}
