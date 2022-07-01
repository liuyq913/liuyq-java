package com.liuyq.java8.optional;

import java.util.Date;

/**
 * Created by liuyq on 2019/8/13.
 */
public class User {
    private Integer id;

    private String user;

    private Date birthady;

    private String birthdayStr;

    public User(){

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getBirthady() {
        return birthady;
    }

    public void setBirthady(Date birthady) {
        this.birthady = birthady;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }
}
