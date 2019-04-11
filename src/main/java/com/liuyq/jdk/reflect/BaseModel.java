package com.liuyq.jdk.reflect;

import com.alibaba.dubbo.common.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyq on 2019/4/11.
 */
public class BaseModel {

    private String id;

    private String name;

    private String[] checkParam = new String[]{"id","name"};

    /**
     * 参数校验未通过字段记录
     */
    private List<String> checkParamsList = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCheckParam() {
        return checkParam;
    }

    public void setCheckParam(String[] checkParam) {
        this.checkParam = checkParam;
    }

    public Boolean reqParamsCheck(String[] params){
        if(null == params){return false;}
        Boolean result = true;
        for(String name : params){
            Object value = ReflectUtil.invokeGetMothod(getClass(), this, name);
            if(StringUtils.isEmpty(ReflectUtil.objectToStr(value))){
                checkParamsList.add(name);
                result = false;
            }
        }
        return result;
    }
}
