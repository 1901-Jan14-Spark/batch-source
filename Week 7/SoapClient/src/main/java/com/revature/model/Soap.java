package com.revature.model;

public class Soap {
	private int id;
	private String fragrance;
	private String brand;
	
	public Soap() {
		super();
	}
	public Soap(int id, String fragrance, String brand) {
		super();
		this.id = id;
		this.fragrance = fragrance;
		this.brand = brand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFragrance() {
		return fragrance;
	}
	public void setFragrance(String fragrance) {
		this.fragrance = fragrance;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((fragrance == null) ? 0 : fragrance.hashCode());
		result = prime * result + id;
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
		Soap other = (Soap) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (fragrance == null) {
			if (other.fragrance != null)
				return false;
		} else if (!fragrance.equals(other.fragrance))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Soap [id=" + id + ", fragrance=" + fragrance + ", brand=" + brand + "]";
	}
	
	
}
