package com.revature.dao;

import java.util.List;

import com.revature.beans.Cat;

public interface CatDao {
	public Integer insertCat(Cat c);
	public List<Cat> selectAllCats();
	public Cat selectCatById(Integer id);
	public void updateCat(Cat change);
	
}
