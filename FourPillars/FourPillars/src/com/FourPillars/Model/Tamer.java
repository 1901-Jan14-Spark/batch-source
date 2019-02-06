package com.FourPillars.Model;

public class Tamer {
public static void main(String[] args) {
Elephant dumbo=new Elephant(4);
Elephant horton=new Elephant (4);
// testing .equals method
System.out.println(dumbo.equals(horton));
}
//virtual method invocation
Animals tantor= new Elephant();
tantor.findHabitat();


}
