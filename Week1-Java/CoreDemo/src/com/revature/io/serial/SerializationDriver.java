package com.revature.io.serial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDriver {

	public static void main(String[] args) {
		String path = "src/com/revature/io/serial/Pie.ser";
		Pie p = new Pie("cherry","normal",9);

		try(FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(p);
			System.out.println("we are done serializing our pie");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
