package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Cat;

public class CatService {
	List<Cat> cats = new ArrayList<>();
	
	public CatService() {
		cats.add(new Cat(1, "Jaxpy", true, "siamese"));
		cats.add(new Cat(1, "Sax", false, "tabby"));
		cats.add(new Cat(1, "Tom", true, "catalina"));
		cats.add(new Cat(1, "Bob", true, "sphynx"));
	}
	
	public List<Cat> getCats(){
		return cats;
	}
}
