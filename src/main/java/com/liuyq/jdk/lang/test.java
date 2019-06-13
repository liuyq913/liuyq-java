package com.liuyq.jdk.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuyq on 2018/12/10.
 */
public class test {
    public static void main(String[] gras){
      //  TestBo testBo = new TestBo();
       // System.out.println(System.identityHashCode(testBo));
        //String s = null;
        //String[] strings = s.split(",");
        String a="维修:左后杠拆装烤漆1000,理赔:500;";
        String b = "左后杠拆装烤漆1000";
        String[] result = a.split(b);
        String s = result[result.length-1];
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        System.out.println(m.replaceAll(""));

        //System.out.println(getLastPlateNum(a));
    }
    private static String getLastPlateNum(String plate_no) {
        String lastnum = null;
        for(int i =0;true;i++) {
            lastnum=plate_no.substring(plate_no.length()-(i+1),plate_no.length()-i);
            System.out.println(lastnum);
            boolean isnum=isNum(lastnum);//判断是不是数字
            if(isnum) {
                break;
            }
        }

        return lastnum;
    }

    public static boolean isNum(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
