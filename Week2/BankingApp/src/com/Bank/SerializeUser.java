package com.Bank;

import java.awt.List;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class SerializeUser {

	private static String path = "src/com/Bank/User.ser";
	
SerializeUser(){
		super();
		
	}

	
	
	
	
	public static void saveUser(User user) {
		
		
	//	System.out.println("printing from save user serializer" + user);
		
		User[] users = {new User("John", "Edward", "Something"),new User("deri", "Mer", "sole"), new User("Ed", "Haner", "snother")};

		//users[0]= user;
		
		ArrayList<User> userList = new ArrayList<User>(Arrays.asList(users));
		userList.add(user);
		
		
		try(FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(userList);
	
			
			for (User userx: userList) {
				oos.writeObject(userx);
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
		
	
	
public static void updateUser(ArrayList<User> updateArray) {
		
		
	//	System.out.println("printing from update serializer" + updateArray);
		
		
		
		//set append to false so that it can overwrite it
		try(FileOutputStream fos = new FileOutputStream(path, false); ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			
			oos.writeObject(updateArray);
	
			
			for (User userx: updateArray) {
				oos.writeObject(userx);
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
		
	}
	
	
	
	
	

	

