package com.Bank;


import java.util.Observable;
import java.util.Scanner;


public class BankView  extends Observable {

	
	private  Scanner SC ;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private int balance;
	private int enterdValue;
	private boolean status;
	private String enterdUsername;
	private String logedinAs;
	private boolean userNameExists;
	

	
	BankView(){
		super();
		 SC = new Scanner(System.in);
	//	mainMenuFlow();
		 this.setLogedinAs(null);
		
	 
		
	}

	
	

	public BankView(String userName, String firstName, String lastName, String password, int balance) {
		super();
		 SC = new Scanner(System.in);
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.balance = balance;
	}




	public String getEnterdUsername() {
		return enterdUsername;
	}

	public void setEnterdUsername(String enterdUsername) {
		this.enterdUsername = enterdUsername;
	}


	
	public void rootPage() {
		
        
         splashPage();
		 handleLogInOption();
		 
		 if (this.getLogedinAs() != null) {
		 homePage();
		 }
		//choice = handleLogInOption();
		
		
		
	}
	
	public void splashPage() {
		
		//depositMenu();
		 System.out.println("----------------------------------------------------------------------------------\n"
		 		+ "                  Welcome to Bank of Ruptcy");
		 System.out.println("\n          Please Choose from the following option:");
	
		 
		
		 
	}
	
	public void homePage() {
		 System.out.println("----------------------------------------------------------------------------------\n"
		 		+ "                           HomePage");
		 System.out.println("\n Logged in as " + userName + "                                    Welcome home " + firstName + " " + lastName);
		
		 System.out.println("\n         Your balance - " + balance);
	
		 System.out.println("\n         Press:\n            [X] - Deposit  [Y] - Withdraw  [E] - Logout ");
		
		 handleTransactionOption();
	}
	
	
	
	
	
	
	
	
	
	private void handleTransactionOption() {
		
		 String transactionChoice = SC.nextLine();
			// String choice = "";
		//	 System.out.println(transactionChoice);
			 

			 while( !transactionChoice.equals("x") &&  !transactionChoice.equals("y") && !transactionChoice.equals("X") &&  !transactionChoice.equals("Y") &&  !transactionChoice.equals("E") &&  !transactionChoice.equals("e") ) {
					System.out.println("               Please Enter the right choice or press E to end the apllication");
					transactionChoice = SC.nextLine();
				}
			 
			 
			 if (transactionChoice.equals("x") || transactionChoice.equals("X") ) {
				 depositMenu();
				
			} else if (transactionChoice.equals("y") || transactionChoice.equals("Y") ){
				withdrawMenu(); 
		}else if (transactionChoice.equals("e") || transactionChoice.equals("E") ){
			logout();
	}
			else {
				System.out.println("unexpected error occured, returning back to menu");
				 handleLogInOption();
				
			}
		
		
		
		
		
		
		
		
	}

	private void depositMenu() {
		
		
          //post enterred value to global var to be picked up by controller
		 System.out.print("Deposit: \n ");
		 this.enterdValue =  validateInt();
		
		 setChanged(); 
		notifyObservers("depositAmount");
		System.out.println("\n Transaction status: " ) ;
		System.out.println ( status? " success": " fail");
		 
		System.out.println("\n New Balance Amount: " ) ;
		System.out.println (" "+ this.balance);
		
		//update profile balance
		this.enterdValue = this.balance;
		setChanged(); 
		notifyObservers("updateBalance");
		
		homePage();
		
	}
	
	private void withdrawMenu() {
		
		 System.out.print("Withdraw: \n ");
        //post enterred value to global var to be picked up by controller
		 this.enterdValue =  validateInt();
		
		 setChanged(); 
		notifyObservers("withdrawAmount");
		System.out.println("\n Transaction status: " ) ;
		System.out.println ( status? " success": " insufficient funds");
		
		//ask to save new balance if 
		
		 
		System.out.println("\n New Balance Amount: " ) ;
		System.out.println (" "+ this.balance);
		
		homePage();
		
	}
	
	public int validateInt() {
		
		int value;
		do {
            System.out.print("Please enter the amount ");
            while (!SC.hasNextInt()) {
                String input = SC.next();
                System.out.printf("\"%s\" is not a valid entry.\n", input);
            }
            value = SC.nextInt();
        } while (value < 0);

        System.out.printf("You have entered an amoount of %d.\n", value);
        
        
        
        return value;
    }
		//return value;
		

		
		
	

	public void  handleLogInOption() {
		
		 System.out.println("\n         Press:\n            [x] - Create Account  [Y] - Log IN");
		 
		 String logInChoice = SC.nextLine();
		// String choice = "";
		 System.out.println(logInChoice);
		 

		 while( !logInChoice.equals("x") &&  !logInChoice.equals("y") && !logInChoice.equals("X") &&  !logInChoice.equals("Y") &&  !logInChoice.equals("e") &&  !logInChoice.equals("E") ) {
				System.out.println("               Please Enter the right choice or press E to end the apllication");
				logInChoice = SC.nextLine();
			}
		 
		 
		 if (logInChoice.equals("x") || logInChoice.equals("X") ) {
			 createAccountPage();
			
		} else if (logInChoice.equals("y") || logInChoice.equals("Y") ){
			logInmenu(); 
	}else if (logInChoice.equals("e") || logInChoice.equals("E") ){
		logout(); 
}
		else {
			System.out.println("unexpected error occured, returning back to menu");
			 handleLogInOption();
			
		}
		 

	}
	
	
	
	





