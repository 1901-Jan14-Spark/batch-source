package com.revature.service;

import java.util.List;

import com.revature.model.Reimbursement;

public interface CrudService<T> {
	
	public List<T> getAll();
	public  List<Reimbursement>  getByEId(int id);
	public int create(T obj);
	public int update(T obj);
	public int deleteById(int id);

}
