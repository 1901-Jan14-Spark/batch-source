package com.rev.sub;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDriver {
	
public static void main(String[] args) {
	String path = "src/com/rev/sub/pie.ser";
	
	
	pie p = new pie("cherry","normal", 9);
	
	try(FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new
			ObjectOutputStream(fos)){
		oos.writeObject(p);
		System.out.println("YESS");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}