package com.liuyq.structure.strack;

/**
 * 基于数据实现栈的功能
 */
public class ArryStrack {
    private String[] arrys; //栈里面的数据

    private Integer count;//栈的元素

    private Integer num;//栈的大小

    public ArryStrack(Integer num){
        this.num = num;
        this.arrys = new String[num];
        this.count = 0;
    }

    public boolean push(String s){
        if(count == num){
            //扩容 时间复杂的为O(n) 非扩容一般都是O（1） 均摊复杂度为O（1）  均摊复杂度一般等于最好时间复杂度
            String[] newArrys = new String[num*2];
            System.out.println("扩容!!!");
            for(int i = 0;i<num;i++){
                newArrys[i] = arrys[i];
            }
            arrys = newArrys;
        }

        arrys[count] = s;
        count++;
        return true;
    }

    /**
     * 取第一元素
     * @return
     */
    public String push(){
        if(count == 0) return null;
        String tep =  arrys[count-1];
        count--;
        return tep;
    }


}
