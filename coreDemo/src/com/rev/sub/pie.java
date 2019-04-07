package com.rev.sub;

import java.io.Serializable;

public class pie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filling;
	private String crustType;
	private int size;
	public pie() {
	
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
		pie other = (pie) obj;
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
	public pie(String filling, String crustType, int size) {
		super();
		this.filling = filling;
		this.crustType = crustType;
		this.size = size;
	}
	@Override
	public String toString() {
		return "pie [filling=" + filling + ", crustType=" + crustType + ", size=" + size + "]";
	}
}
