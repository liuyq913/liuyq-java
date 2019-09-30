package com.liuyq.jvm;

/**
 * Created by liuyq on 2019/9/30.
 */
public class JavaHeapTest {
    public final static int OUTOFMEMORY = 200000000;

    private String oom;

    private int length;

    StringBuffer tempOOM = new StringBuffer(); // java.lang.OutOfMemoryError: Java heap space 堆oom tempOOM 这个实例特别大

    public JavaHeapTest(int leng) {
        this.length = leng;

        int i = 0;
        while (i < leng) {
            i++;
            try {
                tempOOM.append("a");
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();

    }

    public String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        JavaHeapTest javaHeapTest = new JavaHeapTest(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
    }

}
