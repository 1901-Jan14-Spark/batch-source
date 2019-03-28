package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Cat;

@Service
public class CatService {
	
	private List<Cat> cats = new ArrayList<>();
	
	public CatService() {
		cats.add(new Cat(1, "Fluffy", 8));
		cats.add(new Cat(2, "Bear", 4));
		cats.add(new Cat(3, "Somomo", 1));
	}
	
	public List<Cat> getCats(){
		return this.cats;
	}
	
	public Cat getCatById(int id) {
		for(Cat c: cats) {
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	public void addCat(Cat c) {
		List<Cat> cats = this.getCats();
		int maxId = 0;
		for(Cat cat: cats) {
			if(cat.getId()>maxId) {
				maxId = cat.getId();
			}
		}
		c.setId(++maxId);
		this.cats.add(c);
	}

}
