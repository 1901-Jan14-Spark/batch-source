package Classes;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Bank{
	final private static Scanner scan = new Scanner(System.in);
	private static User currentUser;
	private static Logger log = Logger.getRootLogger();
	
	public static void mainPage()
	{
		int option;
		log.info("Welcome to my console bank!\n");
		log.info("1) Login");
		log.info("2) Register");
		log.info("3) Clear user");
		log.info("4) Exit");
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
						log.info("User removed successfully\n");
						mainPage();
					}
					else
					{
						clearConsole();
						log.info("No user to remove\n");
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
					log.info("Please chose options 1-4. Please try again.\n");
					mainPage();
				}
				break;
			}
		}
		catch (InputMismatchException e)
		{
			scan.nextLine();
			clearConsole();
			log.info("Input was not an integer value. Please try again.\n");
			mainPage();
		}
	}
	
	private static void registerPage()
	{
		String username, password, password2, firstname, lastname;
		log.info("Thank you for choosing our bank! Please fill out the form below to register.");
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
			log.info("Password does not match. Try again.\n");
			System.out.print("Password: ");
			password = scan.next();
			System.out.print("Confirm Password: ");
			password2 = scan.next();
		}
		currentUser = new User(username, password, firstname, lastname);
		if (FileIO.writeUserData(currentUser))
		{
			clearConsole();
			log.info("User added successfully!\n");
			mainPage();
		}
		else
		{
			log.info("User add failed! Try again.\n");
			registerPage();
		}
	}
	
	private static void loginPage()
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
			log.info("There are no users registered. Please register a user.\n");
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
				log.info("Username or password is invalid. Please try again.\n");
				mainPage();
			}
		}
	}
	
	private static void userPage()
	{
		int option;
		float amount;
		log.info("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!\n");
		System.out.print("Checking: $");
		System.out.printf("%.2f", currentUser.getCheckingBalance());
		System.out.print("\nSaving: $");
		System.out.printf("%.2f", currentUser.getSavingBalance());
		log.info("\n\n1) Deposit");
		log.info("2) Withdraw");
		log.info("3) Exit");
		try
		{
			option = scan.nextInt();
			switch (option)
			{
				case 1:
				{
					clearConsole();
					log.info("Choose account type\n");
					log.info("1) Checking");
					log.info("2) Saving");
					log.info("3) Exit");
					option = scan.nextInt();
					switch(option)
					{
						case 1:
						{
							clearConsole();
							log.info("Enter deposit amount: ");
							amount = scan.nextFloat();
							if (amount < 0)
							{
								clearConsole();
								log.info("Negative values not allowed. Try again.\n");
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
							log.info("Enter deposit amount: ");
							amount = scan.nextFloat();
							if (amount < 0)
							{
								clearConsole();
								log.info("Negative values not allowed. Try again.\n");
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
							log.info("Please chose option 1-3. Try again.\n");
							userPage();
						}
					}
				}
				break;
				case 2:
				{
					clearConsole();
					log.info("Choose account type\n");
					log.info("1) Checking");
					log.info("2) Saving");
					log.info("3) Exit");
					option = scan.nextInt();
					switch(option)
					{
						case 1:
						{
							clearConsole();
							log.info("Enter withdraw amount: ");
							amount = scan.nextFloat();
							if (amount < 0)
							{
								clearConsole();
								log.info("Negative values not allowed. Try again.\n");
								userPage();
							}
							if (currentUser.getCheckingBalance() < amount)
							{
								clearConsole();
								log.info("Insufficient funds. Try again.\n");
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
							log.info("Enter withdraw amount: ");
							amount = scan.nextFloat();
							if (amount < 0)
							{
								clearConsole();
								log.info("Negative values not allowed. Try again.\n");
								userPage();
							}
							if (currentUser.getSavingBalance() < amount)
							{
								clearConsole();
								log.info("Insufficient funds. Try again.\n");
								userPage();
							}
							if (currentUser.getSavingBalance() - amount < 5)
							{
								clearConsole();
								log.info("Cannot withdraw below initial saving balance. Try again.\n");
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
							log.info("Please chose option 1-3. Try again.\n");
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
					log.info("Please chose option 1-3. Try Again\n");
					userPage();
				}
				break;
			}
		}
		catch (InputMismatchException e)
		{
			scan.nextLine();
			clearConsole();
			log.info("Input was not an integer value. Try Again\n");
			userPage();
		}
	}
	
	private static void clearConsole()
	{
		for (int i = 0; i < 50; ++i) {
			log.info("");
		}
	}
}
