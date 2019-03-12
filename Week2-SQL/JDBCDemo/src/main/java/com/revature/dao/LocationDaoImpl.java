package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Location;
import com.revature.util.ConnectionUtil;

public class LocationDaoImpl implements LocationDao {

	@Override
	public List<Location> getLocations() {
		List<Location> locations = new ArrayList<>();
		
		String sql = "SELECT * FROM LOCATIONS";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int id = rs.getInt("LOCATION_ID");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				int zip = rs.getInt("ZIPCODE");
				locations.add(new Location(id, street, city, state, zip));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return locations;
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createLocation(Location location) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLocation(Location location) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLocation(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
