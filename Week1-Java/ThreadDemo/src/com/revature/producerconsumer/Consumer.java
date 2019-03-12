package com.revature.producerconsumer;

public class Consumer implements Runnable {

	Basket basket;
	
	public Consumer(Basket b) {
		this.basket = b;
	}
	
	@Override
	public void run() {
		
		int value;
		for(int i=0; i<10; i++) {
			value = basket.get();
//			System.out.println(Thread.currentThread().getName()+" got: "+value);
			
			try {
				Thread.sleep((int) (Math.random()*1500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}

}
