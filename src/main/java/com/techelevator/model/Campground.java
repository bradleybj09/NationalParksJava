package com.techelevator.model;

import java.math.BigDecimal;

public class Campground {

	private long campgroundId;
	private long parkId;
	private String name;
	private int openMonth;
	private int closedMonth;
	private BigDecimal dailyFee;
	
	
	public Campground(long parkId, String name, int openMonth, int closedMonth, BigDecimal dailyFee) {
		this.parkId = parkId;
		this.name = name;
		this.openMonth = openMonth;
		this.closedMonth = closedMonth;
		this.dailyFee = dailyFee;
	}
	
	public Campground(long campgroundId, long parkId, String name, int openMonth, int closedMonth, BigDecimal dailyFee) {
		this.campgroundId = campgroundId;
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
	public int getOpenMonth() {
		return openMonth;
	}
	public int getClosedMonth() {
		return closedMonth;
	}
	public BigDecimal getDailyFee() {
		return dailyFee;
	}	
}
