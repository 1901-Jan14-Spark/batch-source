package com.revature.shapes;

public class Square extends Rectangle {
	
	public Square() {
		super();
	}
	
	public Square(int sideLength) {
		this.height = sideLength;
		this.width = sideLength;
	}
	
	// this is polymorphism - method overriding
	// we want "setHeight" to behave differently in our subclass
	public void setHeight(int height) {
		this.height = height;
		this.width = height;
	}
	
	// this is polymorphism - method overriding
	// we want "setWidth" to behave differently in our subclass
	public void setWidth(int width) {
		this.height = width;
		this.width = width;
	}

}
