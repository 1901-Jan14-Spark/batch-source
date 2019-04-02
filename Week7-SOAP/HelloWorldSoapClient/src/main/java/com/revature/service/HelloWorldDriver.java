package com.revature.service;

public class HelloWorldDriver {
	
	// we ran wsimport -XnoCompile [wsdl location] to generate the code for our client
	public static void main(String[] args) {
		
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld helloWorld = helloService.getHelloWorldImplPort();
		
		helloWorld.sayHi("Cats === Bears");
//		System.out.println("this is actually in my client");
		
	}

}
