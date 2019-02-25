package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.data.JDBCCampgroundDAO;
import com.techelevator.data.JDBCParkDAO;
import com.techelevator.model.Campground;
import com.techelevator.model.Park;

public class JDBCCampgroundDAOIntegrationTest extends DAOIntegrationTest {

	private static final String PARK_NAME = "Test Park";
	private static final String PARK_LOCATION = "Test State";
	private static final LocalDate ESTABLISH_DATE = LocalDate.of(1999, 01, 01);
	private static final double PARK_AREA = 1000;
	private static final int PARK_VISITORS = 1000;
	private static final String PARK_DESCRIPTION = "This is a test";
	private static final String CAMP_NAME = "Test Camp";
	private static final int CAMP_OPEN = 05;
	private static final int CAMP_CLOSE = 10;
	private static final BigDecimal CAMP_DAILY_FEE = new BigDecimal("5.0");
	private JDBCCampgroundDAO campDao;
	private Park testPark;
	private Campground testCampground;

	@Before
	public void setup() {
		// ADD A PARK TO PARK TABLE
		String sqlInsertTestParkString = "INSERT INTO park (name, location, establish_date, area, visitors, description)"
				+ "VALUES ( ?, ?, ?, ?, ?, ?) RETURNING park_id;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		SqlRowSet id = jdbcTemplate.queryForRowSet(sqlInsertTestParkString, PARK_NAME, PARK_LOCATION, ESTABLISH_DATE, PARK_AREA,
				PARK_VISITORS, PARK_DESCRIPTION);
		id.next();
		testPark = new Park(id.getLong(1), PARK_NAME, PARK_LOCATION, ESTABLISH_DATE, PARK_AREA, PARK_VISITORS, PARK_DESCRIPTION);
		// ADD A CAMPGROUND TO CAMPGROUND TABLE WITH FK SET TO TEST PARK_ID
		String sqlInsertTheTestCampground = " INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) "
				+ "VALUES (?,?,?,?,?) RETURNING campground_id;";
		SqlRowSet id2 = jdbcTemplate.queryForRowSet(sqlInsertTheTestCampground, testPark.getParkId(), CAMP_NAME, CAMP_OPEN, CAMP_CLOSE, CAMP_DAILY_FEE);
		id2.next();
		testCampground = new Campground(id2.getLong(1), testPark.getParkId(), CAMP_NAME, CAMP_OPEN, CAMP_CLOSE, CAMP_DAILY_FEE);	
		campDao = new JDBCCampgroundDAO(getDataSource());
	}
	
	private void assertCampgroundEquals(Campground c1, Campground c2) {
		Assert.assertEquals(c1.getCampgroundId(), c2.getCampgroundId());
		Assert.assertEquals(c1.getParkId(), c2.getParkId());
		Assert.assertEquals(c1.getName(), c2.getName());
		Assert.assertEquals(c1.getOpenMonth(), c2.getOpenMonth());
		Assert.assertEquals(c1.getClosedMonth(), c1.getClosedMonth());
		Assert.assertEquals(c1.getDailyFee(), c2.getDailyFee());
	}
	
	@Test
	public void test_get_campground_by_park_id() {
		List<Campground> results = campDao.getCampgroundsById(testPark.getParkId());
		Assert.assertNotNull(results);
		assertCampgroundEquals(testCampground, results.get(0));
	}
}
