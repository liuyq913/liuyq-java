package com.liuyq.jdk1216;

/**
 * @author liuyuqing
 * @className InstanceOfTest
 * @description jdk 16
 * @date 2022/6/29 3:56 下午
 */
public class InstanceOfTest {

    static class Student {

        private final String name;

        Student(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
//            if (o instanceof Student) {
//                Student student = (Student) o;
//                return student.name.equals(this.name);
//            }
            // 不用类型转换
            if (o instanceof Student student) {
                return student.name.equals(this.name);
            }

            return false;
        }
    }
}
