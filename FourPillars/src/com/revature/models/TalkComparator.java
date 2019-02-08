package com.revature.models;

import java.util.Comparator;

public class TalkComparator implements Comparator<Animal>{

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.talk().compareToIgnoreCase(o2.talk());
	}

	
}
