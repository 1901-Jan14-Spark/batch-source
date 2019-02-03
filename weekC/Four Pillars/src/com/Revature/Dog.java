package com.Revature;

public class Dog extends Animal {

    protected int size;

    public Dog() {
    }

    // here we overload our constructor, providing constructors with different sets of parameters
    // this is polymorphism -- overloading
    public Dog(int age, int size) {
        this.setAge(5);
        this.size = size;
    }


    public int getSize() {
        return size;
    }

    // this is overriding in our subclass
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void printAge() {
        if(getSize() < 5) {
            System.out.println("Your " + getSize() + " size dog is equivalence to " + calculateAge() + " years old in human age.");
        }
    }

    @Override
    public int calculateAge() {
        int counter = 28;
        if(getAge() == 1) {
            return 20;
        } for (int i = 1; i < getAge(); i++) {
            counter += 4;
        }
        return counter;
    }
}
