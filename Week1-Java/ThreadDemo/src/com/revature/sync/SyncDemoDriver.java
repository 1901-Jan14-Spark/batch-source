package com.revature.sync;

public class SyncDemoDriver {

	public static void main(String[] args) {
		
		/*
		StringBuffer sbuffer = new StringBuffer();
		StringBuilder sbuild = new StringBuilder();
		Runnable job1 =  new StringTestRunnable(sbuild, sbuffer, '*');
		Runnable job2 =  new StringTestRunnable(sbuild, sbuffer, '~');
		Thread t1 = new Thread(job1);
		Thread t2 = new Thread(job2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("StringBuilder result:");
		System.out.println(sbuild);
		System.out.println();
		
		System.out.println("StringBuffer result:");
		System.out.println(sbuffer);
		*/
		
		Count count = new Count();
		Runnable countJob = new CountTestRunnable(count);
		Thread countThread1 = new Thread(countJob);
		Thread countThread2 = new Thread(countJob);
		
		countThread1.start();
		countThread2.start();
		
		try {
			
			countThread1.join();
			countThread2.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Count is: "+count.count);
		
		
	}

}
