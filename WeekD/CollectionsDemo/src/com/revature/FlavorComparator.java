package com.revature;

import java.util.Comparator;

public class FlavorComparator implements Comparator<IceCream> {

	@Override
	public int compare(IceCream iceCream1, IceCream iceCream2) {
		return iceCream1.getFlavor().compareTo(iceCream2.getFlavor());
	}



}
