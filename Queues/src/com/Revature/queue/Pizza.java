package com.Revature.queue;

import java.util.Arrays;

public class Pizza implements Comparable<Pizza>{
private boolean hasCheese;
private String[] toppings;
private String sauceType;

Pizza(){
	
}
Pizza(boolean hasCheese, String sauceType, String[] toppings){
	this.hasCheese=hasCheese;
	this.toppings=toppings;
	this.sauceType=sauceType;
		
}

public String getSauceType() {
	return sauceType;
}
public void setSauceType(String sauceType) {
	this.sauceType = sauceType;
}


@Override
public String toString() {
	return "Pizza [hasCheese=" + hasCheese + ", toppings=" + Arrays.toString(toppings) + ", sauceType=" + sauceType
			+ "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (hasCheese ? 1231 : 1237);
	result = prime * result + ((sauceType == null) ? 0 : sauceType.hashCode());
	result = prime * result + Arrays.hashCode(toppings);
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pizza other = (Pizza) obj;
	if (hasCheese != other.hasCheese)
		return false;
	if (sauceType == null) {
		if (other.sauceType != null)
			return false;
	} else if (!sauceType.equals(other.sauceType))
		return false;
	if (!Arrays.equals(toppings, other.toppings))
		return false;
	return true;
}
@Override
public int compareTo(Pizza o) {
	if(this.sauceType == o.sauceType) {
		return 0;
	} else {
		return -1;
		}
}
	




}
