package com.FourPillars.Model;

import java.util.Comparator;
public class comparator implements Comparator<Elephant>{
	@Override
	public int compare(Elephant Dumbo, Elephant Horton) {
		return Dumbo.getColor().compareTo(Horton.getColor());
}}
