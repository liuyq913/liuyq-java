package com.liuyq.java17;

/**
 * @author liuyuqing
 * @className SealedTest
 * @description
 * @date 2022/6/21 4:57 下午
 */
public class SealedTest {

    // 添加sealed修饰符，permits后面跟上只能被继承的子类名称
    sealed class Person permits Teacher, Worker, Student {
    }


    //默认是final 类型
    final class Teacher extends Person {
    }

    //  non-sealed 修饰后worker 又是普通的类了，可以被任何人继承
    non-sealed class Worker extends Person {
    }

    class AnyClass extends Worker {
    }


    //子类可以被修饰为 sealed,同上
    sealed class Student extends Person permits MiddleSchoolStudent, GraduateStudent {
    } //学生


    final class MiddleSchoolStudent extends Student {
    }  //中学生

    final class GraduateStudent extends Student {
    }  //研究生
}

