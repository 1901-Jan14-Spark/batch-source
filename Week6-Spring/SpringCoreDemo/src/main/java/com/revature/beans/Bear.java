package com.revature.beans;

public abstract class Bear {
	
	protected int id;
	protected String name;
	protected boolean isAlsoACat;
	protected Cave cave;
	
	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bear(int id, String name, boolean isAlsoACat, Cave cave) {
		super();
		this.id = id;
		this.name = name;
		this.isAlsoACat = isAlsoACat;
		this.cave = cave;
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

	public boolean isAlsoACat() {
		return isAlsoACat;
	}

	public void setAlsoACat(boolean isAlsoACat) {
		this.isAlsoACat = isAlsoACat;
	}

	public Cave getCave() {
		return cave;
	}

//	public void setCave(Cave cave) {
//		this.cave = cave;
//	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", isAlsoACat=" + isAlsoACat + ", cave=" + cave + "]";
	}
	
	
	
	
	

}
