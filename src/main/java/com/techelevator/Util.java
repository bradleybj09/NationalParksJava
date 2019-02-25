package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	public static final String WHICH_CAMPGROUND = "Which campground would you like to search? (0) to return to previous screen.";
	public static final String WHAT_ARRIVAL = "What is your arrival date? (yyyy-mm-dd)";
	public static final String WHAT_DEPARTURE = "What is your departure date? (yyyy-mm-dd)";
	public static final String RESULTS_HEADER = "Here are your results:";
	public static final String SITE_NUMBER = "Site No.";
	public static final String MAX_OCCUPANCY = "Max Occup.";
	public static final String ACCESSIBLE = "Handicap Accessible";
	public static final String MAX_RV_LENGTH = "Max RV Length (ft)";
	public static final String UTILITY_HOOKUPS = "Utility Hookups";
	public static final String COST = "Cost";
	public static final String WHICH_SITE = "Which site would you like to reserve? (0) to return to previous screen.";
	public static final String WHAT_NAME_RESERVE = "What name would you like to put on the reservation? (0) to return to previous screen.";
	public static final String RESERVATION_CONFIRMED = "Your reservation was completed successfully. \nYour confirmation is: ";
	public static final String YES = "Yes";
	public static final String NO = "No";
	public static final String MORE = "M) More";
	public static final String QUIT = "Q) Quit";
	public static final String INPUT_NOT_VALID = "You did not enter a valid option. Please try again.";
	public static final String ERROR = "Something we didn't account for went wrong.";
	public static final String GOODBYE = "System exiting. Will I dream?";
	public static final String NO_RESERVATIONS_FOUND = "No reservations were found matching your search.";
	public static final String SEARCH_RESERVATION_PROMPT = "Please enter the name on the reservation(s) or the reservation ID";
	public static final String RESERVATION_SEARCH_ERROR = "You did not enter a valid input. Please try again.";
	public static final String CAMPGROUNDS = "Campgrounds";
	public static final String PRESS_ENTER_TO_RETURN = "Press enter to return to the main screen.";
	public static final String MONTH_OUT_OF_BOUNDS = "The campground is closed for at least part of your request. Please try again."; 
	public static final String DEPARTURE_BEFORE_ARRIVAL = "Your departure date is before your arrival date. Please try again.";
	public static final String BOOKING_IN_PAST = "Your booking dates are in the past. Please try again.";
	
	
	public static final int DISPLAY_MODE_PARKS = 1;
	public static final int DISPLAY_MODE_PARK_DETAILS = 2;
	public static final int DISPLAY_MODE_CAMPGROUNDS = 3;
	public static final int DISPLAY_MODE_SITES = 4;
	public static final int DISPLAY_MODE_RESERVATION_RESULTS = 5;
	public static final int DISPLAY_MODE_FIND_RESERVATION = 6;
	public static final int DISPLAY_MODE_AVAILABLE_RESERVATIONS = 7;
	public static final int DISPLAY_MODE_PROGRAM_EXIT = 99;
		
	public static String convertMonthIntToString(int i) {
		switch (i) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "Octanuary IDK WHAT DID YOU ENTER";
		}
	}
	
	public static String convertBigDecimalToDollarString(BigDecimal b) {
		return String.format("$%.2f",b.doubleValue());
	}
	
	public static List<String> stringBreak(String string, int maxChar) {

		List<String> subLines = new ArrayList<String>();

		int length = string.length();
		int start = 0;
		int end = maxChar;
		if (length > maxChar) {

		    int noOfLines = (length / maxChar) + 1;

		    int endOfStr[] = new int[noOfLines];

		    for (int f = 0; f < noOfLines - 1; f++) {

		        int end1 = maxChar;

		        endOfStr[f] = end;

		        if (string.charAt(end - 1) != ' ') {

		            if (string.charAt(end - 2) == ' ') {

		                subLines.add(string.substring(start, end - 1));
		                start = end - 1;
		                end = end - 1 + end1;

		            } else if (string.charAt(end - 2) != ' '
		                    && string.charAt(end) == ' ') {

		                subLines.add(string.substring(start, end));
		                start = end;
		                end = end + end1;

		            } else if (string.charAt(end - 2) != ' ') {

		                subLines.add(string.substring(start, end) + "-");
		                start = end;
		                end = end + end1;

		            } else if (string.charAt(end + 2) == ' ') {
		                System.out.println("m here ............");
		                int lastSpaceIndex = string.substring(start, end)
		                        .lastIndexOf("");
		                subLines.add(string.substring(start, lastSpaceIndex));

		                start = lastSpaceIndex;
		                end = lastSpaceIndex + end1;
		            }

		        } else {

		            subLines.add(string.substring(start, end));
		            start = end;
		            end = end + end1;
		        }
		    }
		    subLines.add(string.substring(endOfStr[noOfLines - 2], length));
		}
		return subLines;
	}
	
}
