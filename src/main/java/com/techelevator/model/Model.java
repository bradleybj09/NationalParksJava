package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private ParkDAO parkDao;
	private CampgroundDAO campgroundDao;
	private SiteDAO siteDao;
	private ReservationDAO reservationDao;
	private List<Park> parks;
	private List<Campground> campgrounds;
	private List<Site> sites;
	private List<Reservation> reservations;
	
	public Model() {
		parks = new ArrayList<Park>();
		campgrounds = new ArrayList<Campground>();
		sites = new ArrayList<Site>();
		reservations = new ArrayList<Reservation>();
		
		
	}
	
	public List<Park> getParks() {
		return parks;
	}

	public List<Campground> getCampgrounds() {
		return campgrounds;
	}

	public List<Site> getSites() {
		return sites;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	
}
