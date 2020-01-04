package com.liuyq.easyExcel;

import com.alibaba.excel.EasyExcel;

/**
 * @Auther: liuyuqing
 * @Date: 2019-12-05 17:22
 * @Description:
 */
public class ExcelReadTest {

    public static void main(String[] ahrs){
        //读取
        EasyExcel.read("", ProductProcedureWorkshop.class, new ProductProcedureWorkshopListener()).sheet().doRead();

    }
}
