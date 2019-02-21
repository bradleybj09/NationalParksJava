package com.techelevator.data;

import java.util.List;

import com.techelevator.model.Campground;

public interface CampgroundDAO {
	
	public List<Campground> getCampgroundsById(long parkId);
	
}
