package com.liuyq.jdk10;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author liuyuqing
 * @className VarTest
 * @description jdk10 引入局部类型推断,  var 是在编译之后会被替换成对应的类型， var 不是关键字，是标识符号
 *               一下情况不能用；
 *               1. 没有初始化的局部变量
 *               2.方法的返回类型   eg  public var method（）{return 0;}
 *               3.方法的参数类型  eg：public void method(var num)
 *               4. 构造器的参数类型
 *               5. 属性（非局部变量）
 *               6. catch 块  try{}catch(var e)
 *
 * @date 2022/6/23 10:14 上午
 */
public class VarTest {

    public static void main(String[] args) {
        // 类型推断  是通过右边来推断左边，所以必须要赋值
        var num = 10;
        var list = new ArrayList<String>();
        list.add("1");
        System.out.println(list);


        //lambada 表达式不能类型推断   var s = () -> Math.random();
        Supplier<Double> s = () -> Math.random();

        // 方法引用 var con =  System.out::println;
        Consumer<String> con = System.out::println;




    }

}
