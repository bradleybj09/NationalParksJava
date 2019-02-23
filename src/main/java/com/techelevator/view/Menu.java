package com.techelevator.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.techelevator.ReservationBooking;
import com.techelevator.ReservationBookingRequest;
import com.techelevator.ReservationSearch;
import com.techelevator.Util;
import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;

public class Menu {

	Scanner scanner;
	
	public Menu() {
		scanner = new Scanner(System.in);
	}
	
	public void displayWelcome() {
		System.out.println(Util.WELCOME);
	}
	
	public void displayGoodbye() {
		System.out.println(Util.GOODBYE);
	}
	
	public void displaySelectParksMessage() {
		System.out.println(Util.SELECT_PARK);
	}
	
	public void displayError() {
		System.out.println(Util.ERROR);
	}
	
	public int displayParkList(List<Park> parks, int startIndex) {
		boolean listFinished = false;
		int endIndex = 0;
		for (int i = startIndex; i < startIndex + 3; i++) {
			//START ON INDEX BASED ON MORE INPUT
			if (i < parks.size()) {
				System.out.println("\t" + (i+1) + ") " + parks.get(i).getName());
			} if (i >= parks.size() - 1){
				//IF ON LAST INDEX, DO NOT PRINT MORE
				listFinished = true;
			}
			endIndex = i;
		}
		if (!listFinished) {
			System.out.println("\t" + Util.MORE);
		}
		System.out.println("\t" + Util.QUIT);
		return endIndex;
	}
	
	public int getParkListChoice(int maxChoice) {
		String input = scanner.nextLine();
		int inputInt = 0;
		if (input.equals("") || input == null) {
			return -1;
		}
		if (input.toLowerCase().equals("m")) {
			return -2;
		}
		if (input.toLowerCase().equals("q")) {
			return -3;
		}
		try {
			inputInt = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println(Util.INPUT_NOT_VALID);
			return -1;
		}
		if (inputInt < 1 || inputInt > maxChoice) {
			System.out.println(Util.INPUT_NOT_VALID);
			return -1;
		} else {
			return inputInt;
		}		
	}
	public void displayParkDetails(Park park) {
		System.out.println(park.getName());
		System.out.println(Util.LOCATION + "\t" + park.getLocation());
		System.out.println(Util.ESTABLISHED + "\t" + park.getEstablishedDate());
		System.out.println(Util.AREA + "\t" + park.getArea());
		System.out.println(Util.ANNUAL_VISITOR + "\t" + park.getAnnualVisitorCount());
		System.out.println();
		System.out.println(park.getParkDescription());
		System.out.println();
		System.out.println(Util.MAKE_CHOICE);
		System.out.println("\t1) " + Util.VIEW_CAMPGROUNDS);
		System.out.println("\t2) " + Util.FIND_RESERVATION);
		System.out.println("\t3) " + Util.RETURN_TO_PREVIOUS);
	}
	
	public int getParkDetailsChoice() {
		String input = scanner.nextLine();
		int inputInt = 0;
		if (input.equals("") || input == null) {
			return -1;
		}
		try {
			inputInt = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println(Util.INPUT_NOT_VALID);
			return -1;
		}
		if (inputInt < 1 || inputInt > 3) {
			System.out.println(Util.INPUT_NOT_VALID);
			return -1;
		} else {
			return inputInt;
		}		

	}
	
	public void displayFindReservations() {
		System.out.println(Util.SEARCH_RESERVATION_PROMPT);
	}
	
	public ReservationSearch getReservationInput() {
		String input = scanner.nextLine();
		if (input.equals("") || input == null) {
			return new ReservationSearch(-1, null);
		}
		try {
			int inputInt = Integer.parseInt(input);
			return new ReservationSearch(inputInt, null);
		} catch (Exception e) {
			return new ReservationSearch(0, input);
		}

	}
	
	public void displayReservationsFound(List<Reservation> list) {
		if (list.size() == 0) {
			System.out.println(Util.NO_RESERVATIONS_FOUND);
		} else {
			for (Reservation reservation : list) {
				System.out.println("Reservation ID: " + reservation.getReservationId()
						+ "\n\tName on Reservation: " +  reservation.getName()
						+ "\n\tDates: " + reservation.getFromDate() + " - " + reservation.getToDate());
				System.out.println();
				System.out.println(Util.PRESS_ENTER_TO_RETURN);
				scanner.nextLine();
			}
		}
	}
	
	public void displayReservationSearchError() {
		System.out.println(Util.RESERVATION_SEARCH_ERROR);
	}
	
	public void displayCampgroundsHeader(Park park) {
		System.out.println(park.getName() + " " + Util.CAMPGROUNDS);
		System.out.println();

	}
	
