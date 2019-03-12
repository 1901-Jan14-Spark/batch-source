package com.revature.shapes;

public class Circle extends Shape {

	private int radius;
	
	public Circle() {
		super();
		this.setNumOfSides(0);
	}
	
	public Circle(int radius) {
		this.radius = radius;
		this.setNumOfSides(0);
	}
	
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		if(radius>0) {
			this.radius = radius;
		}
	}

	@Override
	public void draw() {
		System.out.println("Drawing a circle with a radius of "+radius);
		
	}

	@Override
	public int calculateArea() {
		return (int) Math.round(Math.PI*(radius^2));
	}

	@Override
	public int calculatePerimeter() {
		return (int) Math.round(radius*2*Math.PI);
	}

}
