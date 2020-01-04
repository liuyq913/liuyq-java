package com.liuyq.thread.thread72;

/**
 * @Auther: liuyuqing
 * @Date: 2019-12-10 10:34
 * @Description:
 */
public class ThreadLocalTest3 {
    public static void main(String[] ahrs){
        ThreadLocal<A> threadLocal = new ThreadLocal<A>();
        A a = new A();
        a.setName("liuyuqing");
        threadLocal.set(a);

        A aa= threadLocal.get();
        aa.setName("liuyu");

        System.out.println(a.getName());

    }
}

class A{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
