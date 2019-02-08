package com.revature;

import java.util.Arrays;

public class IceCream implements Comparable<IceCream> {
	
	private String flavor;
	private int numOfScoops;
	private String[] toppings;
	
	public IceCream() {
		super();
	}

	public IceCream(String flavor, int numOfScoops, String[] toppings) {
		super();
		this.flavor = flavor;
		this.numOfScoops = numOfScoops;
		this.toppings = toppings;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOfScoops() {
		return numOfScoops;
	}

	public void setNumOfScoops(int numOfScoops) {
		this.numOfScoops = numOfScoops;
	}

	public String[] getToppings() {
		return toppings;
	}

	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}

	@Override
	public String toString() {
		return "IceCream [flavor=" + flavor + ", numOfScoops=" + numOfScoops + ", toppings=" + Arrays.toString(toppings)
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + numOfScoops;
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
		IceCream other = (IceCream) obj;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		if (numOfScoops != other.numOfScoops)
			return false;
		if (!Arrays.equals(toppings, other.toppings))
			return false;
		return true;
	}

	/*
	 * compareTo returns an integer result
	 * if it returns a negative number "this" is considered to be of lesser value 
	 * if it returns a positive number "this" is considered to be of greater value
	 * if it returns 0, the two objects are considered to be of equal value
	 */
	@Override
	public int compareTo(IceCream o) {
		if(this.numOfScoops == o.numOfScoops) {
			return this.getFlavor().compareTo(o.getFlavor());
		}
		return this.numOfScoops - o.numOfScoops;
	}

	
	
}
