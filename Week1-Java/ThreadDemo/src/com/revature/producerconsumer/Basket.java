package com.revature.producerconsumer;

public class Basket {
	
	private int contents;
	private boolean available = false;
	
	/*
	 * check for availability
	 * - if there is something available, we want the consumer to get it
	 * - if there isn't anything available we want it to wait
	 * - calls notify in case put was waiting for the basket to be empty
	 */
	public synchronized int get() {
		while(!available) {
			try {
				System.out.println("\t\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("CONSUMER got: "+contents);
		available = false;
		notify();
		return contents;
	}
	
	
	/*
	 * check for availability
	 * - if there isn't something available, we want the producer to make it available
	 * - if there is something available, we want it to wait
	 * - calls notify in case get was waiting for the basket to have something in it
	 */
	public synchronized void put(int value) {
		while(available) {
			try {
				System.out.println("\t\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("PRODUCER put: "+value);
		contents = value;
		available = true;
		notify();
	}

}
