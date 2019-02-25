package com.techelevator.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.ReservationBooking;
import com.techelevator.ReservationBookingRequest;
import com.techelevator.ReservationSearch;
import com.techelevator.Util;
import com.techelevator.model.Campground;
import com.techelevator.model.CampgroundModel;
import com.techelevator.model.Park;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import com.techelevator.view.Menu;

public class CampgroundController {

	private CampgroundModel model;
	private Menu menu;
	private int indexCounter = 0;
	int displayOption = Util.DISPLAY_MODE_PARKS;
	boolean programActive = true;
	boolean firstTimeInMenu = true;
	Park park;
	Campground campground;
	ReservationBookingRequest reservationBooking;
	
	public CampgroundController(CampgroundModel model, Menu menu) {
		this.model = model;
		this.menu = menu;
	}
	
	public void run() {
		menu.displayWelcome();
		while (displayOption != Util.DISPLAY_MODE_PROGRAM_EXIT) {
			while (displayOption == Util.DISPLAY_MODE_PARKS) {
				if (firstTimeInMenu) {
					menu.displaySelectParksMessage();
					firstTimeInMenu = false;
				}
				int tempIndex = indexCounter;
				indexCounter = menu.displayParkList(model.getParks(), indexCounter);
				int choice = menu.getParkListChoice(indexCounter);
				switch (choice) {
				case -3:
					//SET PROGRAM BOOLEAN TO EXIT, END PROGRAM
					displayOption = Util.DISPLAY_MODE_PROGRAM_EXIT;
					menu.displayGoodbye();
					break;
				case -2: 
					break;
				case -1:
					//RESET INDEX COUNTER IN CASE OF ERROR INPUT
					indexCounter = tempIndex;
					break;
				case 0:
					menu.displayError();
				default:
					park = model.getParks().get(choice - 1);
					displayOption = Util.DISPLAY_MODE_PARK_DETAILS;
					firstTimeInMenu = true;
					indexCounter = 0;
					break;
				}
			}
			while (displayOption == Util.DISPLAY_MODE_PARK_DETAILS) {
				menu.displayParkDetails(park);
				int choice = menu.getParkDetailsChoice();
				switch (choice) {
				case 1:
					displayOption = Util.DISPLAY_MODE_CAMPGROUNDS;
					break;
				case 2: 
					displayOption = Util.DISPLAY_MODE_FIND_RESERVATION;
					break;
				case 3:
					displayOption = Util.DISPLAY_MODE_PARKS;
					break;
				default:
					break;
				}
			}
			while (displayOption == Util.DISPLAY_MODE_FIND_RESERVATION) {
				menu.displayFindReservations();
				ReservationSearch search = menu.getReservationInput();
				List<Reservation> list = new ArrayList<Reservation>();
				if (search.reservationId == -1) {
					menu.displayReservationSearchError();
				} else {
					if (search.isId) {
						list.add(model.getReservationByReservationId(search.reservationId, park.getParkId()));
					} else {
						list.addAll(model.getReservationsByNameOnReservation(search.nameOnReservation, park.getParkId()));
					}
					menu.displayReservationsFound(list);
					displayOption = Util.DISPLAY_MODE_PARK_DETAILS;
				}
			}
			while (displayOption == Util.DISPLAY_MODE_CAMPGROUNDS) {
				List<Campground> list = model.getCampgroundsByParkId(park.getParkId());
				menu.displayCampgroundsHeader(park);
				menu.displayCampgrounds(list, false);
				int choice = menu.getCampgroundChoice();
				switch (choice) {
				case 1:
					displayOption = Util.DISPLAY_MODE_AVAILABLE_RESERVATIONS;
					break;
				case 2:
					displayOption = Util.DISPLAY_MODE_PARK_DETAILS;
					break;
				default:
					break;
				}
			}
			while (displayOption == Util.DISPLAY_MODE_AVAILABLE_RESERVATIONS) {
				List<Campground> list = model.getCampgroundsByParkId(park.getParkId());
				menu.displayCampgrounds(list, true);
				ReservationBookingRequest booking = menu.getReservationBookingInput(list.size());
				if (booking.campgroundIndex == -1) {

				} else if (booking.campgroundIndex == -2) {
					displayOption = Util.DISPLAY_MODE_CAMPGROUNDS;
				} else {
					campground = list.get(booking.campgroundIndex);
					if (booking.arrivalDate.getMonth().getValue() < campground.getOpenMonth() || booking.departureDate.getMonth().getValue() > campground.getClosedMonth()) {
						menu.displayMonthOutOfBounds();
					} else if (booking.arrivalDate.isBefore(LocalDate.now())) {
						menu.displayBookingInPast();
					} else if (booking.departureDate.isBefore(booking.arrivalDate)) {
						menu.displayDepartureBeforeArrival();
					} else {
						displayOption = Util.DISPLAY_MODE_RESERVATION_RESULTS;
						reservationBooking = booking;
					}
				}
			}
			while (displayOption == Util.DISPLAY_MODE_RESERVATION_RESULTS ) {
				List<Site> list = getSitesFromBooking();
				menu.displayReservationResults(list, getCostFromBooking());
				ReservationBooking completeBooking = menu.getReservationBooking();
				Site site;
				if (completeBooking.siteNumber == 0 || completeBooking.name.equals("0")) {
					displayOption = Util.DISPLAY_MODE_AVAILABLE_RESERVATIONS;
				} else if (completeBooking.siteNumber != -1) {
					site = getSiteFromSiteNumber(completeBooking.siteNumber, list);
					long reservationId = model.makeReservation(new Reservation(site.getSiteId(), 
							completeBooking.name, reservationBooking.arrivalDate, 
							reservationBooking.departureDate, LocalDate.now()));
					menu.displayReservationSuccess(reservationId);
					displayOption = Util.DISPLAY_MODE_PARKS;
				} 				
			}
		}
	}
	
	private List<Site> getSitesFromBooking() {
		List<Site> sites = model.getSitesByCampgroundId(campground.getCampgroundId());
		List<Site> availableSites = new ArrayList<Site>(); 
		for (Site site : sites) {
			boolean siteAvailable = true;
			for (Reservation reservation : model.getReservationsBySiteId(site.getSiteId())) {
				LocalDate reservationStart = reservation.getFromDate();
				LocalDate reservationEnd = reservation.getToDate();
				LocalDate bookingStart = reservationBooking.arrivalDate;
				LocalDate bookingEnd = reservationBooking.departureDate;
				if (!(bookingStart.isAfter(reservationEnd) || bookingEnd.isBefore(reservationStart))) {
					siteAvailable = false;
				}
			}
			if (siteAvailable) {
				availableSites.add(site);
			}
		}
		return availableSites;
	}
	
	private String getCostFromBooking() {
		BigDecimal dailyFee = campground.getDailyFee();
		long days = reservationBooking.arrivalDate.until(reservationBooking.departureDate.plusDays(1), ChronoUnit.DAYS);
		return Util.convertBigDecimalToDollarString(dailyFee.multiply(BigDecimal.valueOf(days)));
	}
	
	public Site getSiteFromSiteNumber(int siteNumber, List<Site> list) {
		for (Site site : list) {
			if (site.getSiteNumber() == siteNumber) {
				return site;
			}
		}
		return null;
	}
}
