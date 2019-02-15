package com.Revature.queue;

import java.util.LinkedList;


public class Driver {

	public static void main(String[] args) {
		
//		PizzaComparator tony=new PizzaComparator();
		LinkedList<Pizza> pizzaQueue= new LinkedList<>();
		//
		pizzaQueue.add(new Pizza(true, "Red", new String[] {"pepperoni", "mushrooms", "sausage"} ));
		pizzaQueue.add(new Pizza(false, "White", new String[] {"chicken", "mushrooms", "bacon"} ));
		pizzaQueue.add(new Pizza(true, "none", new String[] {"Extra Cheese", "bacon", "sausage"} ));

//		pizzaQueue.offer(new Pizza(true, "Red", new String[] {"pepperoni", "mushrooms", "sausage"} ));
//		pizzaQueue.offer(new Pizza(false, "White", new String[] {"chicken", "mushrooms", "bacon"} ));
//		pizzaQueue.offer(new Pizza(true, "none", new String[] {"Extra Cheese", "bacon", "sausage"} ));


		System.out.println(pizzaQueue);
		System.out.println(pizzaQueue.remove());
		System.out.println(pizzaQueue);
		}
}