	public void displayCampgrounds(List<Campground> list, boolean includeNumbers) {
		System.out.println("\t" + Util.NAME + "\t" + Util.OPEN + "\t" + Util.CLOSE + "\t" + Util.DAILY_FEE);
		for (int i = 0; i < list.size(); i++) {
			Campground c = list.get(i);
			if (includeNumbers) {
				System.out.println("\t" + (i+1) + ")\t" + c.getName() 
						+ "\t" + Util.convertMonthIntToString(c.getOpenMonth()) 
						+ "\t" + Util.convertMonthIntToString(c.getClosedMonth())
						+ "\t" + Util.convertBigDecimalToDollarString(c.getDailyFee()));
			} else {
				System.out.println("\t" + c.getName() 
						+ "\t" + Util.convertMonthIntToString(c.getOpenMonth()) 
						+ "\t" + Util.convertMonthIntToString(c.getClosedMonth())
						+ "\t" + Util.convertBigDecimalToDollarString(c.getDailyFee()));
			}
		}
	}
	
	public int getCampgroundChoice() {
		System.out.println();
		System.out.println(Util.MAKE_CHOICE);
		System.out.println("\t1)" + Util.SEARCH_AVAILABLE_RESERVATION);
		System.out.println("\t2)" + Util.RETURN_TO_PREVIOUS);
		String input = scanner.nextLine();
		int inputIndex = 0;
		try {
			inputIndex = Integer.parseInt(input);
		} catch (Exception e) {
			return -1;
		}
		if (inputIndex < 1 || inputIndex > 2) {
			System.out.println(Util.INPUT_NOT_VALID);
			return -1;
		} else {
			return inputIndex;
		}
	}
	
	public ReservationBookingRequest getReservationBookingInput(int maxIndex) {
		System.out.println(Util.WHICH_CAMPGROUND);
		String input = scanner.nextLine();
		int campgroundIndex = -1;
		try {
			campgroundIndex = Integer.parseInt(input);
			if (campgroundIndex == -2) {
				return new ReservationBookingRequest(0, null, null);
			}
			campgroundIndex -= 1;
		} catch (Exception e) {
			System.out.println(Util.INPUT_NOT_VALID);
			return new ReservationBookingRequest(-1, null, null);
		}
		if (campgroundIndex > maxIndex) {
			System.out.println(Util.INPUT_NOT_VALID);
			return new ReservationBookingRequest(-1, null, null);
		}
		System.out.println(Util.WHAT_ARRIVAL);
		input = scanner.nextLine();
		LocalDate arrivalDate = LocalDate.now();
		try {
			arrivalDate = LocalDate.parse(input);
		} catch (Exception e) {
			System.out.println(Util.INPUT_NOT_VALID);
			return new ReservationBookingRequest(-1, null, null);
		}
		System.out.println(Util.WHAT_DEPARTURE);
		input = scanner.nextLine();
		LocalDate departureDate = LocalDate.now();
		try {
			departureDate = LocalDate.parse(input);
		} catch (Exception e) {
			System.out.println(Util.INPUT_NOT_VALID);
			return new ReservationBookingRequest(-1, null, null);
		}
		return new ReservationBookingRequest(campgroundIndex, arrivalDate, departureDate);
	}
	
	public void displayReservationResults(List<Site> list, String cost) {
		System.out.println(Util.RESULTS_HEADER);
		System.out.println(Util.SITE_NUMBER
				+ "\t" + Util.MAX_OCCUPANCY
				+ "\t" + Util.ACCESSIBLE
				+ "\t" + Util.MAX_RV_LENGTH
				+ "\t" + Util.UTILITY_HOOKUPS
				+ "\t" + Util.COST);
		for (Site site : list) {
			System.out.println(site.getSiteNumber()
					+ "\t" + site.getMaxOccupancy()
					+ "\t" + site.isHandicapAccessible()
					+ "\t" + site.getMaxRvLength()
					+ "\t" + site.hasUtilityHookup()
					+ "\t" + cost);
		}
	}
	
	public ReservationBooking getReservationBooking() {
		System.out.println(Util.WHICH_SITE);
		String input = scanner.nextLine();
		if (input.equals("") || input == null) {
			System.out.println(Util.INPUT_NOT_VALID);
			return new ReservationBooking(-1, null);
		}
		int siteNumber = -1;
		try {
			siteNumber = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println(Util.INPUT_NOT_VALID);
			return new ReservationBooking(-1, null);
		}
		System.out.println(Util.WHAT_NAME_RESERVE);
		input = scanner.nextLine();
		if (input.equals("") || input == null) {
			System.out.println(Util.INPUT_NOT_VALID);
			return new ReservationBooking(-1, null);
		}
		return new ReservationBooking(siteNumber, input);
	}
	
	public void displayReservationSuccess(long id) {
		System.out.println(Util.RESERVATION_CONFIRMED + id);
		System.out.println(Util.PRESS_ENTER_TO_RETURN);
		scanner.nextLine();
	}
	
	public void displayMonthOutOfBounds() {
		System.out.println(Util.MONTH_OUT_OF_BOUNDS);
	}
	
	public void displayBookingInPast() {
		System.out.println(Util.BOOKING_IN_PAST);
	}
	
	public void displayDepartureBeforeArrival() {
		System.out.println(Util.DEPARTURE_BEFORE_ARRIVAL);
	}
}
