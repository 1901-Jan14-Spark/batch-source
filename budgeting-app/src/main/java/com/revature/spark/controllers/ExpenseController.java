package com.revature.spark.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.spark.beans.Expense;
import com.revature.spark.services.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService service;
	
	@GetMapping("/expense/all")
	public ResponseEntity<List<Expense>> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@PostMapping("/expense")
	public ResponseEntity<Expense> create(@Valid @RequestBody Expense expense){
		return new ResponseEntity<>(service.create(expense), HttpStatus.CREATED);
	}

	@PutMapping("/expense")
	public ResponseEntity<Expense> update(@Valid @RequestBody Expense expense){
		return new ResponseEntity<>(service.update(expense), HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/expense")
	public ResponseEntity<Void> delete(@Valid @RequestBody Expense expense){
		service.delete(expense);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/expense/sum")
	public ResponseEntity<Double> sum(){
		return new ResponseEntity<>(service.sum(), HttpStatus.OK);
	}
	
	@GetMapping("/expense/min")
	public ResponseEntity<Double> min(){
		return new ResponseEntity<>(service.min(), HttpStatus.OK);
	}
	
	@GetMapping("/expense/max")
	public ResponseEntity<Double> max(){
		return new ResponseEntity<>(service.max(), HttpStatus.OK);
	}
	
	@GetMapping("/expense/avg")
	public ResponseEntity<Double> avg(){
		return new ResponseEntity<>(service.avg(), HttpStatus.OK);
	}
	
	@GetMapping("/expense/median")
	public ResponseEntity<Double> median(){
		return new ResponseEntity<>(service.median(), HttpStatus.OK);
	}
	
}
