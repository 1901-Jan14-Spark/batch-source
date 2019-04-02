package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Fish;

@Repository
public interface FishRepository extends JpaRepository<Fish, Integer>{
	
	public List<Fish> findFishByColor(String color);

}
