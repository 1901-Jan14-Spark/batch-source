package com.revature.models;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ComparisonDriver {
	
	
	public static void main(String[] args) {
		
		List<Car> cars = new LinkedList<Car>();
		cars.add(new Car(4,25,"black",true));
		cars.add(new Car(4,65,"green",false));
		cars.add(new Car(4,0,"blue",true));
		cars.add(new Car(4,15,"yellow",false));
		
		Comparator<Car> colorComparator = (c1, c2)->{
			return c1.getColor().compareTo(c2.getColor());
		};
		
		Collections.sort(cars, colorComparator);
		for(Car c: cars) {
			System.out.println(c);
		}
	}

}
