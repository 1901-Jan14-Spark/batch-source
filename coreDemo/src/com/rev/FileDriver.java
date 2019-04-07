package com.rev;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileDriver {
	static String path = "src/com/rev/write_data.txt";
	static String content = "Sup World\n";
	
public static void main(String[] args) {
	
	try(FileWriter fw = new FileWriter(path); BufferedWriter bw = new BufferedWriter(fw)){
		bw.append(content).append(content);
		System.out.println("Our File has bee written");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
