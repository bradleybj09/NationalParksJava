package com.techelevator;

import java.math.BigDecimal;
import java.nio.charset.MalformedInputException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.data.JDBCCampgroundDAO;
import com.techelevator.data.JDBCParkDAO;
import com.techelevator.data.JDBCReservationDAO;
import com.techelevator.data.JDBCSiteDAO;
import com.techelevator.data.SiteDAO;
import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;

public class JDBCSiteDAOIntegrationTest extends DAOIntegrationTest {

	private static final String PARK_NAME = "Test Park";
	private static final String PARK_LOCATION = "Test State";
	private static final LocalDate ESTABLISH_DATE = LocalDate.of(1999, 01, 01);
	private static final double PARK_AREA = 1000;
	private static final int PARK_VISITORS = 1000;
	private static final String PARK_DESCRIPTION = "This is a test";
	private static final String CAMP_NAME = "Test Camp";
	private static final int CAMP_OPEN = 05;
	private static final int CAMP_CLOSE = 10;
	private static final BigDecimal CAMP_DAILY_FEE = new BigDecimal(5);
	private JDBCCampgroundDAO campDao;
	private final int SITE_NUMBER = 1;
	private final int MAX_OCC = 1;
	private final boolean ACCESSIBLE = true;
	private final int MAX_LENGTH = 1;
	private final boolean UTILITIES = true;
	private Park testPark;
	private Campground testCampground;
	private Site testSite;
	private JDBCSiteDAO siteDao;
	@Before
	public void setup() {
		//ADD A PARK TO PARK TABLE
		String sqlInsertTestPark = " INSERT INTO park (name, location, establish_date, area, visitors, description) "
				+ "VALUES (?,?,?,?,?,?) RETURNING park_id;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		SqlRowSet id = jdbcTemplate.queryForRowSet(sqlInsertTestPark,PARK_NAME,PARK_LOCATION,ESTABLISH_DATE,PARK_AREA,PARK_VISITORS,PARK_DESCRIPTION);
		id.next();
		testPark = new Park(id.getLong(1), PARK_NAME, PARK_LOCATION, ESTABLISH_DATE, PARK_AREA, PARK_VISITORS, PARK_DESCRIPTION);
		// ADD A CAMPGROUND TO CAMPGROUND TABLE WITH FK SET TO TEST PARK_ID
		String sqlInsertTheTestCampground = " INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) "
				+ "VALUES (?,?,?,?,?) RETURNING campground_id;";
		SqlRowSet id2 = jdbcTemplate.queryForRowSet(sqlInsertTheTestCampground, testPark.getParkId(), CAMP_NAME, CAMP_OPEN, CAMP_CLOSE, CAMP_DAILY_FEE);
		id2.next();
		testCampground = new Campground(id2.getLong(1), testPark.getParkId(), CAMP_NAME, CAMP_OPEN, CAMP_CLOSE, CAMP_DAILY_FEE);	
		campDao = new JDBCCampgroundDAO(getDataSource());
		//ADD SITE
		String sqlInsertTestSite = "INSERT INTO site (campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities) "
				+ "VALUES (?,?,?,?,?,?) RETURNING site_id;";
		SqlRowSet id3 = jdbcTemplate.queryForRowSet(sqlInsertTestSite, testCampground.getCampgroundId(), SITE_NUMBER, MAX_OCC, ACCESSIBLE, MAX_LENGTH, UTILITIES);
		id3.next();
		testSite = new Site(id3.getLong(1), testCampground.getCampgroundId(), SITE_NUMBER, MAX_OCC, ACCESSIBLE, MAX_LENGTH, UTILITIES);
		siteDao = new JDBCSiteDAO(getDataSource());
	}
	
	private void assertSiteEquals(Site s1, Site s2) {
		Assert.assertEquals(s1.getSiteId(), s2.getSiteId());
		Assert.assertEquals(s1.getCampgroundId(), s2.getCampgroundId());
		Assert.assertEquals(s1.getSiteNumber(), s2.getSiteNumber());
		Assert.assertEquals(s1.getMaxOccupancy(), s2.getMaxOccupancy());
		Assert.assertEquals(s1.getMaxRvLength(), s2.getMaxRvLength());
		Assert.assertEquals(s1.hasUtilityHookup(), s2.hasUtilityHookup());
		Assert.assertEquals(s1.isHandicapAccessible(), s2.isHandicapAccessible());
	}
	
	@Test
	public void test_get_sites_by_campground_id() {
		Site site = siteDao.getSitesByCampgroundId(testCampground.getCampgroundId()).get(0);
		assertSiteEquals(testSite, site);
	}
	
	@Test
	public void test_get_sites_by_park_id() {
		Site site = siteDao.getSitesByParkId(testPark.getParkId()).get(0);
		assertSiteEquals(testSite, site);
	}


	
}
