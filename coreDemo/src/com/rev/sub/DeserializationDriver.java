package com.rev.sub;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDriver {
public static void main(String[] args) {
	String path = "src/com/rev/sub/pie.ser";
	
	try(FileInputStream fil = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fil)){
		
		pie p = (pie) ois.readObject();
		System.out.println(p);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
