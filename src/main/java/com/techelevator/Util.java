package com.techelevator;

import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;

public class Util {
	private Util() {}
	
	public static Park createPark() {
		return new Park();
	}
	
	public Campground createCampground() {
		return new Campground();
	}
	
	public Site createSite() {
		return new Site();
	}
	
	public Reservation createReservation() {
		return new Reservation();
	}
}
