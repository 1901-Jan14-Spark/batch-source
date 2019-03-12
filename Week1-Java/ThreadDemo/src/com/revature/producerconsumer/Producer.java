package com.revature.producerconsumer;

public class Producer implements Runnable {
	
	private Basket basket;
	
	public Producer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
//			System.out.println(Thread.currentThread().getName()+" put: "+i);
			basket.put(i);

			try {

				Thread.sleep((int)(Math.random()*1500));
		
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
