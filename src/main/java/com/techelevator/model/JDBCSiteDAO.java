package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAO implements SiteDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Site> getSitesByCampgroundId(long campgroundId) {
		List<Site> sites = new ArrayList<Site>();
		String sqlSelectSites = "Select * FROM site WHERE campground_id = ? ORDER BY name ASC;";
		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelectSites, campgroundId);
		while(set.next()) {
			sites.add(mapRowToSite(set));
		}
 		return sites;
	}
	
	private Site mapRowToSite(SqlRowSet set) {
		long siteId = set.getLong("site_id");
		long campgroundId = set.getLong("campground_id");
		int siteNumber = set.getInt("site_number");
		int maxOccupancy = set.getInt("max_occupancy");
		boolean isHandicapAccessible = set.getBoolean("accessible");
		int maxRvLength = set.getInt("max_rv_length");
		boolean hasUtilityHookup = set.getBoolean("utilities");
		return new Site(siteId, campgroundId, siteNumber, maxOccupancy, isHandicapAccessible, maxRvLength, hasUtilityHookup);
	}

	@Override
	public List<Site> getSitesByParkId(long parkId) {
		List<Site> sites = new ArrayList<Site>();
		String sqlSelectSites = "Select site.* FROM site JOIN campground ON site.campground_id = campground.campground_id WHERE campground.park_id = ? ORDER BY name ASC;";
		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlSelectSites, parkId);
		while(set.next()) {
			sites.add(mapRowToSite(set));
		}
 		return sites;
	}

}
