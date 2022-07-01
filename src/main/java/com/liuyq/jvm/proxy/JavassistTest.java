package com.liuyq.jvm.proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * @author liuyuqing
 * @className JavassistTest
 * @description
 * @date 2022/6/30 4:01 下午
 */
public class JavassistTest {
    /**
     *  javaassist 和asm都无法在运行时期再重新加载class
     * @param agrs
     * @throws Exception
     */
    public static void main(String[] agrs) throws Exception {

        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.liuyq.jvm.asm.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/sright/Documents/workspace/liuyq-java/target/classes/com/liuyq/jvm/asm");
        Base h = (Base) c.newInstance();
        h.process();
    }
}
