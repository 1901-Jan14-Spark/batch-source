package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Dinosaur;
import com.revature.services.DinoService;

//@Controller + @ResponseBody over each method = @RestControllerd
@RestController
@RequestMapping("/dinos")
public class DinoController {

	@Autowired
	DinoService dinoService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Dinosaur> findAllDinos(@RequestParam(value="name",required=false)String name){
		if(name!=null) {
			return dinoService.findDinosByName(name);
		}
		return dinoService.findAllDinos();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Dinosaur findDinoById(@PathVariable("id") Integer id) {
		return dinoService.findDinoById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dinosaur> addDino(@Valid @RequestBody Dinosaur dino) {
		List<Dinosaur> dinos = dinoService.findAllDinos();
		for(Dinosaur d : dinos) {
			if(d.getId()==dino.getId()) {
				// we can throw an exception indicating to the client that the id already exists
				// or we can return a response entity with the appropriate response status
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}
		// we want to return a 201
		return new ResponseEntity<Dinosaur>(dinoService.addDino(dino),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dinosaur> updateDino(@PathVariable("id") Integer id, @Valid @RequestBody Dinosaur dino) {
		List<Dinosaur> dinos = dinoService.findAllDinos();
		for(Dinosaur d : dinos) {
			if(d.getId()==id) {
				// then we want to update that record
				dino.setId(id);
				return new ResponseEntity<>(dinoService.updateDino(dino),HttpStatus.OK);
			}
		}
		// we want to return a 404
		return new ResponseEntity<Dinosaur>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public Dinosaur deleteDino(@PathVariable("id") Integer id) {
		Dinosaur dino = new Dinosaur(id);
		return dinoService.deleteDino(dino);
	}
	
}
