package com.techelevator.model;

import java.util.List;

public interface CampgroundDAO {
	
	public List<Campground> getCampgroundsById(long parkId);
	
}
