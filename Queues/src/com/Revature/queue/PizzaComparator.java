package com.Revature.queue;

import java.util.Comparator;

public class PizzaComparator implements Comparator<Pizza>{
	@Override
	public int compare(Pizza pizza1, Pizza pizza2) {
		return pizza1.getSauceType().compareTo(pizza2.getSauceType());
}
}
