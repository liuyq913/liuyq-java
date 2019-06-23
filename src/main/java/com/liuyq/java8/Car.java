package com.liuyq.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyq on 2019/6/23.
 */
public class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] agrs){
        Car car = Car.create(Car::new);
        List< Car > cars = Arrays.asList(car, Car.create(Car::new));

        cars.forEach(Car::repair);
        cars.forEach(car::follow);
    }
}
