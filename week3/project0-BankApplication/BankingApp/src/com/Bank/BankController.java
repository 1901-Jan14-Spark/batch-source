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

		BankView theView = new BankView("userName", "firstName", "lastName", "pass", 10, 0);
		model = new User();

		BankController bc = new BankController(theView, model);

		theView.addObserver(bc);
		bc.getTheView().rootPage();

	}

	private BankController(BankView theView, User user) {
		super();
		this.setTheView(theView);
		this.setModel(user);

	}

	@Override
	public void update(Observable arg0, Object arg1) {

		switch ((String) arg1) {
		case "CreateNewAccount":
			this.model.setUsername(this.theView.getUserName());
			this.model.setFirstName(this.theView.getFirstName());
			this.model.setLastName(this.theView.getLastName());
			this.model.setPassword(this.theView.getPassword());
			this.model.getAccount().setChecking(10);

			// this will save to file as well as fetch database assigned new ID number
			this.model.getUserDao().createUser(this.model);

			break;

		case "depositAmountSaving":
			System.out.println("saving amount" + this.theView.getEnterdValue());
			this.theView.setStatus(this.model.getAccount().depositSaving(this.model, (this.theView.getEnterdValue())));
			this.theView.setSaving((this.model.getAccount().getSaving()));

			break;
		case "depositAmountChecking":
			this.theView
					.setStatus(this.model.getAccount().depositChecking(this.model, (this.theView.getEnterdValue())));
			this.theView.setChecking((this.model.getAccount().getChecking()));

			break;

		case "withdrawFromChecking":
			this.theView.setStatus(
					this.model.getAccount().withdrawMoneyChecking(this.theView.getEnterdValue(), this.model));
			this.theView.setChecking((this.model.getAccount().getChecking()));
			// save transaction if successful
			if (this.theView.isStatus()) {

			}

			break;

		case "withdrawFromSaving":
			this.theView
					.setStatus(this.model.getAccount().withdrawMoneySaving(this.theView.getEnterdValue(), this.model));
			this.theView.setSaving((this.model.getAccount().getSaving()));
			// save transaction if successful
			if (this.theView.isStatus()) {

			}

			break;

		case "logIn":

			User foundUser = this.model.getUserDao().findUser(this.theView.getEnterdUsername());

			System.out.println("printing founder" + foundUser.getID());
			this.theView.setPassword(foundUser.getPassword());

			if ((foundUser.getID() != 0) && (this.theView.logInmenuCheckPassword())) {

				System.out.println(foundUser);
				this.theView.setUsername(foundUser.getUsername());
				this.theView.setFirstName(foundUser.getFirstName());
				this.theView.setLastName(foundUser.getLastName());

				BankView theView = new BankView(foundUser.getUsername(), foundUser.getFirstName(),
						foundUser.getLastName(), foundUser.getPassword(), foundUser.getAccount().getChecking(),
						foundUser.getAccount().getSaving());

				BankController bc = new BankController(theView, foundUser);
				theView.addObserver(bc);
				bc.getTheView().homePage();

			} else {

				System.out.println("No user found by that username");
				this.theView.handleLogInOption();
			}

			this.theView.setChecking(this.model.getAccount().getChecking());
			break;

		case "updateBalance":

			break;
		case "loggedout":

			// create default user object
			BankView theView = new BankView("userName", "firstName", "lastName", "pass", 10, 0);
			User user = new User();
			BankController bc = new BankController(theView, user);

			theView.addObserver(bc);
			bc.getTheView().rootPage();

			break;

		case "checkUserNameExist":

			User userfound = this.model.getUserDao().findUser(this.theView.getEnterdUsername());
			if (userfound.getID() != 0) {

				this.theView.setUserNameExists(true);
			} else {
				this.theView.setUserNameExists(false);
			}

			break;

		default:
			break;
		}

	}

	public BankController getInstanceOfCC() {
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