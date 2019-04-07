package com.rev;

import java.util.Arrays;

public class StackDriver {
public static void main(String[] args) {
	MyStack<String> ms = new MyStack<>();
	ms.addValue("String");
	ms.addValue("Another string");
	System.out.println(Arrays.toString(ms.toArray()));
	System.out.println(ms.removeValue());
	System.out.println(Arrays.toString(ms.toArray()));
	
	
}
}
