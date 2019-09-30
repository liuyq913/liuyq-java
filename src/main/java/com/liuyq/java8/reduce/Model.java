package com.liuyq.java8.reduce;

/**
 * Created by liuyq on 2019/9/25.
 */
public class Model {

    private double price;

    private String name;

    public Model(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
