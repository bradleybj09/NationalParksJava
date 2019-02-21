package com.techelevator.data;

import java.util.List;

import com.techelevator.model.Reservation;

public interface ReservationDAO {

	public List<Reservation> getReservationsBySiteId(long siteId);
	public long createReservation(Reservation reservation);
}
