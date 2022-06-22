//package com.liuyq.jmm;
//
//import org.openjdk.jcstress.annotations.Actor;
//import org.openjdk.jcstress.annotations.Expect;
//import org.openjdk.jcstress.annotations.JCStressTest;
//import org.openjdk.jcstress.annotations.Outcome;
//import org.openjdk.jcstress.annotations.State;
//
///**
// * @author liuyuqing
// * @className VolatileTest
// * @description
// * @date 2022/6/17 1:18 下午
// */
//@JCStressTest
//@State
//@Outcome(id = {"3,3,3", "0,0,0"}, expect = Expect.ACCEPTABLE, desc = "ACCEPTABLE")
//@Outcome(id = {"0,3,3", "0,0,3"}, expect = Expect.ACCEPTABLE, desc = "ACCEPTABLE")
//@Outcome(id = {"0,3,0"}, expect = Expect.ACCEPTABLE_INTERESTING, desc = "ACCEPTABLE_INTERESTING")
//public class VolatileTest {
//    Foo p = new Foo();
//    Foo q = p;
//
//    static class Foo {
//        int x = 0;
//    }
//
//
//    @Actor
//    public void actor1(IResult r) {
//        r.r1 = p.x;
//        r.r2 = q.x;
//        r.r3 = p.x;
//    }
//
//    @Actor
//    public void actor2() {
//        p.x = 3;
//    }
//
//
//}
