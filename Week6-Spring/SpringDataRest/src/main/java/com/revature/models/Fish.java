package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Fish {
	
	@Id
	private Integer id;	
	
	private boolean canFly;
	
	private String color;
	
	@Column(name="FISH_SIZE")
	private int size;

	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fish(Integer id, boolean canFly, String color, int size) {
		super();
		this.id = id;
		this.canFly = canFly;
		this.color = color;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Fish [id=" + id + ", canFly=" + canFly + ", color=" + color + ", size=" + size + "]";
	}
	
	
	

}
