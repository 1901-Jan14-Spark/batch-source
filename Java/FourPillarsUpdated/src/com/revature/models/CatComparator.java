package com.revature.models;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat> {
	
	public int compare(Cat c1, Cat c2) {
		return c1.getBreed().compareTo(c2.getBreed());	
	}
}
