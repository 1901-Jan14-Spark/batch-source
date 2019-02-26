package ioStuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class MyFileWriter implements Serializable{


	private static final long serialVersionUID = -4676779531031359173L;

	static Scanner input = new Scanner(System.in);
	static String path1 = "src/ioStuff/logincheck.txt"; 
	static String path= "src/ioStuff/bankdata.txt/";
	static String message = "Successful Login";
	static String path3 = "src/ioStuff/data.txt";
	static int balance;
	
	//could try to use array list to target numbers or index 3 atm
//	public static void readerTest() {
//		try (FileReader fr1 = new FileReader(path3);
//				BufferedReader test = new BufferedReader(fr1); ){
//			int num = input.nextInt();
//			String nums = input.nextLine();
//			while(nums!=null) {
//				test.readLine();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
//	}
	
	public static boolean readerCompare() {
		try (FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);
			FileReader fr1 = new FileReader(path1); 
				BufferedReader br1 = new BufferedReader(fr1);){
			
			String bankdata = br.readLine();
			String logincheck = br1.readLine();
			while(bankdata != null||logincheck !=null) {
				bankdata=br.readLine();
				logincheck = br1.readLine();
				if(bankdata.equals(logincheck)) {
					return true;
				}
				else {
					return false;
				}
				}
						}
			
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;		

	}
	public static void menu() {
		System.out.println("Are You A New User? Please Enter 'true' or 'false;");
		boolean userChoice = input.nextBoolean();
		if(userChoice == true) {
		input.nextLine();
			makeNew();
		}
		else if(userChoice == false) {
			credentials();
		}
	
	}

	public static void makeNew() {
		System.out.println("Welcome New User!!!");
		System.out.println("Please Provide New Username");
		String words = input.nextLine();
		try(FileWriter fw = new FileWriter(path,true); 
				BufferedWriter bw = new BufferedWriter(fw)){
			
			bw.append("UserName: "+words+"\n");
			System.out.println();
			System.out.println("Please Enter New Password");
			
			String password = input.nextLine();
			bw.append("Password: "+password+"\n");
			System.out.println();
					

			System.out.println("Please Enter Starting Amount");
			input.hasNextLine();
			 balance = input.nextInt();
			bw.append("Password: "+balance+"\n");
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			menu();
		}
	}
	
	public static void credentials() {
		System.out.println("Welcome Please Log In");
		System.out.println();
		try(FileWriter fw = new FileWriter(path1,true); 
				BufferedWriter bw = new BufferedWriter(fw)){
			System.out.println("Please Provide Username");
			input.nextLine();
			String words = input.nextLine();

			bw.append("UserName: "+words+"\n");
			System.out.println();
			
			System.out.println("Please Enter Password");
			input.hasNextLine();
			String password = input.nextLine();
			bw.append("Password: "+password+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(readerCompare()==true) {
				System.out.println("Login Success");
				System.out.println();
				logedIn();
			}
			else if(readerCompare() == false) {
				System.out.println("Login Fail");
				
			}
		}

	}
	
	public static void logOut() {
		System.out.println("User Logged Off");	
		System.exit(0);
	}
	
	public static void logedIn() {
		System.out.println();
		System.out.println("Your Available Balance is: $"+balance);
		System.out.println();
		System.out.println("To Deposit Press 1,\n to Withdraw press 2 \n to Log Out Press 3");
		int choice = input.nextInt();
		if(choice ==1) {
			deposit();
		}
		else if(choice == 2) {
			withdraw();
		}
		else if(choice == 3) {
			logOut();
		}
		
	}
	
	public static void deposit() {
		System.out.println("How Much Would You Like to Deposit");
		int amount = input.nextInt();
		balance = balance +amount;		
		logedIn();
	}
	public static void withdraw() {
		System.out.println("How Much Would You Like to Withdraw");
		int amount = input.nextInt();
		balance = balance-amount;
		logedIn();
	}
	public static void main(String[] args) {

	menu();
	}
}