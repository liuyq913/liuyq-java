package com.liuyq.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyq on 2018/7/10.
 */
public class test {
    public static void main(String [] ars){
        List<HhdRemittanceVo> list = new ArrayList<>();
        HhdRemittanceVo hhdRemittanceVo1 = new HhdRemittanceVo();
        hhdRemittanceVo1.setStoreName("hah");
        HhdRemittanceVo hhdRemittanceVo2 = new HhdRemittanceVo();
        hhdRemittanceVo2.setStoreName("haeeh");
        list.add(hhdRemittanceVo2);
        list.add(hhdRemittanceVo1);

    }
}
