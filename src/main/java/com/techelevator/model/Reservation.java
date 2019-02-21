package com.techelevator.model;

import java.time.LocalDate;

public class Reservation {
	
	private long reservationId;
	private long siteId;
	private String name;
	private LocalDate fromDate;
	private LocalDate toDate;
	private LocalDate createDate;
	
	public Reservation(long siteId, String name, LocalDate fromDate, LocalDate toDate, LocalDate createDate) {
		this.siteId = siteId;
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.createDate = createDate;
	}
	
	public void setReservationId(long id) {
		reservationId = id;
	}

	public long getReservationId() {
		return reservationId;
	}

	public long getSiteId() {
		return siteId;
	}

	public String getName() {
		return name;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}
	
	
}
