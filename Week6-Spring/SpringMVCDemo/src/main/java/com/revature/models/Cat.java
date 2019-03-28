package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Cat {
	
	private int id;
	private String name;
	private int numOfLives = 9;
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(int id, String name, int numOfLives) {
		super();
		this.id = id;
		this.name = name;
		this.numOfLives = numOfLives;
	}
	
	public Cat(String name, int numOfLives) {
		super();
		this.name = name;
		this.numOfLives = numOfLives;
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

	public int getNumOfLives() {
		return numOfLives;
	}

	public void setNumOfLives(int numOfLives) {
		this.numOfLives = numOfLives;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", numOfLives=" + numOfLives + "]";
	}
	
	
	
	

}
