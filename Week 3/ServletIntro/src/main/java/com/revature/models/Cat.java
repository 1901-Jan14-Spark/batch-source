package com.revature.models;

public class Cat {
	
	private int id;
	private String name;
	private boolean isMunchkin;
	private String breed;
	public Cat() {
		super();
	}
	public Cat(int id, String name, boolean isMunchkin, String breed) {
		super();
		this.id = id;
		this.name = name;
		this.isMunchkin = isMunchkin;
		this.breed = breed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMunchkin() {
		return isMunchkin;
	}
	public void setMunchkin(boolean isMunchkin) {
		this.isMunchkin = isMunchkin;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + id;
		result = prime * result + (isMunchkin ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Cat other = (Cat) obj;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (id != other.id)
			return false;
		if (isMunchkin != other.isMunchkin)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", isMunchkin=" + isMunchkin + ", breed=" + breed + "]";
	}
	
	
}
