package com.revature.generics;

import com.revature.shapes.Rectangle;

public class LargerShapeComparator implements MyComparator<Rectangle> {

	@Override
	public Rectangle compare(Rectangle object1, Rectangle object2) {
		Rectangle largerRectangle = (object1.calculateArea()>object2.calculateArea())?object1:object2;
		return largerRectangle;
	}


}
