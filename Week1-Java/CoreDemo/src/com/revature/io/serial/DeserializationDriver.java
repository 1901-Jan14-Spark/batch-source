package com.revature.io.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDriver {

	public static void main(String[] args) {
		String path = "src/com/revature/io/serial/Pie.ser";
		
		try(FileInputStream fis = new FileInputStream(path); 
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Pie p = (Pie) ois.readObject();
			System.out.println(p);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
