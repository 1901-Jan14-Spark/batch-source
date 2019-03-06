package com.revature.main;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.model.Account;
import com.revature.model.User;

public class Driver {

	static Scanner input = new Scanner(System.in);
	static UserDaoImpl userDaoImpl = new UserDaoImpl();
	public final static Logger log4j = Logger.getRootLogger();

	public static void main(String[] args) {
//		try {
//			Connection c = ConnectionUtil.getConnectionFromFile();
//			log4j.info(c.getMetaData().getDriverName());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
		welcome();
		}			
	
		 public static void welcome()
		{
		log4j.info("\033[31;1mWelcome!\033[0m, \033[32;1;2m Please choose one of the following options!\033[0m");
		log4j.info("New User Please Register by Entering "+"\033[31;1m1\033[0m");
		log4j.info("To Login, Please Enter "+"\033[31;1m2\033[0m");
		log4j.info("To Exit the Application Please Enter "+"\033[31;1m3\033[0m");
		while(!input.hasNextInt()) {
			 log4j.error("\n\033[31;1mInvalid Input....Please Try Again!\033[0m"+"\n");
		    input.next();
		}
		int choice = input.nextInt();
		
			if (choice== 1)
			    createAccount();
			if (choice== 2)
			    login();
			if (choice== 3)
			{
			log4j.info("\nThank you for visiting, See you other time ");
			System.exit(0);
			}
			else welcome();
		}
	        
			        public static void createAccount()
			        {			    		
			        	log4j.info("\033[31;1mWelcome To the Club!\033[0m, \033[32;1;2m Please Fill Out the Registration Form!\033[0m");
			    		log4j.info("First Name: ");
			    		String fname = input.next();
			    		log4j.info("Last Name: ");
			    		String lname = input.next();
			    		log4j.info("User Name: ");
			    		String username = input.next();	
			    		
						while(userDaoImpl.getUserByUsername(username)!=null) {
							log4j.error("\n\033[31;1mUsername exist....Please Choose An Other username!\033[0m"+"\n");
							username = input.next();
						} 
		    
			    		log4j.info("\033[31;1mPassword\033[0m");
			    		String password = input.next();
			    		log4j.info("\033[31;1mPassword\033[0m");
			    		String confirmPassword = input.next();
			    		 while (!confirmPassword.equals(password)) 
				    		{
				    		    log4j.info("\033[31;1mMISSMATCH PASSWORD\\n Please confirm password:\033[0m");
				    		    confirmPassword = input.next();
				    		}

						User newUser = new User(fname, lname, username,confirmPassword);
						userDaoImpl.createUser(newUser);
						
						log4j.info("\n\033[32;1;2mCongratulations! "+fname.toUpperCase()+" You have just joined the Club !\033[0m\n");
						log4j.info("\n\033[32;1;2mPlease use your credentials to log in !\033[0m\n");
						
						welcome();
			        }
			        
			        
			        
			        
			    			   	 static User currentUser; 
       
