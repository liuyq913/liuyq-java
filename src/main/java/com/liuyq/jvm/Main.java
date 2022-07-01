package com.liuyq.jvm;

/**
 * @author liuyuqing
 * @className Main
 * @description
 * @date 2022/6/30 10:22 上午
 */
public class Main {
    private int m = 3;

    public int inc() {
        return m + 1;
    }


    String zijema = """
            Classfile /Users/sright/Documents/workspace/liuyq-java/src/main/java/com/liuyq/jvm/Main.class  //文件路径
              Last modified 2022年6月30日; size 288 bytes      // 最后修改时间
              SHA-256 checksum 18d2f8565e1acd864b0b04c9af3e9f33adba63759719c797e352d103187a60b8
              Compiled from "Main.java"
            public class com.liuyq.jvm.Main
              minor version: 0
              major version: 61
              flags: (0x0021) ACC_PUBLIC, ACC_SUPER
              this_class: #8                          // com/liuyq/jvm/Main 
              super_class: #2                         // java/lang/Object    超类
              interfaces: 0, fields: 1, methods: 2, attributes: 1
            Constant pool: //常量池 存放 字面量(Literal)和符号引用(Symbolic References)
               #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
               #2 = Class              #4             // java/lang/Object
               #3 = NameAndType        #5:#6          // "<init>":()V
               #4 = Utf8               java/lang/Object
               #5 = Utf8               <init>
               #6 = Utf8               ()V
               #7 = Fieldref           #8.#9          // com/liuyq/jvm/Main.m:I
               #8 = Class              #10            // com/liuyq/jvm/Main
               #9 = NameAndType        #11:#12        // m:I
              #10 = Utf8               com/liuyq/jvm/Main
              #11 = Utf8               m
              #12 = Utf8               I
              #13 = Utf8               Code
              #14 = Utf8               LineNumberTable
              #15 = Utf8               inc
              #16 = Utf8               ()I
              #17 = Utf8               SourceFile
              #18 = Utf8               Main.java
            {
              private int m;
                descriptor: I
                flags: (0x0002) ACC_PRIVATE
                        
              public com.liuyq.jvm.Main();
                descriptor: ()V
                flags: (0x0001) ACC_PUBLIC
                Code:
                  stack=2, locals=1, args_size=1
                     0: aload_0
                     1: invokespecial #1                  // Method java/lang/Object."<init>":()V
                     4: aload_0
                     5: iconst_3
                     6: putfield      #7                  // Field m:I
                     9: return
                  LineNumberTable:
                    line 9: 0
                    line 10: 4
                        
              public int inc();
                descriptor: ()I
                flags: (0x0001) ACC_PUBLIC
                Code:
                  stack=2, locals=1, args_size=1
                     0: aload_0
                     1: getfield      #7                  // Field m:I
                     4: iconst_1
                     5: iadd
                     6: ireturn
                  LineNumberTable:
                    line 13: 0
            }
            SourceFile: "Main.java"
            """;
}
