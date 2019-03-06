package classes;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import dao.UserDaoImpl;
import util.PasswordEncryption;

public class Bank{
	//Bank necessities 
	final private static Scanner scan = new Scanner(System.in);
	private static User currentUser;
	final private static Logger log = Logger.getRootLogger();
	
	//DB
	final private static UserDaoImpl udl = new UserDaoImpl();
	private static List<User> userList;
	
	public static void mainPage()
	{
		int option;
		log.info("Welcome to my console bank!\n");
		log.info("1) Login");
		log.info("2) Register");
		log.info("3) Exit");
		try
		{
			option = scan.nextInt();
			switch(option)
			{
				case 1:
				{
					clearConsole();
					scan.nextLine();
					loginPage();
				}
				break;
				case 2:
				{
					clearConsole();
					scan.nextLine();
					registerPage();
				}
				break;
				case 3:
				{
					clearConsole();
					System.exit(0);
				}
				default:
				{
					clearConsole();
					log.info("Please chose options 1-3. Please try again.\n");
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
		userList = udl.getUsers();
		String username, password, password2, firstname, lastname;
		log.info("Thank you for choosing our bank! Please fill out the form below to register.\n");
		log.info("Password Rules");
		log.info("- Password must be at least 8 characters long");
		log.info("- Password must contain at least 1 number");
		log.info("- Password must contain at least 1 capital letter");
		log.info("- Password must contain at least 1 lower case letter");
		log.info("- Password must contain at least 1 special character (!, @, #, $, %, ^, &, *)\n");
		log.info("First Name: (type \"refresh\" to reset form, \"exit\" to exit)");
		
		//First name, last name
		firstname = scan.nextLine();
		while (!firstname.matches("[A-Za-z]+"))
		{
			log.info("\nName must be alphabetic characters only. Try again.\n");
			log.info("First Name: (type \"refresh\" to reset form, \"exit\" to exit)");
			firstname = scan.nextLine();
		}
		if (firstname.toLowerCase().equals("refresh"))
		{
			clearConsole();
			registerPage();
		}
		if (firstname.toLowerCase().equals("exit"))
		{
			clearConsole();
			mainPage();
		}
		log.info("Last Name: (type \"refresh\" to reset form, \"exit\" to exit)");
		lastname = scan.nextLine();
		while (!lastname.matches("[A-Za-z]+"))
		{
			log.info("\nName must be alphabetic characters only. Try again.\n");
			log.info("Last Name: (type \"refresh\" to reset form, \"exit\" to exit)");
			lastname = scan.nextLine();
		}
		if (lastname.toLowerCase().equals("refresh"))
		{
			clearConsole();
			registerPage();
		}
		if (lastname.toLowerCase().equals("exit"))
		{
			clearConsole();
			mainPage();
		}
		
		//Username
		username = "";
		while(true)
		{
			boolean userTaken = false;
			log.info("Username: (type \"refresh\" to reset form, \"exit\" to exit)");
			username = scan.nextLine();
			if (username.toLowerCase().equals("refresh"))
			{
				clearConsole();
				registerPage();
			}
			if (username.toLowerCase().equals("exit"))
			{
				clearConsole();
				mainPage();
			}
			if (username.length() <= 4)
			{
				log.info("\nUsername must be at least 5 characters. Try again.\n");
				continue;
			}
			for(User u : userList)
			{
				if (u.getUsername().equals(username))
				{
					log.info("\nUser already taken. Try again.");
					userTaken = true;
					break;
				}
			}
			if (userTaken)
				continue;
			else
				break;
		}
		
		//Password
		log.info("Password: (type \"refresh\" to reset form, \"exit\" to exit)");
		password = scan.nextLine();
		if (password.toLowerCase().equals("refresh"))
		{
			clearConsole();
			registerPage();
		}
		if (password.toLowerCase().equals("exit"))
		{
			clearConsole();
			mainPage();
		}
		while(!password.matches("^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9])(?=\\S*?[!@#$%^&*]).{8,})\\S$"))
		{
			clearConsole();
			log.info("Password Rules");
			log.info("- Password must be at least 8 characters long");
			log.info("- Password must contain at least 1 number");
			log.info("- Password must contain at least 1 capital letter");
			log.info("- Password must contain at least 1 lower case letter");
			log.info("- Password must contain at least 1 special character (!, @, #, $, %, ^, &, *)\n");
			log.info("Password: (type \"refresh\" to reset form, \"exit\" to exit)");
			password = scan.nextLine();
			if (password.toLowerCase().equals("refresh"))
			{
				clearConsole();
				registerPage();
			}
			if (password.toLowerCase().equals("exit"))
			{
				clearConsole();
				mainPage();
			}
		}
		log.info("Confirm Password: (type \"refresh\" to reset form, \"exit\" to exit)");
		password2 = scan.nextLine();
		if (password2.toLowerCase().equals("refresh"))
		{
			clearConsole();
			registerPage();
		}
		if (password2.toLowerCase().equals("exit"))
		{
			clearConsole();
			mainPage();
		}
		while(!password2.equals(password))
		{
			log.info("Password does not match. Try again.\n");
			log.info("Password: ");
			password = scan.nextLine();
			log.info("Confirm Password: ");
			password2 = scan.nextLine();
		}	
		
		//Adding user
		firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1).toLowerCase();
		lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1).toLowerCase();		
		if (udl.createUser(new User(firstname, lastname, username, password, 0, 5)))
		{
			clearConsole();
			log.info("User added successfully!\n");
			mainPage();
		}
		else
		{
			log.info("User add failed! Try again.\n");
			mainPage();
		}
	}
	
	private static void loginPage()
	{
		userList = udl.getUsers();
		if (userList.size() == 0)
		{
			clearConsole();
			log.info("There are no users registered. Please register a user.\n");
			mainPage();
		}
		String username, password;
		log.info("Username: ");
		username = scan.nextLine();
		log.info("Password: ");
		password = scan.nextLine();
		for (User u : userList)
		{
			String decodedPass = PasswordEncryption.decodePassword((u.getPassword()));
			if (u.getUsername().equals(username) && decodedPass.equals(password))
			{
				currentUser = u;
				break;
			}
		}
		if (currentUser == null)
		{
			clearConsole();
			log.info("No user with that username and password combination. Please try again.\n");
			mainPage();
		}
		else
		{
			clearConsole();
			userPage();
		}
	}
	
	private static void userPage()
	{
		int option;
		float amount;
		log.info("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!\n");
		log.info("Checking: $" + currentUser.getCheckingBalance());
		log.info("Saving: $" + currentUser.getSavingBalance());
		log.info("\n1) Deposit");
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
							amount = Float.parseFloat(String.format("%.2f", scan.nextFloat()));
							if (amount < 0)
							{
								clearConsole();
								log.info("Negative values not allowed. Try again.\n");
								userPage();
							}
							currentUser.setCheckingBalance(currentUser.getCheckingBalance() + amount);
							clearConsole();
							if (!udl.updateUser(currentUser))
								log.info("Transaction failed.\n");
							udl.updateTransactionDate(currentUser);
							userPage();
						}
						break;
						case 2:
						{
							clearConsole();
							log.info("Enter deposit amount: ");
							amount = Float.parseFloat(String.format("%.2f", scan.nextFloat()));
							if (amount < 0)
							{
								clearConsole();
								log.info("Negative values not allowed. Try again.\n");
								userPage();
							}
							currentUser.setSavingBalance(currentUser.getSavingBalance() + amount);
							clearConsole();
							if (!udl.updateUser(currentUser))
								log.info("Transaction failed.\n");
							udl.updateTransactionDate(currentUser);
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
							amount = Float.parseFloat(String.format("%.2f", scan.nextFloat()));
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
							if (!udl.updateUser(currentUser))
								log.info("Transaction failed.\n");
							udl.updateTransactionDate(currentUser);
							userPage();
						}
						break;
						case 2:
						{
							clearConsole();
							log.info("Enter withdraw amount: ");
							amount = Float.parseFloat(String.format("%.2f", scan.nextFloat()));
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
							if (!udl.updateUser(currentUser))
								log.info("Transaction failed.\n");
							udl.updateTransactionDate(currentUser);
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
					currentUser = null;
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
