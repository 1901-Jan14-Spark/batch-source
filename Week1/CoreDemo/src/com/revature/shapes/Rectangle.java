package com.revature.shapes;

public class Rectangle extends Shape {

	protected int height;
	protected int width;
	
	public Rectangle() {
		this.setNumOfSides(4);
	}
	
	// here we overload our constructor, providing constructors with different sets of parameters
	// this is polymorphism -- overloading
	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
		this.setNumOfSides(4);
	}
	
	public int getHeight() {
		return height;
	}

	// this is overriden in our subclass
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	// this is overriden in our subclass
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a rectangle with width "+ width+" and height "+height);
		
	}

	@Override
	public int calculateArea() {
		return width*height;
	}

	@Override
	public int calculatePerimeter() {
		return 2*(height+width);
	}

	protected Rectangle returnRect() throws RuntimeException {
		return new Rectangle();
	}
	
}
