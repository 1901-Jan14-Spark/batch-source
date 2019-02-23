package com.revature.bankapp;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;

public interface ReadWriteManager {

	public static String userFilePath = "src/main/java/com/revature/bankapp/users.txt";
	
	public abstract void writeUser(String nameInput, String usernameInput, String emailInput, String passwordInput, double startingBalance);
	
	public abstract String[] readUser();
	
	public abstract void saveUserChanges(String nameInput, String usernameInput, String emailInput, String passwordInput, double newBalance);
	
	//Or just implement this concrete??
//	public void writeUser(String nameInput, String usernameInput, String emailInput, String passwordInput,
//			double startingBalance) {
//		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(userFilePath, true)))) {
//			pw.println(nameInput+","+usernameInput+","+emailInput+","+passwordInput+","+startingBalance);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}
//
//	@Override
//	public String[] readUser() {
//		try (BufferedReader br = new BufferedReader(new FileReader(userFilePath))) {
//			String userInfo = br.readLine();
//			String[] userInfoArr = userInfo.split(",");
//			return userInfoArr;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
}
