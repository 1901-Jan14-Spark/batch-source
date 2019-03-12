package com.revature.intro;

public class TestDriver {

	public static void main(String[] args) {
		
		Thread t = new TestThread();

		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		
		t.start();
//		t.setPriority(newPriority);
		
		try {
			// the thread the join method is being called in will wait until the execution of the thread its being invoked on has completed
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+"  isAlive? "+t.isAlive());
	}

}
