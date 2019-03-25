package com.revature.dao;

import java.util.List;

import com.revature.beans.Flower;

public interface FlowerDao {

	public Integer insertFlower(Flower f);
	public List<Flower> selectAllFlower();
	public Flower selectFlowerById(Integer id);
	public void updateFlower(Flower change);
}
