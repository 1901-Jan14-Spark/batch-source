package com.revature.covariance;

import com.revature.models.Circle;
import com.revature.models.Drawable;
import com.revature.models.Rectangle;
import com.revature.models.Shape;
import com.revature.models.Square;

public class Driver {

	public static void main(String[] args) {
		Circle c = new Circle(5);
		Rectangle r = new Rectangle(2,6);
		Square s = new Square(7);

		Shape s1 = new Square(9);
		//s1.draw();
		
		Shape[] myShapes = new Shape[4];
		myShapes[0] = c;
		myShapes[1] = r;
		myShapes[2] = s;
		myShapes[3] = s1;
		
		drawAll(myShapes);

	}
	
	public static void drawAll(Shape[] arr) {
		for(Shape s : arr) {
			System.out.println(s.getClass().getSimpleName()+":");
			s.draw();
		}
	}
	
	// we know we are getting our draw method from "Drawable" so this would be applicable for anything implementing our drawable interface
	// this is also another example of method overloading as it is the same method signature as the "drawAll" for shape objects
	public static void drawAll(Drawable[] arr) {
		for(Drawable d : arr) {
			System.out.println(d.getClass().getSimpleName()+":");
			d.draw();
		}
	}

}
