package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Flower")
public class Flower {
	
	@Id
	@Column(name = "f_id")
	@SequenceGenerator(sequenceName="flower_seq", name = "f_seq")
	@GeneratedValue(generator="f_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="f_petals")
	private Integer petals;
	public Flower() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flower(Integer id, Integer petals) {
		super();
		this.id = id;
		this.petals = petals;
	}
	public Flower(Integer petals) {
		super();
		this.petals = petals;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPetals() {
		return petals;
	}
	public void setPetals(Integer petals) {
		this.petals = petals;
	}
	@Override
	public String toString() {
		return "Flower [id=" + id + ", petals=" + petals + "]";
	}
	
	
	
}
