package com.techelevator;

public class Util {
	private Util() {}

	public static final String WELCOME = "Welcome to the national parks reservation system! \nWe hope you enjoy your stay!";
	public static final String SELECT_PARK = "Select a park to view more information";
	public static final String DETAILS_HEADER = "Details about ";
	public static final String LOCATION = "Location:";
	public static final String ESTABLISHED = "Established:";
	public static final String AREA = "Area:";
	public static final String ANNUAL_VISITOR = "Annual Visitors:";
	public static final String MAKE_CHOICE = "Please make a choice:";
	public static final String VIEW_CAMPGROUNDS = "View Campgrounds";
	public static final String FIND_RESERVATION = "Find an existing Reservation";
	public static final String RETURN_TO_PREVIOUS = "Go Back to Previous Screen";
	public static final String NAME = "Name";
	public static final String OPEN = "Open";
	public static final String CLOSE = "Close";
	public static final String DAILY_FEE = "Daily Fee";
	public static final String SEARCH_AVAILABLE_RESERVATION = "Search for an available Reservation";
	public static final String WHICH_CAMPGROUND = "Which campground would you like to search?";
	public static final String WHAT_ARRIVAL = "What is your arrival date? (mm/dd/yyyy)";
	public static final String WHAT_DEPARTURE = "What is your departure date? (mm/dd/yyyy)";
	public static final String RESULTS_HEADER = "Here are your results:";
	public static final String SITE_NUMBER = "Site No.";
	public static final String MAX_OCCUPANCY = "Max Occup.";
	public static final String ACCESSIBLE = "Handicap Accessible";
	public static final String MAX_RV_LENGTH = "Max RV Length (ft)";
	public static final String UTILITY_HOOKUPS = "Utility Hookups";
	public static final String COST = "Cost";
	public static final String WHICH_SITE = "Which site would you like to reserve?";
	public static final String WHAT_NAME_RESERVE = "What name would you like to put on the reservation?";
	public static final String RESERVATION_CONFIRMED = "Your reservation was completed successfully. \nYour confirmation is: ";
	public static final String YES = "Yes";
	public static final String NO = "No";
	public static final String MORE = "M) More";
	public static final String QUIT = "Q) Quit";
	public static final String INPUT_NOT_VALID_INTEGER = "You did not enter a valid option. Please try again.";
	public static final String ERROR = "Something we didn't account for went wrong.";
	public static final String GOODBYE = "System exiting. Will I dream?";
	public static final String NO_RESERVATIONS_FOUND = "No reservations were found matching your search.";
	public static final String SEARCH_RESERVATION_PROMPT = "Please enter the name on the reservation(s) or the reservation ID";
	public static final String RESERVATION_SEARCH_ERROR = "You did not enter a valid input. Please try again.";
	
	public static final int DISPLAY_MODE_PARKS = 1;
	public static final int DISPLAY_MODE_PARK_DETAILS = 2;
	public static final int DISPLAY_MODE_CAMPGROUNDS = 3;
	public static final int DISPLAY_MODE_SITES = 4;
	public static final int DISPLAY_MODE_RESERVATIONS = 5;
	public static final int DISPLAY_MODE_FIND_RESERVATION = 6;
	public static final int DISPLAY_MODE_PROGRAM_EXIT = 99;
	
	public static int convertDoubleToInt(double d) {
		double cents = d * 100;
		return (int)cents;
	}
	
	public static double convertIntToDouble(int i) {
		double d = i / 100.0;
		return d;
	}
	
}
