package com.revature.spark.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.spark.beans.User;
import com.revature.spark.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/user/all")
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/user/all/top")
	public ResponseEntity<Map<User, String>> highestExpenseCategoryPerUser(){
		return new ResponseEntity<>(service.highestExpenseCategoryPerUser(), HttpStatus.OK);
	}

}
