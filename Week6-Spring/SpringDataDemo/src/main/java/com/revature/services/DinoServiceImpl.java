package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Dinosaur;
import com.revature.repositories.DinoRepository;

@Service
public class DinoServiceImpl implements DinoService {
	
	@Autowired
	DinoRepository dinoRepository;

	@Override
	public List<Dinosaur> findAllDinos() {
		return dinoRepository.findAll();
	}

	@Override
	public Dinosaur findDinoById(Integer id) {
		return dinoRepository.getOne(id);
	}

	@Override
	public Dinosaur addDino(Dinosaur d) {
		return dinoRepository.save(d);
	}

	@Override
	public Dinosaur updateDino(Dinosaur d) {
		return dinoRepository.save(d);
	}

	@Override
	public Dinosaur deleteDino(Dinosaur d) {
		dinoRepository.delete(d);
		return d;
	}

	@Override
	public List<Dinosaur> findDinosByName(String name) {
		return dinoRepository.findDinosaursByName(name);
	}

}
