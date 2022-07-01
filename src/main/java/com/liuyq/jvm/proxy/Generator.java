package com.liuyq.jvm.proxy;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author liuyuqing
 * @className Generator
 * @description
 * @date 2022/6/30 3:13 下午
 */
public class Generator {

    public static void main(String[] args) throws Exception {
        //读取
        ClassReader classReader = new ClassReader("com.liuyq.jvm.proxy/Base");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();
        //输出
        File f = new File("/Users/sright/Documents/workspace/liuyq-java/target/classes/com/liuyq/jvm/asm/Base.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        System.out.println("now generator cc success!!!!!");
    }
}
