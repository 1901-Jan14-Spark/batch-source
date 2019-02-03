package com.Revature;

public class Cat extends Animal {

    private String name;

    public Cat() {
        this.setAge(5);
    }

    // Polymorphism -- overloading
    public Cat(String name) {
        this.setAge(10);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printAge() {
        if(getAge() > 0) {
            System.out.println(getName() + " is equivalence to " + calculateAge()  + " years old in human age." );
        }
    }

    @Override
    public int calculateAge() {
        int counter = 24;
        if (getAge() == 1) {
            return 15;
        } else if (getAge() == 2) {
            return 24;
        } for(int i = 2; i < getAge(); i++) {
            counter += 4;
        }
        return counter;
    }

}
