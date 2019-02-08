package com.revature.spark.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.spark.beans.User;
import com.revature.spark.repository.ExpenseRepository;
import com.revature.spark.repository.UserRepository;
import com.revature.spark.todo.AssociateImplementation;

@Service
public class UserService {
	
	/**
	 * In Spring, we would likely @Autowired this property.
	 * Just to keep the associate code free of Spring annotations,
	 * we opted to simply instantiate the old-fashioned way.
	 */
	private AssociateImplementation associateImplementation = new AssociateImplementation();
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Map<User, String> highestExpenseCategoryPerUser(){
		return associateImplementation.highestExpenseCategoryPerUser(expenseRepository.findAll());
	}
	
}
