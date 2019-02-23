package com.techelevator;

import java.time.LocalDate;

public class ReservationBookingRequest {

	public ReservationBookingRequest(int campgroundIndex, LocalDate arrivalDate, LocalDate departureDate) {
		this.campgroundIndex = campgroundIndex;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}
	
	public int campgroundIndex;
	public LocalDate arrivalDate;
	public LocalDate departureDate;
}
