package com.Revature;

public class Average extends Dog {

    public Average() {
        super();
    }

    public Average(int proportion) {
        this.size = proportion + 1;
    }

    // this is polymorphism - method overriding
    // we want "setSize" to behave differently in our subclass
    public void setSize(int proportion) {
        this.size = proportion;
    }

    @Override
    public void printAge() {
        if (getSize() < 15) {
            System.out.println("Your " + getSize() + " size dog is equivalence to " + calculateAge() + " years old in human age.");
        }
    }

    @Override
    public int calculateAge() {
        int counter = 27;
        if(getAge() == 1) {
            return 18;
        } for (int i = 1; i < getAge(); i++) {
            counter += 6;
        }
        return counter;
    }
}
