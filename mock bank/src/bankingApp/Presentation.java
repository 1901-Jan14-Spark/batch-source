package bankingApp;
/**
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author Youness
 *
 */
public class Presentation {

	/**
	 * @param args
	 */
				public static void main(String[] args) {
			
			//TODO Auto-generated method stub
						welcome();
				}
				
		    static String textPath = "src/bankingApp/accounts.txt";
	        static Scanner input = new Scanner(System.in);


	        
	        public static void welcome() {
	    		// TODO Auto-generated method stub
	            System.out.println("\033[31;1mWelcome!\033[0m, \033[32;1;2m Please choose one of the following options!\033[0m");
	    		System.out.println("New User Pease Register by Entering "+"\033[31;1m1\033[0m");
	    		System.out.println("To Login, Please Enter "+"\033[31;1m2\033[0m");
	    		System.out.println("To Exit the Application Please Enter "+"\033[31;1m3\033[0m");
	    		int choice = input.nextInt();
	    		if (choice== 1)
	    			createAccount();
	    		if (choice== 2)
	    			login();
	    		if (choice== 3) {
		    		System.out.println("\nThank you for visiting, See you other time ");
	    		   System.exit(0);
	    		}
	    		else welcome();
	    	}
	        
	        public static void createAccount() {
		       // ArrayList<String> arr = new ArrayList<>();

	        	System.out.println("\033[31;1mWelcome To the Club!\033[0m, \033[32;1;2m Please Fill Out the Registration Form!\033[0m");
	        	System.out.println("Email: ");
	    		String email = input.next();
	    		//arr.add(email);
	    		System.out.println("First Name: ");
	    		String fname = input.next();
	    		//arr.add(fname);
	    		System.out.println("Last Name: ");
	    		String lname = input.next();
	    		//arr.add(lname);
	    		System.out.println("User Name: ");
	    		String userName = input.next();
	    		//arr.add(userName);
	    		System.out.println("\033[31;1mPassword\033[0m");
	    		String password = input.next();
	    		//arr.add(password);
	    		System.out.println("Please make a deposite , $20 minimum");
	    		while (!input.hasNextDouble())
	    		{
	    		    System.out.println("\033[31;1mInvalid input\\n Please Type in the double-type number:\033[0m");
	    		    input.next();
	    		}
	    		double deposit = input.nextDouble();
	    		//arr.add(deposit);
//	    		System.out.println("\033[31;1mConfirm Password\033[0m");
//	    		String password2 = input.next();
	    		
	    		try(FileWriter fw = new FileWriter(textPath,true); BufferedWriter bw = new BufferedWriter(fw)){
	    			bw.append(email+" "+fname+" "+lname+" "+userName+" "+password+" "+deposit+"\n");
		    		System.out.println("\n\033[32;2mCongratulations! Your Account Was Successfully Created \033[0m\n" );
	    			bw.close();
		    		welcome();

	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}

	        }
	        
	        public static void login() {

	               System.out.println("Enter your username: ");
	               String userName = input.next();
	               System.out.println("Enter Your Password: ");
	               String password = input.next();
		        	System.out.println("\n\033[31;1mLoading....!\033[0m, \033[32;1;2m Please wait to check...\033[0m\n");
		        	
		        	try (BufferedReader br = new BufferedReader(new FileReader(textPath))) {
		   	
	           			String line = br.readLine();
	           			while(line != null) 
	           			   {			    			
			    			String[] content = line.split("\\s+");;

	           			    if (userName.equals(content[3]) && (password.equals(content[4])))
	           			    {
		           				System.out.println("\n\033[33;1;2mHello..\033[0m" + content[1]+" "+content[2]);
		           				System.out.println("Your Curent Balance is $" + content[5]+ "\n");
	           			    		accountInfo();
		                           break;
		                     }
	           			    else {
		           				System.out.println("\n\033[31;1mYou have entered an invalid username or password....Try again!\033[0m"+"\n");
		           				welcome();
	           			    }
	        
	           		        }
	                   }catch (FileNotFoundException e) {
	           			e.printStackTrace();
	           		   } catch (IOException e1) {
	           			e1.printStackTrace();
	           		   } 
	           		
	            
	        }
	        
	        public static void accountInfo() throws IOException {
	        	 System.out.println("\033[31;1mWelcome Back!\033[0m, \033[32;1;2m Please choose one of the following options!\033[0m");
		    		System.out.println("To Deposite Money, Please Enter "+"\033[31;1m1\033[0m");
		    		System.out.println("To Withdraw Money, Please Enter "+"\033[31;1m2\033[0m");
		    		System.out.println("To Exit the Application Please Enter "+"\033[31;1m3\033[0m");
					int choice = input.nextInt();

		    		try (BufferedReader br = new BufferedReader(new FileReader(textPath))) 
		    		{
			    		if (choice == 1) {
			    			String line = br.readLine();
		           			String[] content = line.split("\\s+");
							FileWriter fw = new FileWriter(textPath,false); BufferedWriter bw = new BufferedWriter(fw);
							double money = Double.parseDouble(content[5]);
				    		System.out.println("\nHow Much would you like to deposite: ");
			    		    System.out.print("$ ");
			    		    while (!input.hasNextDouble())
				    		{
				    		    System.out.println("\033[31;1mInvalid input\\n Please Type in the double-type number:\033[0m");
				    		    input.next();
				    		}
			    		    double add = input.nextDouble();
			    		    double adding = add+ money;
			    		    bw.write(content[0]+" "+content[1]+" "+content[2]+" "+content[3]+" "+content[4]+" "+String.valueOf(adding));
			    		    bw.close();
				    		System.out.println("\nYour Deposite Has Been Added, thank you\n ");
	           				System.out.println("Your Curent Balance is $" + adding+ "\n");
				    		accountInfo();
			    		}
			    		if (choice== 2) {
			    		String line = br.readLine();
	           			String[] content = line.split("\\s+");
						FileWriter fw = new FileWriter(textPath,false); BufferedWriter bw = new BufferedWriter(fw);
						double money = Double.parseDouble(content[5]);
			    		System.out.println("\nHow Much would you like to withdraw: ");
		    		    System.out.print("$ ");
		    		    while (!input.hasNextDouble())
			    		{
			    		    System.out.println("\033[31;1mInvalid input\\n Please Type in the double-type number:\033[0m");
			    		    input.next();
			    		}
		    		    double remove = input.nextDouble();
		    		    double removing = money - remove;
			    		    if (removing >= 0) {
			    		    bw.write(content[0]+" "+content[1]+" "+content[2]+" "+content[3]+" "+content[4]+" "+String.valueOf(removing));
			    		    bw.close();
				    		System.out.println("\nYour withdrawal Has Been Proccessed, thank you\n ");
	           				System.out.println("Your Curent Balance is $" + removing + "\n");
				    		accountInfo();
			    		    }
		    		    else {
		    		    	bw.write(content[0]+" "+content[1]+" "+content[2]+" "+content[3]+" "+content[4]+" "+String.valueOf(222));
			    		    bw.close();
	           				System.out.println("\n\033[31;1mTransaction is declined..insufficient funds!\033[0m"+"\n");
	           				System.out.println("Your Curent Balance is $" + money + "\n");

		    		    	 }
			    		    accountInfo();
			    		}
			    		if (choice== 3) {
				    		System.out.println("\nThank you for visiting, See you other time ");
			    		   welcome();
			    		}
	                   }catch (FileNotFoundException e) {
	           			e.printStackTrace();
	        }
	     }
	}
