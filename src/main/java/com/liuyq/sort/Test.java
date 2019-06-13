package com.liuyq.sort;

/**
 * Created by liuyq on 2018/7/5.
 */
public class Test {
   public static void main(String[] agrs){
       String s = "维修:右后门(全喷),理赔:360;";
       String s2= s.substring(4);
       String[] str = s.split(s2);
       System.out.println(str);
   }
}
