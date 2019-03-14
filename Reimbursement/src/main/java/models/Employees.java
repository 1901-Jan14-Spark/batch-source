package models;

import java.io.Serializable;

public class Employees implements Serializable{
	private static final long serialVersionUID = 1705772322652614654L;
	
	private int id;
	private String first;
	private String last;
	private String username;
	private String password;
	private String isMana;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String IsMana() {
		return isMana;
	}
	public void setIsMana(String isMana) {
		this.isMana = isMana;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + id;
		result = prime * result + ((isMana == null) ? 0 : isMana.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employees other = (Employees) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (id != other.id)
			return false;
		if (isMana == null) {
			if (other.isMana != null)
				return false;
		} else if (!isMana.equals(other.isMana))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", first=" + first + ", last=" + last + ", username=" + username + ", password="
				+ password + ", isMana=" + isMana + "]";
	}
	public Employees(int id, String first, String last, String username, String password, String isMana) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.username = username;
		this.password = password;
		this.isMana = isMana;
	}
	public Employees() {
		super();
	}
	public Employees(int empId, String first, String last, String user, String pass) {
		this.id=empId;
		this.first=first;
		this.last=last;
		this.username=user;
		this.password=pass;
	}
	public Employees(String first, String last, String user, String pass, String isMana) {
		this.first=first;
		this.last=last;
		this.username=user;
		this.password=pass;
		this.isMana=isMana;
	}

	

	
}
