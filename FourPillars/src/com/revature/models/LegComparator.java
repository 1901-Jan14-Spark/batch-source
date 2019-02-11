package com.revature.models;

import java.util.Comparator;

public class LegComparator implements Comparator<Animal>{
	@Override
	public int compare(Animal o1, Animal o2){
		return o1.getLegs() - o2.getLegs();
	}
}

