package com.techelevator.data;

import java.util.List;

import com.techelevator.model.Reservation;

public interface ReservationDAO {

	public List<Reservation> getReservationsBySiteId(long siteId);
	public List<Reservation> getReservationsByNameOnReservation(String name, long parkId);
	public Reservation getReservationByReservationId(long reservationId, long parkId);
	public long createReservation(Reservation reservation);
}
