package com.liuyq.sort;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created by liuyq on 2018/3/30.
 * 插入排序：时间复杂度为O(2^n)
 */
public class InsertSort {
    public void insertSort(Integer[] list){
        for(int i = 1 ;i<list.length ;i++){
            Integer j ;
            Integer temp = list[i] ;
            //ｊ从i开始，往前遍历，前的大于后面的，就交换位置
            for(j = i;j>0 && temp<list[j-1];j--)
            list[j] = list[j-1];//大的往后移
            list[j] = temp;
        }
    }

    @Test
    public void test(){
        System.out.println((1 << (32 - 16)) - 1);
    }
    @Test
    public void test2(){
        String s = "{\n" +
                "  checkRemark:\"123423\",\n" +
                "  carPartAbnormalRemark:\"12\"\n" +
                "}";
         JSONObject jsonObject=JSON.parseObject(s);
          String string = jsonObject.getString("checkRemark");
        String carPartAbnormalRemark = jsonObject.getString("carPartAbnormalRemark");
        if(carPartAbnormalRemark  == "null" || StringUtils.isEmpty(carPartAbnormalRemark)){
            string = string+"";
        }else{
            string = string+" "+carPartAbnormalRemark;
        }
        System.out.println(string);

    }
}
