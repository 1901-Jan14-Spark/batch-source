package com.Revature;

import com.Exception.NegativeAgeException;

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
        if(age < 0) {
            throw new NegativeAgeException("Age must be greater than -1");
        }
        this.age = age;
    }
}
