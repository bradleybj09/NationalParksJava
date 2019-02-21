package com.techelevator.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.Util;
import com.techelevator.model.Campground;

public class JDBCCampgroundDAO implements CampgroundDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Campground> getCampgroundsById(long parkId) {
		List<Campground> campgrounds = new ArrayList<Campground>();

		String sqlSelectCampgrounds = "SELECT * FROM campgrounds WHERE park_id = ? ORDER BY name ASC;";

		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelectCampgrounds, parkId);
		
		while(set.next()) {
			campgrounds.add(mapRowToCampground(set));
		}
		return campgrounds;
	}
	
	private Campground mapRowToCampground(SqlRowSet set) {
		long campgroundId = set.getLong("campground_id");
		long parkId = set.getLong("park_id");
		String name = set.getString("name");
		int openMonth = set.getInt("open_from_mm");
		int closedMonth = set.getInt("open_to_mm");
		BigDecimal dailyFee = set.getBigDecimal("daily_fee");
		return new Campground(campgroundId, parkId, name, openMonth, closedMonth, dailyFee);
	}

}
