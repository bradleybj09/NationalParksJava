package com.techelevator.view;

import java.util.List;
import java.util.Scanner;

import com.techelevator.Util;
import com.techelevator.model.Park;

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
}
