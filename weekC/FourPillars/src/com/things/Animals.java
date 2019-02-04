// package com.things;

public abstract class Animals implements soundIMake {
    private int legs;

    public Animals(int legs){
      this.legs = legs;
    }

    public int getLegs(){
      return this.legs;
    }
    public void setLegs(int x){
      this.legs = x;
    }

    public abstract void makeSound();
}
