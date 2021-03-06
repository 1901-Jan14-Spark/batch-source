package com.revature.lamdas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Driver {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(3);
		list.add(8);
		list.add(2);
		
		
		Consumer<Integer> printInt = (i) ->{
			System.out.println(i*10);
		};
		
//		list.forEach(printInt);
		
		
//		printInt.accept(list.get(0));
		
		Set<Integer> s = new HashSet<>();
		
		Consumer<List<Integer>> populateSet = l ->{
			for(int i =0; i<l.size();i++) {
				s.add(list.get(i));
			}
		};
		
		populateSet.accept(list);
//		System.out.println(s.toString());
		

		Predicate<String> pred = str->str.compareTo("middle")>0;
		
		List<String> strList = new ArrayList<>();
		strList.add("alpha");
		strList.add("charlie");
		strList.add("zulu");
		strList.add("victor");
		
//		System.out.println(pred.test("alpha"));
//		System.out.println(pred.test("zulu"));
		
		System.out.println(strList);
		strList = strList.stream().filter(pred).collect(Collectors.<String>toList());
		System.out.println(strList);
	}

}
