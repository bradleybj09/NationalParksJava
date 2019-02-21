package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.data.CampgroundDAO;
import com.techelevator.data.JDBCCampgroundDAO;
import com.techelevator.data.JDBCParkDAO;
import com.techelevator.data.JDBCReservationDAO;
import com.techelevator.data.JDBCSiteDAO;
import com.techelevator.data.ParkDAO;
import com.techelevator.data.ReservationDAO;
import com.techelevator.data.SiteDAO;

public class Model {
	
	private ParkDAO parkDao;
	private CampgroundDAO campgroundDao;
	private SiteDAO siteDao;
	private ReservationDAO reservationDao;
	private List<Park> parks;
	
	public Model(BasicDataSource dataSource) {
		parks = new ArrayList<Park>();
		parkDao = new JDBCParkDAO(dataSource);
		campgroundDao = new JDBCCampgroundDAO(dataSource);
		siteDao = new JDBCSiteDAO(dataSource);
		reservationDao = new JDBCReservationDAO(dataSource);
		parks = parkDao.getAllParks();		
	}
	
	public List<Park> getParks() {
		//KEEP LIST OF PARKS WITHOUT NEEDING TO REQUERY DATABASE
		return parks;
	}

	public List<Campground> getCampgroundsByParkId(long parkId) {
		return campgroundDao.getCampgroundsById(parkId);
	}

	public List<Site> getSitesByCampgroundId(long campgroundId) {
		return siteDao.getSitesByCampgroundId(campgroundId);
	}
	
	public List<Site> getSitesByParkId(long parkId) {
		return siteDao.getSitesByParkId(parkId);
	}

	public List<Reservation> getReservationsBySiteId(long siteId) {
		return reservationDao.getReservationsBySiteId(siteId);
	}

	
}
