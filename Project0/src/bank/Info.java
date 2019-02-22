package bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
//import java.util.Map;

public class Info {
	
	static HashMap<String, String> users = new HashMap<String, String>();
//	public static void main(String[] args) {
//		setUSer("Hi","Five");
//		getInfo();
//		
//		
//	}
	static String path = "src/bank/UserInfo.txt";
	static void setUser(String username, String password) {
		try(FileWriter fw = new FileWriter(path,true); BufferedWriter bw = new BufferedWriter(fw)){
			bw.append(username+"\n").append(password+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static HashMap<String,String> getInfo() {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String cont = br.readLine();
			String cont2 = br.readLine();
			while(cont2!=null) {
				users.put(cont,cont2);
				cont = br.readLine();
				cont2 = br.readLine();
			}
				//System.out.println(cont);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
}
