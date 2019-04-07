package com.rev.sub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Increment {
	static String path = "src/com/rev/sub/num.txt";

	public static void main(String[] args) {
		
		try(FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr)){
			int numer = br.read();
			for (int n:numer) {
			numer = numer +1;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(FileWriter fw = new FileWriter(path); BufferedWriter bw = new BufferedWriter(fw)){
			bw.append(numer).append(numer);
		}
		
	
}
}


