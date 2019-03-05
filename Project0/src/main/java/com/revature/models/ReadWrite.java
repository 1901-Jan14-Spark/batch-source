package com.revature.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class ReadWrite {
	// incrementing id --------------------------------------------------------------------------------------------------------------
			static String path="src/main/java/com/revature/models/IDcounter.txt";
			static String path2="src/main/java/com/revature/models/usernameList.ser";
			public static int getCount() {
				int x=5;
				try (FileReader fr = new FileReader(path);
						BufferedReader br = new BufferedReader(fr);){
					
					String line = br.readLine();
					 x=Integer.parseInt(line);
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} return x;
			
		}
			
		public static void writeCount(int id) {
			String y=Integer.toString(id);
			try(FileWriter fw = new FileWriter(path); BufferedWriter bw = new BufferedWriter(fw)){
				
				bw.append(y);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
				
				
		}	
		// incrementing id --------------------------------------------------------------------------------------------------------------
	public static ArrayList<String> userlist=new ArrayList<String>();
		public static boolean checkUsername(String user) {
		try(FileInputStream fis = new FileInputStream(path2); 
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			 userlist = (ArrayList<String>) ois.readObject();
			
			if(userlist.contains(user)) {
				return true;
			}else {return false;
			}
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException d1) {
			// TODO Auto-generated catch block
			d1.printStackTrace();
		} catch (ClassNotFoundException d2) {
			// TODO Auto-generated catch block
			d2.printStackTrace();
		}
		return true;
		}
		public static void addUsername(String user) {
			
			try(FileOutputStream fos = new FileOutputStream(path2); ObjectOutputStream oos = new ObjectOutputStream(fos)){
			 userlist.add(user);
				oos.writeObject(userlist);
			
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
	
}
