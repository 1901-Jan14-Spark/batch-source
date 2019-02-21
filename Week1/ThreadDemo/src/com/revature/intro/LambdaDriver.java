package com.revature.intro;

public class LambdaDriver {

	public static void main(String[] args) {

		Runnable job = ()->{
			System.out.println("printing from my job implemented with a lambda");
		};
		
		Thread t = new Thread(job);
		t.start();

	}

}
