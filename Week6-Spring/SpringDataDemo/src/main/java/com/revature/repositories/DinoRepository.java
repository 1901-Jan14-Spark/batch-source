package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Dinosaur;

@Repository
public interface DinoRepository extends JpaRepository<Dinosaur, Integer> {
	
	public List<Dinosaur> findDinosaursByName(String name);

}
