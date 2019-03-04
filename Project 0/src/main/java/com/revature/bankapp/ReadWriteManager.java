package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.revature.bankapp.models.Account;

public interface ReadWriteManager {

	public static String userFilePath = "src/main/java/com/revature/bankapp/users.txt";
	
	public default void writeUser(String nameInput, String usernameInput, String emailInput, String passwordInput,
			Account newAcc) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(userFilePath, true)))) {
			pw.println(nameInput+","+usernameInput+","+emailInput+","+passwordInput+","+newAcc);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public default void saveUserChanges(String nameInput, String usernameInput, String emailInput, String passwordInput,
			double newBalance) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFilePath))) {
			bw.write(nameInput+","+usernameInput+","+emailInput+","+passwordInput+","+newBalance);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public default String[] readUser() {
		try (BufferedReader br = new BufferedReader(new FileReader(userFilePath))) {
			String line;
			while ((line = br.readLine()) != null) {
			String[] userInfoArr = line.split(",");
			return userInfoArr;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
	

