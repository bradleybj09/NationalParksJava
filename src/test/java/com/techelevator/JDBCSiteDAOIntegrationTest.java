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
import com.techelevator.data.JDBCReservationDAO;
import com.techelevator.data.JDBCSiteDAO;
import com.techelevator.data.SiteDAO;
import com.techelevator.model.Campground;
import com.techelevator.model.Reservation;

public class JDBCSiteDAOIntegrationTest extends DAOIntegrationTest {

	private static final long PARK_ID = (long) 4; // NEXT AVAILABLE ROW
	private static final String PARK_NAME = "Test Park";
	private static final String PARK_LOCATION = "Test State";
	private static final LocalDate ESTABLISH_DATE = LocalDate.of(1999, 01, 01);
	private static final long PARK_AREA = 1000;
	private static final long PARK_VISITORS = 1000;
	private static final String PARK_DESCRIPTION = "This is a test";
	private JDBCParkDAO parkDao;
	private static final long CAMPGROUND_ID = (long) 8; // NEXT AVAILABLE ROW
	private static final String CAMP_NAME = "Test Camp";
	private static final int CAMP_OPEN = 05;
	private static final int CAMP_CLOSE = 10;
	private static final BigDecimal CAMP_DAILY_FEE = new BigDecimal(5);
	private JDBCCampgroundDAO campDao;
	private static final String RES_NAME = "Test Name";	
	private static final long SITE_ID = (long) 1000000;
	private static final LocalDate RES_FROM = LocalDate.of(1999, 05,01);
	private static final LocalDate RES_TO = LocalDate.of(1999, 06, 01);
	private static final LocalDate CREATE_DATE = LocalDate.of(1998, 01, 01);
	private JDBCReservationDAO reservationDao;
	private Reservation testReservation;
	private JDBCSiteDAO siteDao;
	@Before
	public void setup() {
		//ADD A PARK TO PARK TABLE
		String sqlInsertTheTestPark = " INSERT INTO park (park_id, name, location, establish_date, area, visitors, description) "
				+ "VALUES (?,?,?,?,?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertTheTestPark,PARK_ID,PARK_NAME,PARK_LOCATION,ESTABLISH_DATE,PARK_AREA,PARK_VISITORS,PARK_DESCRIPTION);
		parkDao = new JDBCParkDAO(getDataSource());
		//ADD A CAMPGROUND WITH PARK_ID AS FK
		String sqlInsertTheTestCampground = " INSERT INTO campground (campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee) "
				+ "VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertTheTestCampground, CAMPGROUND_ID,PARK_ID,CAMP_NAME,CAMP_OPEN,CAMP_CLOSE,CAMP_DAILY_FEE);
		campDao = new JDBCCampgroundDAO(getDataSource());
		reservationDao = new JDBCReservationDAO(getDataSource());
		siteDao = new JDBCSiteDAO(getDataSource());

	}
	
	@Test
	public void test_get_site_by_park_id() {
		List<Campground> results = campDao.getCampgroundsById(PARK_ID);
		Assert.assertNotNull(results);
		Campground test = results.get(0);
		Assert.assertEquals("Test Camp", test.getName());
	}


	
}
