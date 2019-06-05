package com.liuyq.proxy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyq on 2018/7/10.
 */
public class test {
    @Test
    public void main2(){
    List<HhdRemittanceVo> list = new ArrayList<>();
        HhdRemittanceVo hhdRemittanceVo1 = new HhdRemittanceVo();
        hhdRemittanceVo1.setStoreName("hah");
        hhdRemittanceVo1.setPeriod(1);
        HhdRemittanceVo hhdRemittanceVo2 = new HhdRemittanceVo();
        hhdRemittanceVo2.setStoreName("haeeh");
        hhdRemittanceVo2.setPeriod(1);
        HhdRemittanceVo hhdRemittanceVo3 = new HhdRemittanceVo();
        hhdRemittanceVo3.setStoreName("hah12");
        hhdRemittanceVo3.setPeriod(1);
        HhdRemittanceVo hhdRemittanceVo4 = new HhdRemittanceVo();
        hhdRemittanceVo4.setStoreName("hae23eh");
        hhdRemittanceVo4.setPeriod(2);
        list.add(hhdRemittanceVo2);
        list.add(hhdRemittanceVo1);
        list.add(hhdRemittanceVo3);
        list.add(hhdRemittanceVo4);
        StringBuffer stringBuffer = new StringBuffer();
        list.stream().filter(t->t.getPeriod().equals(1)).forEach(t->stringBuffer.append(t.getStoreName()).append("   "));
        System.out.println(stringBuffer.toString());
    }

    @Test
    public void test(){
       String s = "[{\"isAbnormal\":\"true\",\"reportItemDetailAbnormalID\":25,\"reportItemDetailAbnormalName\":\"变形\"},{\"isAbnormal\":\"true\",\"reportItemDetailAbnormalID\":25,\"reportItemDetailAbnormalName\":\"变形\"},{\"isAbnormal\":\"false\",\"reportItemDetailAbnormalID\":27,\"reportItemDetailAbnormalName\":\"裂纹\"},{\"isAbnormal\":\"true\",\"reportItemDetailAbnormalID\":26,\"reportItemDetailAbnormalName\":\"喷漆\"}]";
        List<ValCarReportItemAbnormalDetailBo> list = com.alibaba.fastjson.JSONObject.parseArray(s, ValCarReportItemAbnormalDetailBo.class);
        System.out.println(list);
    }

    @Test
    public void test2(){
        String s ="http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13028,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13029,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13030,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13031,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13032,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13033,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13034,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13037,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13036,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13038,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13039,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13040";
        System.out.println(s.length());
    }
}
