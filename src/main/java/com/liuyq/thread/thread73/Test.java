package com.liuyq.thread.thread73;

import java.math.BigDecimal;

/**
 * Created by liuyq on 2018/8/16.
 */
public class Test {
    public static void main(String [] agrs){
       // Map<String, Object>
       // usedRedPacketIds = (ArrayList<Long>) tppParams.get("usedRedPacketIds");
        String s = null;
        System.out.println(s);
    }

    public static BigDecimal add(Number... params)
    {
        BigDecimal b = BigDecimal.ZERO;
        for (Number param : params)
        {
            BigDecimal b2 = new BigDecimal(param.toString());
            b = b.add(b2);
        }
        return b;
    }
}
