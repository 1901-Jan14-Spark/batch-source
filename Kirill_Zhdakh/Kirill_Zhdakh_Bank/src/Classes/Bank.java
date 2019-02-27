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
		System.out.println("3) Clear user");
		System.out.println("4) Exit");
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
					File f = new File("src/Main/user.ser");
					if (f.delete())
					{
						clearConsole();
						System.out.println("User removed successfully\n");
						mainPage();
					}
					else
					{
						clearConsole();
						System.out.println("No user to remove\n");
						mainPage();
					}
				}
				break;
				case 4:
				{
					clearConsole();
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
		System.out.print("Username: ");
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
		System.out.print("Checking: $");
		System.out.printf("%.2f", currentUser.getCheckingBalance());
		System.out.print("\nSaving: $");
		System.out.printf("%.2f", currentUser.getSavingBalance());
		System.out.println("\n\n1) Deposit");
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
					System.out.println("3) Exit");
					option = scan.nextInt();
					switch(option)
					{
						case 1:
						{
							clearConsole();
							System.out.println("Enter deposit amount: ");
							amount = scan.nextFloat();
							if (amount < 0)
							{
								clearConsole();
								System.out.println("Invalid input. Try again.\n");
								userPage();
							}
							currentUser.setCheckingBalance(currentUser.getCheckingBalance() + amount);
							clearConsole();
							FileIO.writeUserData(currentUser);
							userPage();
						}
						break;
						case 2:
						{
							clearConsole();
							System.out.println("Enter deposit amount: ");
							amount = scan.nextFloat();
							if (amount < 0)
							{
								clearConsole();
								System.out.println("Invalid input. Try again.\n");
								userPage();
							}
							currentUser.setSavingBalance(currentUser.getSavingBalance() + amount);
							clearConsole();
							FileIO.writeUserData(currentUser);
							userPage();
						}
						break;
						case 3:
						{
							clearConsole();
							userPage();
						}
						break;
						default:
						{
							clearConsole();
							System.out.println("Invalid input. Try again.\n");
							userPage();
						}
					}
				}
				break;
				case 2:
				{
					clearConsole();
					System.out.println("Choose account type\n");
					System.out.println("1) Checking");
					System.out.println("2) Saving");
					System.out.println("3) Exit");
					option = scan.nextInt();
					switch(option)
					{
						case 1:
						{
							clearConsole();
							System.out.println("Enter withdraw amount: ");
							amount = scan.nextFloat();
							if (amount < 0)
							{
								clearConsole();
								System.out.println("Invalid input. Try again.\n");
								userPage();
							}
							if (currentUser.getCheckingBalance() < amount)
							{
								clearConsole();
								System.out.println("\nInvalid amount. Try again.");
								userPage();
							}
							currentUser.setCheckingBalance(currentUser.getCheckingBalance() - amount);
							clearConsole();
							FileIO.writeUserData(currentUser);
							userPage();
						}
						break;
						case 2:
						{
							clearConsole();
							System.out.println("Enter withdraw amount: ");
							amount = scan.nextFloat();
							if (amount < 0)
							{
								clearConsole();
								System.out.println("Invalid input. Try again.\n");
								userPage();
							}
							if (currentUser.getSavingBalance() < amount)
							{
								clearConsole();
								System.out.println("\nInvalid amount. Try again.");
								userPage();
							}
							currentUser.setSavingBalance(currentUser.getSavingBalance() - amount);
							clearConsole();
							FileIO.writeUserData(currentUser);
							userPage();
						}
						break;
						case 3:
						{
							clearConsole();
							userPage();
						}
						break;
						default:
						{
							clearConsole();
							System.out.println("Invalid input. Try again.\n");
							userPage();
						}
						break;
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
