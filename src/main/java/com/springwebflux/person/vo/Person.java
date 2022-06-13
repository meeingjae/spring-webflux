package com.springwebflux.person.vo;

public class Person {

    private long id;
    private String name;
    private Sex sex;

    public Person() {

    }

    public Person(long id, String name, Sex sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Person(long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = Sex.valueOf(sex);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public enum Sex {
        MALE,
        FEMALE
    }
}
