package com.techelevator.model;

import java.time.LocalDate;

public class Campground {

	private long campgroundId;
	private long parkId;
	private String name;
	private LocalDate openMonth;
	private LocalDate closedMonth;
	private double dailyFee;
	
	
	public Campground(long parkId, String name, LocalDate openMonth, LocalDate closedMonth, double dailyFee) {
		this.parkId = parkId;
		this.name = name;
		this.openMonth = openMonth;
		this.closedMonth = closedMonth;
		this.dailyFee = dailyFee;
	}
	
	public long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public long getParkId() {
		return parkId;
	}
	public String getName() {
		return name;
	}
	public LocalDate getOpenMonth() {
		return openMonth;
	}
	public LocalDate getClosedMonth() {
		return closedMonth;
	}
	public double getDailyFee() {
		return dailyFee;
	}	
}
