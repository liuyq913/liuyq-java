package com.liuyq.java8.functional;

// functional/UnboundMethodReference.java

// 没有方法引用的对象

class X {
    String f() { return "X::f()"; }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        // MakeString ms = X::f; // [1] 编译不通过，X::f之前需要有一个对象
        TransformX sp = X::f; //这个可以通过，即使签名完全匹配  ，但是transform 里面有一个X
        X x = new X();
        System.out.println(sp.transform(x)); // [2]
        System.out.println(x.f()); // 同等效果
    }
}
