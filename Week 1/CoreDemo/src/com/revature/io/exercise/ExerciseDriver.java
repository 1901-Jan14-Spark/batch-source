package com.revature.io.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExerciseDriver {

	public static void main(String[] args) {
		count();
		
		

	}
	
	public static boolean count() {
		String path = "src/com/revature/io/exercise/count.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			int currentVal;
			if(line!=null && line.matches("^\\d+$")) {
				currentVal = Integer.parseInt(line);
			} else {
				resetCount();
				currentVal = 0;
			}
			
			currentVal++;
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
				bw.write(String.valueOf(currentVal));
				return true;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found :( \n ...but, creating it for you :)");
		
		
			 FileOutputStream fout = null;
	
			
			 try {
				fout = new FileOutputStream("src/com/revature/io/exercise/count.txt");
				count();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		return false;
	}
	
	public static void resetCount() {
		
	}

}
