package com.liuyq.java8;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liuyq on 2019/2/28.
 */

public class UserInputTest {


    public static void main(String[] args){
        List<UserInput> inputs = Lists.newArrayList();
        inputs.add(new UserInput(new Long(1),new Date()));
        inputs.add(new UserInput(new Long(1), new Date(System.currentTimeMillis() - 8*24*1000*1000)));
        inputs.add(new UserInput(new Long(2), new Date(System.currentTimeMillis() - 7*24*1000*1000)));
        inputs.add(new UserInput(new Long(3), new Date(System.currentTimeMillis() - 6*24*1000*1000)));
        Map<Long, List<UserInput>> result = inputs.stream().collect(Collectors.groupingBy(UserInput::getUserID));
       // List<Long> key = new ArrayList<>(result.keySet());

        //List<Map.Entry<Long, List<UserInput>>> value = new ArrayList<Map.Entry<Long, List<UserInput>>>(result.entrySet());

        getUserList(inputs);

    }
     static  List<Long> getUserList(List<UserInput> userInputs){
         Date date = new Date(System.currentTimeMillis() - 10*24*1000*1000);
         userInputs = userInputs.stream().filter(t->t.getLoginDate().after(date)).collect(Collectors.toList());
         Map<Long, List<UserInput>> result = userInputs.stream().collect(Collectors.groupingBy(UserInput::getUserID));
         Map<Long,Integer> resultInteger = sortByValue(result);
         List<Long> finalResult = Lists.newArrayList();
        List<Long> key = new ArrayList(resultInteger.keySet());
         for(Integer i = 0; i<10;i++){
             finalResult.add(key.get(0));
         }
         return finalResult;
     }

    private static Map<Long,Integer> sortByValue(Map<Long, List<UserInput>> result) {
         Map<Long, Integer> rsultInteger = Maps.newHashMap();
         Set<Long> keySet = result.keySet();
        for(Long id : keySet){
            rsultInteger.put(id,result.get(id).size());
        }

        List<Map.Entry<Long, Integer>> list = new LinkedList<Map.Entry<Long, Integer>>(rsultInteger.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2)
            {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });
        Map<Long, Integer> result1 = new LinkedHashMap<Long, Integer>();
        for (Map.Entry<Long, Integer> entry : list) {
            result1.put(entry.getKey(), entry.getValue());
        }
        return result1;
    }
}

class UserInput{
    private Long userID;

    private Date loginDate;


    public UserInput(Long userID, Date loginDate) {
        this.userID = userID;
        this.loginDate = loginDate;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
