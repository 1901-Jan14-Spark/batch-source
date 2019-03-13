package com.revature.service;

import java.util.List;

public interface CrudService<T> {

	public List<T> getAll();
	public T getById(int id);
	public int validation(T obj);
	public int create(T obj);
	public int update(T obj);
	public int deleteById(int id);
	
}
