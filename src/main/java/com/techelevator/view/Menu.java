package com.techelevator.view;

import java.util.List;
import java.util.Scanner;
import com.techelevator.ReservationSearch;
import com.techelevator.Util;
import com.techelevator.model.Park;
import com.techelevator.model.Reservation;

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
		if (input.equals("M")) {
			return -2;
		}
		if (input.equals("Q")) {
			return -3;
		}
		try {
			inputInt = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println(Util.INPUT_NOT_VALID_INTEGER);
			return -1;
		}
		if (inputInt < 1 || inputInt > maxChoice) {
			System.out.println(Util.INPUT_NOT_VALID_INTEGER);
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
			System.out.println(Util.INPUT_NOT_VALID_INTEGER);
			return -1;
		}
		if (inputInt < 1 || inputInt > 3) {
			System.out.println(Util.INPUT_NOT_VALID_INTEGER);
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
			}
		}
	}
	
	public void displayReservationSearchError() {
		System.out.println(Util.RESERVATION_SEARCH_ERROR);
	}
	
}
