package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;
import com.techelevator.ReservationSearch;
import com.techelevator.Util;
import com.techelevator.model.CampgroundModel;
import com.techelevator.model.Park;
import com.techelevator.model.Reservation;
import com.techelevator.view.Menu;

public class CampgroundController {

	private CampgroundModel model;
	private Menu menu;
	private int indexCounter = 0;
	int displayOption = Util.DISPLAY_MODE_PARKS;
	boolean programActive = true;
	boolean firstTimeInMenu = true;
	int parkIndex = -1;
	
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
					parkIndex = choice - 1;
					displayOption = Util.DISPLAY_MODE_PARK_DETAILS;
					firstTimeInMenu = true;
					indexCounter = 0;
					break;
				}
			}
			while (displayOption == Util.DISPLAY_MODE_PARK_DETAILS) {
				Park park = model.getParks().get(parkIndex);
				menu.displayParkDetails(park);
				int choice = menu.getParkDetailsChoice();
				switch (choice) {
				case -1:
					break;
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
						list.add(model.getReservationByReservationId(search.reservationId));
					} else {
						list.addAll(model.getReservationsByNameOnReservation(search.nameOnReservation));
					}
					menu.displayReservationsFound(list);
				}
			}
		}
	}
}
