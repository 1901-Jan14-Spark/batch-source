package com.rev.patterns;

public class MySingleton {

	/*
	 * 
	 * 
	 * 
	 * 
	 */
	//instance
	private static MySingleton mySingleton;
	/*
	 * private static MySingleton mySingleton = new Mysingleton();
	 * pre initailization making this eager
	 * 
	 */
	
	private int value;
	
	
	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	private MySingleton() {
		super();
	}
	
	
	//accesor
	public static MySingleton getInstance() {
		/*
		 * with pre initailization, take this if statement out 
		 */
		
		
		if(mySingleton == null) {
			mySingleton = new MySingleton();
		}
		return mySingleton;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
}
