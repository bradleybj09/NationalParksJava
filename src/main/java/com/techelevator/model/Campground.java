package com.techelevator.model;

import java.time.LocalDate;

public class Campground {

	private long campgroundId;
	private long parkId;
	private String name;
	private LocalDate openMonth;
	private LocalDate closedMonth;
	private double dailyFee;
	
	public long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public long getParkId() {
		return parkId;
	}
	public void setParkId(long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getOpenMonth() {
		return openMonth;
	}
	public void setOpenMonth(LocalDate openMonth) {
		this.openMonth = openMonth;
	}
	public LocalDate getClosedMonth() {
		return closedMonth;
	}
	public void setClosedMonth(LocalDate closedMonth) {
		this.closedMonth = closedMonth;
	}
	public double getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(double dailyFee) {
		this.dailyFee = dailyFee;
	}
	
}
