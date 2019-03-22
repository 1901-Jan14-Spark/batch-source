package com.revature.dao;

import java.util.List;

import com.revature.beans.Bee;

public interface BeeDao {

	public Integer insertBee(Bee b);
	public List<Bee> selectAllBees();
	public Bee selectBeeById(Integer id);
	public void updateBee(Bee change);
}
