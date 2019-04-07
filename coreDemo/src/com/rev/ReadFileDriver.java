package com.rev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
	static String path = "src/com/rev/read_data.txt";
public static void main(String[] args) {
	
	try(FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr)) {
	String line = br.readLine();
	while(line != null) {
		System.out.println(line);
		line = br.readLine();
	}
	
	
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e1) {
		e1.printStackTrace();
	}

}
}
