package com.techelevator.model;

import java.util.List;

public interface ReservationDAO {

	public List<Reservation> getReservationsBySiteId(long siteId);
	public long createReservation(Reservation reservation);
}
