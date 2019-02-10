package com.FourPillars.Model;

public class Tamer {
public static void main(String[] args) {
Elephant Dumbo=new Elephant(4, "gray");
Elephant Horton=new Elephant (4, "blue");
// testing .equals method
System.out.println(Dumbo.equals(Horton));
}
//virtual method invocation
Animals tantor= new Elephant();
tantor.findHabitat();


}
