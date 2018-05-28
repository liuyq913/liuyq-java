package com.liuyq.thread.thread71;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
//基于监视器模式的汽车追踪
public class MonitorVehicleTracker {
    private final Map<String,MutablePoint> localtions;


    public MonitorVehicleTracker(Map<String,MutablePoint> localtions){
        this.localtions = localtions;
    }

    public synchronized Map<String,MutablePoint> getLocaltions(){
        return deepCopy(localtions);
    }

    public synchronized void setLocaltions(String id, int x , int y) throws Exception {
        MutablePoint loc = localtions.get(id);
        if(loc == null){
           throw new Exception();
        }
        loc.x = x;
        loc.y =y;

    }

    private Map<String,MutablePoint> deepCopy(Map<String, MutablePoint> localtions) {
        Map<String,MutablePoint> result = new HashMap<>();
        for (String id: localtions.keySet())
            result.put(id,new MutablePoint(localtions.get(id)));
        return Collections.unmodifiableMap(result);
    }
}

