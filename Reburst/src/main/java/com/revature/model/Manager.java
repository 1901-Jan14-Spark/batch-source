package com.revature.model;

import java.io.Serializable;

public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2392220265816538259L;
	
	
	private int mId;
	private int eId;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int mId, int eId) {
		super();
		this.mId = mId;
		this.eId = eId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Manager other = (Manager) obj;
		if (eId != other.eId)
			return false;
		if (mId != other.mId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager [mId=" + mId + ", eId=" + eId + "]";
	}
	
	
	
	
}
