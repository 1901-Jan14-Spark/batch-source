package com.Revature;

public abstract class Animal implements Calculatable {

    private int age;

    public Animal() {
        super();
    }

    public void printAge() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
