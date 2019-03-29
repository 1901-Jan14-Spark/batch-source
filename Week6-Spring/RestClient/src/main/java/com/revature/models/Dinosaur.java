package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Dinosaur {
	

	private Integer id;
	
	private String name;

	private boolean isExtinct;
	
	private String species;
	
	public Dinosaur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dinosaur(Integer id) {
		super();
		this.id = id;
	}

	public Dinosaur(Integer id, String name, boolean isExtinct, String species) {
		super();
		this.id = id;
		this.name = name;
		this.isExtinct = isExtinct;
		this.species = species;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsExtinct() {
		return isExtinct;
	}

	public void setIsExtinct(boolean isExtinct) {
		this.isExtinct = isExtinct;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isExtinct ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
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
		Dinosaur other = (Dinosaur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isExtinct != other.isExtinct)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dinosaur [id=" + id + ", name=" + name + ", isExtinct=" + isExtinct + ", species=" + species + "]";
	}
	
	


}