	public static void login() 
	{
					        	
	 log4j.info("Enter your username: ");
	 String username = input.next(); 
	 while(userDaoImpl.getUserByUsername(username) == null) 
	 {
		 log4j.error("\n\033[31;1mInvalid username....Please Try Again!\033[0m"+"\n");
	 username = input.next();
	 } 
	 
	 currentUser = userDaoImpl.getUserByUsername(username);
	 log4j.info("Enter Your Password: ");
	 String password = input.next();
	 while(!password.equals(currentUser.getPassword()))
		 { 
			 log4j.info("The Password You have Entered Is Invalid...Please Try Again");
			 password = input.next();	     
	     }
	 
	 log4j.info("\n\033[31;1mLoading....!\033[0m, \033[32;1;2m Please wait to check...\033[0m\n");		
	 accountInfo(currentUser);
	 }	
		 
		 
		        public static void accountInfo(User user){
		       	 log4j.info("Hi "+ user.getFirstName() +" "+ user.getLastName()+"\n");

           	    log4j.info("\033[31;1mWelcome Back!\033[0m, \033[32;1;2m Please choose one of the following options!\033[0m");
	    		log4j.info("To Create Account, Please Enter "+"\033[31;1m1\033[0m");
	    		log4j.info("To Deposite Money, Please Enter "+"\033[31;1m2\033[0m");
	    		log4j.info("To Withdraw Money, Please Enter "+"\033[31;1m3\033[0m");
	    		log4j.info("To Check Your Ballance, Please Enter "+"\033[31;1m4\033[0m");
	    		log4j.info("To Exit the Application Please Enter "+"\033[31;1m5\033[0m");
	    		while(!input.hasNextInt()) {
	   			 log4j.error("\n\033[31;1mInvalid Input....Please Try Again!\033[0m"+"\n");
	   		    input.next();
	   	     	}
	   	    	int choice = input.nextInt();				
				if (choice == 1) 
	    		{
					openAccount(user);
	    		}
		    	if (choice == 2) 
		    		{
		    		deposit(user);
		    		}
		    	if (choice == 3) 
		    	  {
		    		withdraw(user);
		    		}
		    	if (choice == 4) 
		    	{
		    		showBalance(user);
		    	}
		    	if (choice == 5) {
			    		log4j.info("\nThank you for visiting, See you other time ");
			    		 System.exit(0);
		    		}	    	
                   }
		       
		        
   public static void openAccount(User usr) 
   {
	log4j.info("\033[31;1mWelcome!\033[0m, \033[32;1;2m Please choose type of your account \033[0m");
	log4j.info("For Checking Account Enter "+"\033[31;1m1\033[0m");
	log4j.info("For Saving Account Enter "+"\033[31;1m2\033[0m");
	log4j.info("For Credit Line Account Enter "+"\033[31;1m3\033[0m");
	while(!input.hasNextInt()) {
		 log4j.error("\n\033[31;1mInvalid Input....Please Try Again!\033[0m"+"\n");
	    input.next();
	}
	int choice = input.nextInt();
		AccountDaoImpl newAcc = new AccountDaoImpl();
		int id = (int) (1 + Math.random() * 9999);
		Account acc;
		
		if (choice== 1) 
		{
			 acc = new Account(id,0.00, "checking");
			 newAcc.createAccount(acc, usr);
			 log4j.info("\n\033[32;1;2mCongratulations! Your Checking Account Has Just Been Created !\033[0m\n");
			 log4j.info("\n\033[32;1;2mPlease Make A Deposite To Start Shopping! \033[0m\n");
			 accountInfo(usr);
		}
		if (choice== 2) 
		{
			 acc = new Account(id,0.00, "Saving");
			 newAcc.createAccount(acc, usr);
			 log4j.info("\n\033[32;1;2mCongratulations! Your Saving Account Has Just Been Created !\033[0m\n");
			 log4j.info("\n\033[32;1;2mPlease Make A Deposite To Start Saving! \033[0m\n");
			 accountInfo(usr);
		}
		if (choice == 3) 
		{
			 acc = new Account(id,1000.00, "Saving");
			 newAcc.createAccount(acc, usr);
			 log4j.info("\n\033[32;1;2mCongratulations! Your Credit Line Account Has Just Been Activated !\033[0m\n");
			 log4j.info("\n\033[32;1;2mBallance $1000 ,Please Spend it Wisely And Pay it Monthly! \033[0m\n");
			 accountInfo(usr);
		}
		else accountInfo(usr);
		}
   
   
   public static void deposit(User user) {
	   List<Account> userAccounts = new ArrayList<>();
		UserDaoImpl ud = new UserDaoImpl();
		userAccounts = ud.getUserAcounts(user.getUserName());
		
		Account a = null;
			log4j.info("List Of Your Accounts: ");
			for (Account acc: userAccounts) {
				log4j.info("account number: "+acc.getAccountId()+" Type: "+acc.getTypeOfAccount()+" Ballance of:"+acc.getAccountBalance());	
		  }
		
			log4j.info("Which account would you like to withdraw from?");
			while (!input.hasNextInt())
   		     {
		     log4j.info("Please put valid number");
   		     input.next();
   		    }
			int accountId = input.nextInt();
			
			for (int i = 0; i < userAccounts.size(); i++) {
				if (userAccounts.get(i).getAccountId()==accountId) {
					a = userAccounts.get(i);
				}
			}
		log4j.info("Enter the amount of money you'd would like to deposit.");
		while (!input.hasNextDouble())
		{
		    log4j.info("\033[31;1mInvalid input\\n Please Type in the double-type number:\033[0m");
		    input.next();
		}
	    double deposit = input.nextDouble();
	   	if (deposit < 0) 
	   	{
		log4j.info("Transaction failed: invalid deposit amount.");
		}
	   	else {
			a.setAccountBalance(a.getAccountBalance()+(deposit));
			AccountDaoImpl ad = new AccountDaoImpl();
			ad.updateAccount(a);
			log4j.info("$" + deposit + " \033[32;1;2m Was Just Deposited. Your Current Balance Now Is!\033[0m "  + a.getAccountBalance() + ".");
			accountInfo(user);
			}
		}  
   
		public static void withdraw(User user) {
		List<Account> userAccounts = new ArrayList<>();
		UserDaoImpl ud = new UserDaoImpl();
		userAccounts = ud.getUserAcounts(user.getUserName());
				
		Account a = null;
		log4j.info("List Of Your Accounts: ");
		for (Account acc: userAccounts) 
		{
		log4j.info("account number: "+acc.getAccountId()+" Type: "+acc.getTypeOfAccount()+" Ballance of: $"+acc.getAccountBalance());	
		}
				
		log4j.info("Which account would you like to withdraw from?");
		while (!input.hasNextInt())
		{
		log4j.info("Please put valid number");
	    input.next();
		 }
		int accountId = input.nextInt();
					
		for (int i = 0; i < userAccounts.size(); i++)
		{
		if (userAccounts.get(i).getAccountId()==accountId)
			{
		   a = userAccounts.get(i);
			}
		}
		log4j.info("Enter the amount you'd like to withdraw.");
				while (!input.hasNextDouble())
	    		{
	    		    log4j.info("\033[31;1mInvalid input\\n Please Type in the double-type number:\033[0m");
	    		    input.next();
	    		}
	    		double withdraw = input.nextDouble();
				if (withdraw >= a.getAccountBalance()) {
					log4j.info("Transaction failed: invalid withdrawal amount.");
				} else {
					a.setAccountBalance(a.getAccountBalance() - withdraw);
					AccountDaoImpl ad = new AccountDaoImpl();
					ad.updateAccount(a);
					log4j.info("$" + withdraw + "\033[32;1;2m Was Just Withdrawn. Your Current Balance Now Is!\033[0m " + a.getAccountBalance() + ".");
					accountInfo(user);
				}
			}
			
	
			public static void showBalance(User user) {
				List<Account> userAccounts = new ArrayList<>();
				UserDaoImpl ud = new UserDaoImpl();
				userAccounts = ud.getUserAcounts(user.getUserName());
				
				for (Account a: userAccounts) {
					log4j.info("\nAccount Number. " + a.getAccountId() + ": Has Balance of $" + a.getAccountBalance()+"\n");
				}
				accountInfo(user);
			}
} 
			      
     




 