package com.revature.io.serial;

import java.io.Serializable;

public class Pie implements Serializable {
	
	private static final long serialVersionUID = -2799245981064758469L;
	
	private String filling;
	private transient String crustType;
	private int size;
//	private int calories;
	
	public Pie() {
		super();
	}

	public Pie(String filling, String crustType, int size) {
		super();
		this.filling = filling;
		this.crustType = crustType;
		this.size = size;
	}

	public String getFilling() {
		return filling;
	}

	public void setFilling(String filling) {
		this.filling = filling;
	}

	public String getCrustType() {
		return crustType;
	}

	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Pie [filling=" + filling + ", crustType=" + crustType + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crustType == null) ? 0 : crustType.hashCode());
		result = prime * result + ((filling == null) ? 0 : filling.hashCode());
		result = prime * result + size;
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
		Pie other = (Pie) obj;
		if (crustType == null) {
			if (other.crustType != null)
				return false;
		} else if (!crustType.equals(other.crustType))
			return false;
		if (filling == null) {
			if (other.filling != null)
				return false;
		} else if (!filling.equals(other.filling))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

}
