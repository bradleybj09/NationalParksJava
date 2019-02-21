package com.techelevator.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCSiteDAO implements SiteDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Site> getSitesByCampgroundId(long campgroundId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getSitesByParkId(long parkId) {
		// TODO Auto-generated method stub
		return null;
	}

}
