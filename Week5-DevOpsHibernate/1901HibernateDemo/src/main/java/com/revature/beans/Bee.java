package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Bee")
public class Bee {
	@Id
	@Column(name="b_id")
	@SequenceGenerator(sequenceName="bee_seq", name="b_seq")
	@GeneratedValue(generator="b_seq", strategy=GenerationType
	.SEQUENCE)
	private Integer id;
	
	@Column(name="b_age")
	private Integer age;
	@ManyToOne
	@JoinColumn(name="b_beehive")
	private Beehive beehive;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="bee_flower_jt",
			joinColumns=@JoinColumn(name="b_id"), //column for
												//this table
			inverseJoinColumns=@JoinColumn(name="f_id"))
			//join column for other table
	private List<Flower> flower;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Beehive getBeehive() {
		return beehive;
	}
	public void setBeehive(Beehive beehive) {
		this.beehive = beehive;
	}
	public List<Flower> getFlower() {
		return flower;
	}
	public void setFlower(List<Flower> flower) {
		this.flower = flower;
	}
	public Bee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bee(Integer id, Integer age, Beehive beehive) {
		super();
		this.id = id;
		this.age = age;
		this.beehive = beehive;
	}
	public Bee(Integer age, Beehive beehive) {
		super();
		this.age = age;
		this.beehive = beehive;
	}
	@Override
	public String toString() {
		return "Bee [id=" + id + ", age=" + age + ", beehive=" + beehive + ", flower=" + flower + "]";
	}
	
}
