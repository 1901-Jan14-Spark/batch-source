package ioStuff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class MyFileReader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2846883389211925084L;
	
	static String path= "src/ioStuff/bankdata.txt/";
	
		
	
	
public static void main(String[] args) {
		
		try (FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);){
			
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		

	}

}