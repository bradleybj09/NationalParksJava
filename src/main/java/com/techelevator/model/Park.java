package com.techelevator.model;

import java.time.LocalDate;

public class Park {

	private long parkId;
	private String name;
	private String location;
	private LocalDate establishedDate;
	private double area;
	private int annualVisitorCount;
	private String parkDescription;
	
	public Park(String name, String location, LocalDate establishedDate, double area, int annualVisitorCount, String parkDescription) {
		this.name = name;
		this.location = location;
		this.establishedDate = establishedDate;
		this.area = area;
		this.annualVisitorCount = annualVisitorCount;
		this.parkDescription = parkDescription;
	}
	
	public Park(Long parkId, String name, String location, LocalDate establishedDate, double area, int annualVisitorCount, String parkDescription) {
		this.parkId = parkId;
		this.name = name;
		this.location = location;
		this.establishedDate = establishedDate;
		this.area = area;
		this.annualVisitorCount = annualVisitorCount;
		this.parkDescription = parkDescription;
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

	public String getLocation() {
		return location;
	}

	public LocalDate getEstablishedDate() {
		return establishedDate;
	}

	public double getArea() {
		return area;
	}

	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}

	public String getParkDescription() {
		return parkDescription;
	}

	
}