	public void logInmenu() {
		System.out.println("\n         Please enter your credentials and press enter" );
		
		 String userNameT = SC.nextLine();
		
		 //check for invalid entry
		 if (!validateUsernameString(userNameT)){
			 System.out.println("\n      Invalid entry, please try again" );
			 logInmenu();
			 
		 }
		   this.enterdUsername = userNameT;
			setChanged(); 
			notifyObservers("logIn");
		
		
	
	}
	
	
	public void createAccountPage() {
		
		
		
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("\n      Thank you for choosing Bank of Ruptcy where you know your money is always safe with us. \n"
				+ "               As a token of appreciation we will deposit a free 10$ on your new account.\n"
				+ "                   Just follow directions to create and start your new account!! \n"
				+ " \n                   Please enter your First Name and last name \n    " );
		

		String name = SC.nextLine();
		//System.out.println(name);
		validateandSetName(name);
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("\n                       Please enter a 6 or more digits new password: " );
		String password = SC.nextLine();
		validateAndSetPassword(password);
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("\n       Please enter a prefered username that includes only numbers and letters " );
		
		String userNameT = SC.nextLine();
		validateAndSetUserName(userNameT);
  
		
		this.balance = 10;
		setChanged(); 
		notifyObservers("CreateNewAccount");
		System.out.println("\n       Account Page Created!! transferring you to your new homepage!!!... " );
		
		
		 
		
		
	
		
	}


	
	private void logout() {
		
		
		//call controller to clear out session object
		 setChanged(); 
		notifyObservers("loggedout");
		
		rootPage();
	
	}
	
	
	
	private void validateAndSetUserName(String userNameT) {
		
	
	
	while( !validateUsernameString(userNameT)) {
		System.out.println("       Invalid Input, please enter text with letters/numbers");
		userNameT = SC.nextLine();
		
	}
	//check to see if username already exists
	this.enterdUsername = userNameT;
	 setChanged(); 
	notifyObservers("checkUserNameExist");
		
	//if its false then we can assign the user to new username
	
	
	
	if (this.isUserNameExists() == false) {
	this.userName = userNameT;
	this.setLogedinAs(userNameT);
	}  //else tell the user to use another user name
	else {
		
		System.out.println("       Sorry, the username is taken, choose another one");
		createAccountPage();
	}
	
	//System.out.println(userNameT);
	}

	public boolean validateUsernameString(String userName) {
		
		
		 if (!userName.matches("[a-zA-Z0-9]*")) {
			 
			 return false;
		 }
		return true;
		
		
	}
	public void validateandSetName(String name) {
		

		
		
		while(name.split(" ").length != 2) {
			System.out.println("       Incorrect format. Please enter again in the following format: firstname lastname");
			name = SC.nextLine();
			
		
		}
		String[] splitName = name.split(" ");
        String firstNameT = splitName[0];
		String lastNameT = splitName[1];
	    
		
	
		if(!validateNameString(firstNameT) || !validateNameString(lastNameT)  ) {
			System.out.println("       Invalid entry, please try again");
			name = SC.nextLine();
			validateandSetName(name);
		}
		
		
		//System.out.println("printing name" + firstNameT + lastNameT);
		
	      setFirstName(firstNameT);
	      setLastName(lastNameT);
		
	}
	
	public boolean validateNameString(String userName) {
		
		
		 if (!userName.matches("[a-zA-Z]*")) {
			 
			 return false;
		 }
		return true;
		
		
	}
	
	public void validateAndSetPassword(String passwordArg) {
		
		while(passwordArg.split(" ").length != 1) {
			System.out.println("       Password cannot be empty or have space, please enter a valid password");
			passwordArg = SC.nextLine();
			
		
		}
		
		
		
		
	  while(passwordArg.length() < 6 ){
		  
		  if (passwordArg.split(" ").length != 1) {validateAndSetPassword( passwordArg);}
		  
	
		  
	       System.out.println("       Plesae enter a 6 or more characters password");
	         passwordArg = SC.nextLine();
	  
	  }
		
	        setPassword(passwordArg);
	        
	        
		
		
		
		
		
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
public String getUserName(){
		
		return userName;
		
	}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
	

public void setUsername(String userName) {
	this.userName = userName;
}
public int getBalance() {
	return balance;
}

public void setBalance(int balance) {
	this.balance = balance;
}

public int getEnterdValue() {
	return enterdValue;
}

public void setEnterdValue(int enterdValue) {
	this.enterdValue = enterdValue;
}

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}




public String getLogedinAs() {
	return logedinAs;
}




public void setLogedinAs(String logedinAs) {
	this.logedinAs = logedinAs;
}
public boolean isUserNameExists() {
	return userNameExists;
}




public void setUserNameExists(boolean userNameExists) {
	this.userNameExists = userNameExists;
}
	
}