package Lambdas;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashSet;

public class Driver {
	
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(8);
		list.add(9);
		
		
		
		list.forEach((i)->{
			System.out.println(i);
		});
		
		Consumer<Integer> printInt = (i) -> {
			System.out.println(i*10);
		};
		
		printInt.accept(list.get(0));
		
		Set<Integer> s = new HashSet<>();
		
		
		Consumer<List<Integer>> populateSet = l -> {
			for(int i =0; i<list.size();i++) {
				s.add(list.get(i));
				}
			};
			
			populateSet.accept(list);
			System.out.println(s.toString());
			
			Predicate<String> pred = str->str.compareTo("middle")>0;
			
		List<String> strList = new ArrayList<>();
		strList.add("Alpha");
		strList.add("charlty");
		strList.add("Zulu");
		strList.add("victor");
		
		System.out.println(pred.test("Alpha"));
		System.out.println(pred.test("zulu"));
		System.out.println(pred.test("victor"));
		
		System.out.println(strList);
		strList = strList.parallelStream().filter(pred).collect(Collectors.<String>toList());
		System.out.println(strList);
		
		
	}
		
		
//		
//		Consumer<Integer>printInt = (i) -> {
//			System.out.println(i*10);
//		}
		
	}
	

	
	


