// package com.things;

public class Whale extends Animals {

  private String name;

  public Whale(){
    super(0);
  }

  public Whale(String name){
    super(0);
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
    System.out.println("WaAAAOOOooooooooOoo!");
  }
}
