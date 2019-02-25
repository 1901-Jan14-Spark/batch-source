package com.Bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializeUser {
	private static String path = "src/com/Bank/User.ser";
	private static ArrayList<User> userList;
	
	DeserializeUser(){
		super();
		
	}

	
 
	
	
public static ArrayList<User> retrieveUser() {
	
	
	 
	
	ArrayList<User> userListT = null;
	
	
	try(FileInputStream fis = new FileInputStream(path); 
			ObjectInputStream ois = new ObjectInputStream(fis)){
		
		//User[] user = (User[]) ois.readObject();
	//	@SuppressWarnings("unchecked")	
		 userListT  = (ArrayList<User>)ois.readObject();
		
		

		//System.out.println(userList);
		
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

	
	return userListT;
	
}








public ArrayList<User> getUserList() {
	return userList;
}








public static void setUserList(ArrayList<User> userListT) {
	userList = userListT;
}

	
	
		
		
	
	
	
	
	
	
	
	
	
	
		
	}
	
	
	
	
	
	
	
