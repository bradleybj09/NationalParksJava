package com.techelevator.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCReservationDAO implements ReservationDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Reservation> getReservationsBySiteId(long siteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long createReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return 0;
	}

}
