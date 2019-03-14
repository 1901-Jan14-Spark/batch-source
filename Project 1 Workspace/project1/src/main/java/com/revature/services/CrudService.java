package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface CrudService<T> {
	public List<T> getAll(HttpServletRequest request);
	public T getById(int id);
	public int create(T obj);
	public int update(T obj);
	public int deleteById(int id);
}
