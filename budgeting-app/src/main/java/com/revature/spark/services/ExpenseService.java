package com.revature.spark.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.spark.beans.Expense;
import com.revature.spark.beans.User;
import com.revature.spark.repository.ExpenseRepository;
import com.revature.spark.repository.UserRepository;
import com.revature.spark.todo.AssociateImplementation;

@Service
public class ExpenseService {
	
	/**
	 * In Spring, we would likely @Autowired this property. Just to keep the
	 * associate code free of Spring annotations, we opted to simply instantiate the
	 * old-fashioned way.
	 */
	private AssociateImplementation associateImplementation = new AssociateImplementation();

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}

	public Expense create(Expense expense) {
		validateUser(expense);
		Optional<Expense> toSave = expenseRepository.findById(expense.getId());
		if (toSave.isPresent()) {
			throw new RuntimeException("The record with identifier " + expense.getId()
					+ " already exists. Please select a unique identifier.");
		} else {
			return expenseRepository.save(expense);
		}
	}

	public Expense update(Expense expense) {
		validateUser(expense);
		Optional<Expense> toUpdate = expenseRepository.findById(expense.getId());
		if (toUpdate.isPresent()) {
			Expense update = toUpdate.get();
			update.setCategory(expense.getCategory());
			update.setCost(expense.getCost());
			update.setMerchant(expense.getMerchant());
			update.setUser(expense.getUser());
			return expenseRepository.save(update);
		} else {
			throw new RuntimeException("The record with identifier " + expense.getId()
					+ " was not found. You cannot update a record that does not exist.");
		}
	}

	private void validateUser(Expense call) {
		Optional<User> user = userRepository.findById(call.getUser().getId());
		if (!user.isPresent()) {
			throw new RuntimeException("User record does not exist.");
		}
	}

	public void delete(Expense call) {
		expenseRepository.delete(call);
	}

	public Double sum() {
		return associateImplementation.sum(expenseRepository.findAll());
	}

	public Double min() {
		return associateImplementation.min(expenseRepository.findAll());
	}

	public Double max() {
		return associateImplementation.max(expenseRepository.findAll());
	}

	public Double avg() {
		return associateImplementation.avg(expenseRepository.findAll());
	}

	public Double median() {
		return associateImplementation.median(expenseRepository.findAll());
	}
	
}
