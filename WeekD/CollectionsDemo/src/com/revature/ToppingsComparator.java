package com.revature;

import java.util.Comparator;

public class ToppingsComparator implements Comparator<IceCream> {

	@Override
	public int compare(IceCream o1, IceCream o2) {
		return o1.getToppings().length - o2.getToppings().length;
	}

}
