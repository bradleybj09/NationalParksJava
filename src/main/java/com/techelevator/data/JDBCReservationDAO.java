package com.techelevator.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Reservation;

public class JDBCReservationDAO implements ReservationDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Reservation> getReservationsBySiteId(long siteId) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		String sqlSelectReservations = "SELECT * FROM reservation WHERE site_id = ?;";
		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelectReservations, siteId);
		while (set.next()) {
			reservations.add(mapRowToReservation(set));
		}
		return reservations;
	}
	
	private Reservation mapRowToReservation(SqlRowSet set) {
		long reservationId = set.getLong("reservation_id");
		long siteId = set.getLong("site_id");
		String name = set.getString("name");
		LocalDate fromDate = set.getDate("from_date").toLocalDate();
		LocalDate toDate = set.getDate("to_date").toLocalDate();
		LocalDate createDate = set.getDate("create_date").toLocalDate();
		return new Reservation(reservationId, siteId, name, fromDate, toDate, createDate);
	}

	@Override
	public long createReservation(Reservation reservation) {
		String sqlInsertReservation = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) VALUES (?, ?, ?, ?, ?) RETURNING reservation_id;";
		SqlRowSet id = jdbcTemplate.queryForRowSet(sqlInsertReservation, reservation.getSiteId(), reservation.getName(), reservation.getFromDate(), reservation.getToDate(), reservation.getCreateDate());
		id.next();
		reservation.setReservationId(id.getLong(1));
		return id.getLong(1);
	}


	@Override
	public List<Reservation> getReservationsByNameOnReservation(String name, long parkId) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		String sqlSelectReservations = "SELECT * FROM reservation WHERE name = ?;";
		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelectReservations, name);
		while (set.next()) {
			reservations.add(mapRowToReservation(set));
		}
		return reservations;
	}


	@Override
	public Reservation getReservationByReservationId(long reservationId, long parkId) {
		String sqlSelectReservation = "SELECT * FROM reservation WHERE reservation_id = ?;";
		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelectReservation, reservationId);
		set.next();
		return mapRowToReservation(set);
	}

}
