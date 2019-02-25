package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.data.JDBCCampgroundDAO;
import com.techelevator.data.JDBCParkDAO;
import com.techelevator.model.Park;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest {

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

	@Before
	public void setup() {
		String sqlInsertTestPark = " INSERT INTO park (park_id, name, location, establish_date, area, visitors, description) "
				+ "VALUES (?,?,?,?,?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertTestPark,PARK_ID,PARK_NAME,PARK_LOCATION,ESTABLISH_DATE,PARK_AREA,PARK_VISITORS,PARK_DESCRIPTION);
		parkDao = new JDBCParkDAO(getDataSource());
	}
	
	@Test
	public void get_all_parks () {
		List<Park> results = parkDao.getAllParks();
		Assert.assertEquals(4, results.size());	//SHOULD RETURN 4 SINCE NEW PARK WAS INSERTED @BEFORE
	}

	
	
}
