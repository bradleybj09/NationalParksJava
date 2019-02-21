package com.techelevator.controller;

import com.techelevator.Util;
import com.techelevator.model.CampgroundModel;
import com.techelevator.view.Menu;

public class CampgroundController {

	private CampgroundModel model;
	private Menu menu;
	private int indexCounter = 0;
	int displayOption = Util.DISPLAY_MODE_PARKS;
	boolean programActive = true;
	boolean firstTimeInMenu = true;
	int parkChoice = -1;
	
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
					parkChoice = choice;
					displayOption = Util.DISPLAY_MODE_CAMPGROUNDS;
					firstTimeInMenu = true;
					break;
				}
			}
			while (displayOption == Util.DISPLAY_MODE_CAMPGROUNDS) {
				
			}
		}
	}
}
