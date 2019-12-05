package com.liuyq.proxy;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by liuyq on 2018/7/10.
 */
public class test {
    @Test
    public void main2() {
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
        list.stream().filter(t -> t.getPeriod().equals(1)).forEach(t -> stringBuffer.append(t.getStoreName()).append("   "));
        System.out.println(stringBuffer.toString());
    }

    @Test
    public void test() {
        String s = "[{\"isAbnormal\":\"true\",\"reportItemDetailAbnormalID\":25,\"reportItemDetailAbnormalName\":\"变形\"},{\"isAbnormal\":\"true\",\"reportItemDetailAbnormalID\":25,\"reportItemDetailAbnormalName\":\"变形\"},{\"isAbnormal\":\"false\",\"reportItemDetailAbnormalID\":27,\"reportItemDetailAbnormalName\":\"裂纹\"},{\"isAbnormal\":\"true\",\"reportItemDetailAbnormalID\":26,\"reportItemDetailAbnormalName\":\"喷漆\"}]";
        List<ValCarReportItemAbnormalDetailBo> list = com.alibaba.fastjson.JSONObject.parseArray(s, ValCarReportItemAbnormalDetailBo.class);
        System.out.println(list);
    }

    @Test
    public void test2() {
        String s = "http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13028,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13029,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13030,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13031,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13032,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13033,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13034,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13037,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13036,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13038,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13039,http://private4s.upload.acar168.cn:5507/maintenance-file-service/private/download?fileID=13040";
        System.out.println(s.length());
    }

    @Test
    public void test3() {
        String s = "1,3,4,5";
        int i = 2;
        System.out.println(Arrays.asList(s.split(",")).contains(i + ""));
    }

    @Test
    public void test4() {
        List<String> realPaths = Lists.newArrayList();
        realPaths.add("12");
        realPaths.add("12");
        //去重
        Set<String> setPaths = realPaths.stream().collect(Collectors.toSet());
        realPaths = setPaths.stream().collect(Collectors.toList());
        System.out.println(realPaths);
    }

    public static void main(String[] ahrs){
        System.out.println(Double.NaN);
    }
}
