package com.Bank;

import java.util.Observable;
import java.util.Observer;

// The Controller coordinates interactions
// between the View and Model

public class BankController implements Observer {
	
	private BankView theView;
	private User model;
	
	
	public BankController() {
		super();
		
		BankView theView = new BankView( "userName",  "firstName",  "lastName",  "pass",  10);
    	User user = new User();
    	BankController bc = new BankController (theView, user);
    	
    	theView.addObserver(bc);
    	bc.getTheView().rootPage();
    
	}
	
	
	
	private BankController(BankView theView, User user) {
		this.setTheView(theView);
		this.setModel(user);
		
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		
		switch ((String)arg1) {
		case "CreateNewAccount": this.model.setUsername(this.theView.getUserName());
		                          this.model.setFirstName(this.theView.getFirstName());
		                          this.model.setLastName(this.theView.getLastName());
		                          this.model.getAccount().setPassword(this.theView.getPassword());
		                          this.model.getAccount().setBalance(10);
		                          //save to file
		                          this.model.saveUserInstance();
		                        
		
		                        break;
		
		case "depositAmount": this.theView.setStatus(this.model.getAccount().depositMoney(this.theView.getEnterdValue()));
		                       this.theView.setBalance(this.model.getAccount().getBalance());
        
        break;
        
		case "withdrawAmount": this.theView.setStatus(this.model.getAccount().withdrawMoney(this.theView.getEnterdValue()));
                               this.theView.setBalance(this.model.getAccount().getBalance());
                               //save transaction if successful
                               if(this.theView.isStatus()) {
                              this.model.updateUser( this.theView.getUserName(), this.model.getAccount().getBalance());
                            	  
                               }
                               
                               
                               break;

		case "logIn":         // this.theView.setStatus(this.model.getUsername().(this.theView.getEnterdUsername()));
			                 
			                if (this.model.findUser(this.theView.getEnterdUsername()) != null) {
			                	
			                	  User foundUser = this.model.findUser(this.theView.getEnterdUsername());
			                	  System.out.println(foundUser);
			                	  this.theView.setUsername(foundUser.getUsername());
			                	  this.theView.setFirstName(foundUser.getFirstName());
			                	  this.theView.setLastName(foundUser.getLastName());
			                	  
			                	  
			                	  
			                	  
			                	  BankView theView = new BankView( foundUser.getUsername(),  foundUser.getFirstName(), foundUser.getLastName(),  foundUser.getAccount().getPassword(), foundUser.getAccount().getBalance());
			             
			                  	BankController bc = new BankController (theView, foundUser);
			                  	theView.addObserver(bc);
			                	bc.getTheView().homePage();
			                	  
			                	  
			                	  
			                	  
			                  }else {
			                	  
			                	  System.out.println("No user found by that username");
			                	  this.theView.handleLogInOption();
			                  }
			                   System.out.println( this.model.findUser(this.theView.getEnterdUsername()));
                               this.theView.setBalance(this.model.getAccount().getBalance());
                               break;
                               
		case "updateBalance": 
			            // this.model.getAccount().setBalance(this.theView.getEnterdValue());
		
			                     this.model.updateUser( this.theView.getUserName(), this.theView.getEnterdValue());
		                    
                             
                               break; 
		case "loggedout": 
                          // this.model.getAccount().setBalance(this.theView.getEnterdValue());
			                    

								BankView theView = new BankView( "userName",  "firstName",  "lastName",  "pass",  10);
						    	User user = new User();
						    	BankController bc = new BankController (theView, user);
						    	
						    	theView.addObserver(bc);
						    	bc.getTheView().rootPage();
                
                 
                                break;
                                
    case "checkUserNameExist": 
            // this.model.getAccount().setBalance(this.theView.getEnterdValue());
                                // System.out.println("rinting finding" + this.model.findUser(this.theView.getEnterdUsername()));
		    	               if (this.model.findUser(this.theView.getEnterdUsername()) != null) {
		    	            	   
		    	            	   this.theView.setUserNameExists(true);
		    	               }
		    	               else {
		    	            	   this.theView.setUserNameExists(false);
		    	               }
			  
			   
			                    break;                     
                                
                                
	
		default:
		break;
		}
		
		
		
		
		
	}

	public BankController getInstanceOfCC () {
		return this;
	}

	public BankView getTheView() {
		return theView;
	}



	public void setTheView(BankView theView) {
		this.theView = theView;
	}



	public User getModel() {
		return model;
	}



	public void setModel(User model) {
		this.model = model;
	}
	
}