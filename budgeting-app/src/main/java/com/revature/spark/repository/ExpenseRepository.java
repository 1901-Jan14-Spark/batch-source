package com.revature.spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.spark.beans.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}
