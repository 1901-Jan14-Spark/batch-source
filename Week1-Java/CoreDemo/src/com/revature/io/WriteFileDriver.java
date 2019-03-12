package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
	
	static String path = "src/com/revature/io/write_data.txt"; 
	static String content = "Greetings Earthling\n";

	public static void main(String[] args) {
		
		try(FileWriter fw = new FileWriter(path,true); BufferedWriter bw = new BufferedWriter(fw)){
			
			bw.append(content).append(content);
			System.out.println("Our file has been written");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
