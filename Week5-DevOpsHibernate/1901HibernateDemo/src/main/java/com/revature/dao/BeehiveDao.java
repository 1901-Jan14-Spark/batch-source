package com.revature.dao;

import java.util.List;

import com.revature.beans.Beehive;

public interface BeehiveDao {
	public Integer insertBeehive(Beehive b);
	public List<Beehive> selectAllBeehives();
	public Beehive selectBeehiveById(Integer id);
	public void updateBeehive(Beehive change);
}
