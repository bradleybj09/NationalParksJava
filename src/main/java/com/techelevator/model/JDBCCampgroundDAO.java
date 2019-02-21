package com.techelevator.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCCampgroundDAO implements CampgroundDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Campground> getCampgroundsById(long parkId) {
		// TODO Auto-generated method stub
		return null;
	}

}
