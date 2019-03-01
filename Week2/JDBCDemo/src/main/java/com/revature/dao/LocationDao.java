package com.revature.dao;

import java.util.List;
import com.revature.model.Location;

public interface LocationDao {

	public List<Location> getLocations();
	public Location getLocationById(int id);
	public int createLocation(Location location);
	public int updateLocation(Location location);
	public int deleteLocation(int id);
	
}
