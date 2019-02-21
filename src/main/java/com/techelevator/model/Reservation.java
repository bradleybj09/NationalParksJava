package com.techelevator.model;

import java.util.Date;

public class Reservation {
	
	private long reservationId;
	private long siteId;
	private String name;
	private Date fromDate;
	private Date toDate;
	private Date createDate;
	
	public Reservation(long siteId, String name, Date fromDate, Date toDate, Date createDate) {
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

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	
}
