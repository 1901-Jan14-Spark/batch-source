package com.revature.bank;

public class Member {
	
	// the instance variables that make up a member's account
		public String userName;
		public String firstName;
		public String lastName;
		public String email;
		public String password;
		public String accountNumber;
		public Account accountBalance;
		
		// no arguments constructor
		public Member() {
			super();
		}

		public Member(String userName, String firstName, String lastName, String email, String password,
				String accountNumber, Account accountBalance) {
			super();
			this.userName = userName;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.accountNumber = accountNumber;
			this.accountBalance = accountBalance;
		}

		public Member(String userName, String firstName, String lastName, String email, String password,
				String accountNumber) {
			super();
			this.userName = userName;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.accountNumber = accountNumber;
			this.accountBalance = accountBalance;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public Account getAccountBalance() {
			return accountBalance;
		}

		public void setAccountBalance(Account accountBalance) {
			this.accountBalance = accountBalance;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((accountBalance == null) ? 0 : accountBalance.hashCode());
			result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Member other = (Member) obj;
			if (accountBalance == null) {
				if (other.accountBalance != null)
					return false;
			} else if (!accountBalance.equals(other.accountBalance))
				return false;
			if (accountNumber == null) {
				if (other.accountNumber != null)
					return false;
			} else if (!accountNumber.equals(other.accountNumber))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Hello " + firstName + " " + lastName + "!\n\n" + " Account Number: " + accountNumber + "\n Balance: "
					+ accountBalance;
		}

}
