package models;

public class Employee {

	int id;
	String firstName;
	String lastName;
	String email;
	String password;
	int reportsTo;
	int loggedIn;
	
	//The employee object we will add to our list to create the /onlyEmployees endpoint
	public Employee(int empId, String fName, String lName, String email, int reportsTo) {
		super();
		this.id = empId;
		this.firstName = fName;
		this.lastName = lName;
		this.email = email;
		this.reportsTo = reportsTo;
	}

	public Employee(int empId, String firstName, String lastName, String email, String password, int loggedIn) {
		super();
		this.id = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.loggedIn = loggedIn;
	}
	
	public Employee(int empId, String firstName, String lastName, String email, String password, int reportsTo, int loggedIn) {
		super();
		this.id = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.reportsTo = reportsTo;
		this.loggedIn = loggedIn;
	}
	

	public Employee(int id, String firstName, String lastName, String email, int reportsTo, int loggedIn) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.reportsTo = reportsTo;
		this.loggedIn = loggedIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public int getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(int loggedIn) {
		this.loggedIn = loggedIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + loggedIn;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + reportsTo;
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
		Employee other = (Employee) obj;
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
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (loggedIn != other.loggedIn)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (reportsTo != other.reportsTo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", reportsTo=" + reportsTo + ", loggedIn=" + loggedIn + "]";
	}


	
	
	
}
