package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class Model {
	
	private ParkDAO parkDao;
	private CampgroundDAO campgroundDao;
	private SiteDAO siteDao;
	private ReservationDAO reservationDao;
	private List<Park> parks;
	private List<Campground> campgrounds;
	private List<Site> sites;
	private List<Reservation> reservations;
	
	public Model(BasicDataSource dataSource) {
		parks = new ArrayList<Park>();
		campgrounds = new ArrayList<Campground>();
		sites = new ArrayList<Site>();
		reservations = new ArrayList<Reservation>();
		parkDao = new JDBCParkDAO(dataSource);
		campgroundDao = new JDBCCampgroundDAO(dataSource);
		siteDao = new JDBCSiteDAO(dataSource);
		reservationDao = new JDBCReservationDAO(dataSource);
		parks = parkDao.getAllParks();		
	}
	
	public List<Park> getParks() {
		return parks;
	}

	public List<Campground> getCampgroundsByParkId(long parkId) {
		campgrounds = campgroundDao.getCampgroundsById(parkId);
		return campgrounds;
	}

	public List<Site> getSites() {
		return sites;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	
}
