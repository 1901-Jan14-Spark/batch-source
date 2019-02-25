package ioStuff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class ActualBanking {
	static String data = "src/ioStuff/data.txt";
	public static void reader() {
		try (FileReader fr = new FileReader(data);
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
	
	public void deposit() {
		
		
	}
	public static void main(String[] args) {
		reader();
	}
}