package com.techelevator;

public class ReservationSearch {
	
	public int reservationId;
	public String nameOnReservation;
	public boolean isId;
	
	public ReservationSearch(int id, String name) {
		reservationId = id;
		nameOnReservation = name;
		if (name == null) {
			isId = true;
		} else {
			isId = false;
		}
	}
}
