package com.techelevator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> parks = new ArrayList<>();

		String sqlSelectParks = "SELECT * FROM park ORDER BY name ASC;";

		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelectParks);
		while (set.next()) {
			parks.add(mapRowToPark(set));
		}
		return parks;
	}
	
	private Park mapRowToPark(SqlRowSet set) {
		
		long parkId = set.getLong("park_id");
		String name = set.getString("name");
		String location = set.getString("location");
		LocalDate establishedDate = set.getDate("establish_date").toLocalDate();
		double area = set.getDouble("area");
		int visitors = set.getInt("visitors");
		String description = set.getString("description");
		
		return new Park(parkId, name, location, establishedDate, area, visitors, description);
	}
 }
