package com.revature.model;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -195102502914716002L;

		private int eId;
		private String FName;
		private String LName;
		private String Email;
		private String Password;
		private String Title;
		private int  mId;

		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(int eId, String fName, String lName, String email, String password, String title, int mId) {
			super();
			this.eId = eId;
			FName = fName;
			LName = lName;
			Email = email;
			Password = password;
			Title = title;
			this.mId = mId;
		}

		public Employee(String email) {
			Email = email;
		}

		public int geteId() {
			return eId;
		}

		public void seteId(int eId) {
			this.eId = eId;
		}

		public String getFName() {
			return FName;
		}

		public void setFName(String fName) {
			FName = fName;
		}

		public String getLName() {
			return LName;
		}

		public void setLName(String lName) {
			LName = lName;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public int getmId() {
			return mId;
		}

		public void setmId(int mId) {
			this.mId = mId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Email == null) ? 0 : Email.hashCode());
			result = prime * result + ((FName == null) ? 0 : FName.hashCode());
			result = prime * result + ((LName == null) ? 0 : LName.hashCode());
			result = prime * result + ((Password == null) ? 0 : Password.hashCode());
			result = prime * result + ((Title == null) ? 0 : Title.hashCode());
			result = prime * result + eId;
			result = prime * result + mId;
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
			if (Email == null) {
				if (other.Email != null)
					return false;
			} else if (!Email.equals(other.Email))
				return false;
			if (FName == null) {
				if (other.FName != null)
					return false;
			} else if (!FName.equals(other.FName))
				return false;
			if (LName == null) {
				if (other.LName != null)
					return false;
			} else if (!LName.equals(other.LName))
				return false;
			if (Password == null) {
				if (other.Password != null)
					return false;
			} else if (!Password.equals(other.Password))
				return false;
			if (Title == null) {
				if (other.Title != null)
					return false;
			} else if (!Title.equals(other.Title))
				return false;
			if (eId != other.eId)
				return false;
			if (mId != other.mId)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Employee [eId=" + eId + ", FName=" + FName + ", LName=" + LName + ", Email=" + Email + ", Password="
					+ Password + ", Title=" + Title + ", mId=" + mId + "]";
		}
		
		

		
		
		
		
		
}
