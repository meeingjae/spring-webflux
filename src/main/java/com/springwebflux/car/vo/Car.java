package com.springwebflux.car.vo;

public class Car {
    private long id;
    private String name;
    private long price;

    public Car() {

    }

    public Car(long id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
