package com.revature.services;

import java.util.List;

import com.revature.models.Dinosaur;

public interface DinoService {
	
	public List<Dinosaur> findAllDinos();
	public Dinosaur findDinoById(Integer id);
	public List<Dinosaur> findDinosByName(String name);
	public Dinosaur addDino(Dinosaur d);
	public Dinosaur updateDino(Dinosaur d);
	public Dinosaur deleteDino(Dinosaur d);

}
