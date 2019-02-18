package com.FourPillars.Model;

public class Tamer {
public static void main(String[] args) {
	
Elephant Dumbo=new Elephant(4, "gray");
Elephant Horton=new Elephant (4, "blue");
// testing .equals method
System.out.println(Dumbo.equals(Horton));

//virtual method invocation

//tantor.findHabitat();
// unchecked Exception - catching out of bounds exception
String[] landAnimals=new String[] {"Elephants", "Horses", "Dogs","Cows", "Sheep", "Goats"};
try {
for (int i=-1;i<=landAnimals.length;i++) {
	System.out.println(landAnimals[i]);
}
}catch(ArrayIndexOutOfBoundsException ex) {
	System.out.println("Index is not that big");
}
Elephant tantor= new Elephant("ElephantData.txt");
System.out.println(tantor);
}
}