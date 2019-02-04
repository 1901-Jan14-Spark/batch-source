// package com.things;

public class Chicken extends Animals {

  private String name;

  public Chicken(){
    super(2);
  }

  public Chicken(String name){
    super(2);
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String x){
    this.name = x;
  }

  @Override
  public void makeSound(){
    System.out.println("Cluck!");
  }
}
