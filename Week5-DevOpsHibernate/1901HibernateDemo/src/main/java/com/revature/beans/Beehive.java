package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Beehive")
public class Beehive {
	
	@Id
	@Column(name="bh_id")
	@SequenceGenerator(sequenceName="beehive_seq", name="bh_seq")
	@GeneratedValue(generator="bh_seq", strategy=GenerationType
	.SEQUENCE)
	private Integer id;
	@Column(name="bh_honey")
	private Integer honey;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHoney() {
		return honey;
	}
	public void setHoney(Integer honey) {
		this.honey = honey;
	}
	public Beehive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beehive(Integer id, Integer honey) {
		super();
		this.id = id;
		this.honey = honey;
	}
	public Beehive(Integer honey) {
		super();
		this.honey = honey;
	}
	@Override
	public String toString() {
		return "Beehive [id=" + id + ", honey=" + honey + "]";
	}
	
}
