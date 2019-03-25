package com.revature.beans;

public class Cat {
	private Integer id;
	private String name;
	private String color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Cat() {
		super();
	}
	public Cat(Integer id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}
	public Cat(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
	
	
}
