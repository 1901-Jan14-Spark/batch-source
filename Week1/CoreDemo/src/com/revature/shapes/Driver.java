package com.revature.shapes;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Circle:");
		Circle c = new Circle(5);
		c.draw();
		System.out.println("Area="+c.calculateArea());
		System.out.println("Perimeter="+c.calculatePerimeter());
		System.out.println();


		
		System.out.println("Rectangle:");
		Rectangle r = new Rectangle(2,6);
		r.draw();
		r.setHeight(10);
		r.draw();
		System.out.println("Area="+r.calculateArea());
		System.out.println("Perimeter="+r.calculatePerimeter());
		System.out.println();
		
		
		System.out.println("Square:");
		Square s = new Square(7);
		s.draw();
		s.setHeight(10);
		s.draw();
		s.setWidth(7);
		s.draw();
		System.out.println("Area="+s.calculateArea());
		System.out.println("Perimeter="+s.calculatePerimeter());
		System.out.println();

	}

}
