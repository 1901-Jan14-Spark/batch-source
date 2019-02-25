package Classes;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank{
	private Scanner scan;
	private User currentUser;
	
	public Bank(Scanner scan)
	{
		this.scan = scan;
	}
	
	public void mainPage()
	{
		int option;
		System.out.println("Welcome to my console bank!\n");
		System.out.println("1) Login");
		System.out.println("2) Register");
		System.out.println("3) Exit");
		try
		{
			option = scan.nextInt();
			switch(option)
			{
				case 1:
				{
					clearConsole();
					loginPage();
				}
				break;
				case 2:
				{
					clearConsole();
					registerPage();
				}
				break;
				case 3:
				{
					clearConsole();
					File f = new File("src/Main/user.ser");
					f.delete();
					System.exit(0);
				}
				default:
				{
					clearConsole();
					System.out.println("Invalid input. Please try again.\n");
					mainPage();
				}
				break;
			}
		}
		catch (InputMismatchException e)
		{
			scan.nextLine();
			clearConsole();
			System.out.println("Invalid input. Please try again.\n");
			mainPage();
		}
	}
	
	private void registerPage()
	{
		String username, password, password2, firstname, lastname;
		System.out.println("Thank you for choosing our bank! Please fill out the form below to register.");
		System.out.print("First Name: ");
		firstname = scan.next();
		System.out.print("Last Name: ");
		lastname = scan.next();
		System.out.print("Username: ");
		username = scan.next();
		System.out.print("Password: ");
		password = scan.next();
		System.out.print("Confirm Password: ");
		password2 = scan.next();
		while(!password2.equals(password))
		{
			System.out.println("Password does not match. Try again.\n");
			System.out.print("Password: ");
			password = scan.next();
			System.out.print("Confirm Password: ");
			password2 = scan.next();
		}
		currentUser = new User(username, password, firstname, lastname);
		if (FileIO.writeUserData(currentUser))
		{
			clearConsole();
			System.out.println("User added successfully!\n");
			mainPage();
		}
		else
		{
			System.out.println("User add failed! Try again.\n");
			registerPage();
		}
	}
	
	private void loginPage()
	{
		String username, password;
		System.out.print("Login: ");
		username = scan.next();
		System.out.print("Password: ");
		password = scan.next();
		currentUser = FileIO.readUserData();
		if (currentUser == null)
		{
			clearConsole();
			System.out.println("There are no users registered. Please register a user.\n");
			registerPage();
		}
		else
		{
			if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password))
			{
				clearConsole();
				userPage();
			}
			else
			{
				clearConsole();
				System.out.println("Username or password is invalid. Please try again.\n");
				mainPage();
			}
		}
	}
	
	private void userPage()
	{
		int option;
		float amount;
		System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!\n");
		System.out.println("Checking: $" + currentUser.getCheckingBalance());
		System.out.println("Saving: $" + currentUser.getSavingBalance() + "\n");
		System.out.println("1) Deposit");
		System.out.println("2) Withdraw");
		System.out.println("3) Exit");
		try
		{
			option = scan.nextInt();
			switch (option)
			{
				case 1:
				{
					clearConsole();
					System.out.println("Choose account type\n");
					System.out.println("1) Checking");
					System.out.println("2) Saving");
					option = scan.nextInt();
					if (option == 1)
					{
						clearConsole();
						System.out.println("Enter deposit amount: ");
						amount = scan.nextFloat();
						currentUser.setCheckingBalance(currentUser.getCheckingBalance() + amount);
						clearConsole();
						userPage();
					}
					else if (option == 2)
					{
						clearConsole();
						System.out.println("Enter deposit amount: ");
						amount = scan.nextFloat();
						currentUser.setSavingBalance(currentUser.getSavingBalance() + amount);
						clearConsole();
						userPage();
					}
					else
					{
						clearConsole();
						System.out.println("Invalid input. Try again.\n");
						System.out.println("Choose account type\n");
						System.out.println("1) Checking");
						System.out.println("2) Saving");
						option = scan.nextInt();
					}
				}
				break;
				case 2:
				{
					clearConsole();
					System.out.println("Choose account type\n");
					System.out.println("1) Checking");
					System.out.println("2) Saving");
					option = scan.nextInt();
					if (option == 1)
					{
						clearConsole();
						System.out.println("Enter withdraw amount: ");
						amount = scan.nextFloat();
						currentUser.setCheckingBalance(currentUser.getCheckingBalance() - amount);
						clearConsole();
						userPage();
					}
					else if (option == 2)
					{
						clearConsole();
						System.out.println("Enter withdraw amount: ");
						amount = scan.nextFloat();
						currentUser.setSavingBalance(currentUser.getSavingBalance() - amount);
						clearConsole();
						userPage();
					}
					else
					{
						clearConsole();
						System.out.println("Invalid input. Try again.\n");
						System.out.println("Choose account type\n");
						System.out.println("1) Checking");
						System.out.println("2) Saving");
						option = scan.nextInt();
					}
				}
				break;
				case 3:
				{
					clearConsole();
					FileIO.writeUserData(currentUser);
					mainPage();
				}
				break;
				default:
				{
					clearConsole();
					System.out.println("Invalid input. Try Again\n");
					userPage();
				}
				break;
			}
		}
		catch (InputMismatchException e)
		{
			scan.nextLine();
			clearConsole();
			System.out.println("Invalid input. Try Again\n");
			userPage();
		}
	}
	
	private void clearConsole()
	{
		for (int i = 0; i < 50; ++i) {
			System.out.println();
		}
	}
}
