package com.techelevator;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.data.JDBCParkDAO;
import com.techelevator.model.Park;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest {

	private static final String PARK_NAME = "Test Park";
	private static final String PARK_LOCATION = "Test State";
	private static final LocalDate ESTABLISH_DATE = LocalDate.of(1999, 01, 01);
	private static final double PARK_AREA = 1000;
	private static final int PARK_VISITORS = 1000;
	private static final String PARK_DESCRIPTION = "This is a test";
	private JDBCParkDAO parkDao;
	private Park testPark;

	@Before
	public void setup() {
		String sqlInsertTestPark = " INSERT INTO park (name, location, establish_date, area, visitors, description) "
				+ "VALUES (?,?,?,?,?,?) RETURNING park_id;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		SqlRowSet id = jdbcTemplate.queryForRowSet(sqlInsertTestPark,PARK_NAME,PARK_LOCATION,ESTABLISH_DATE,PARK_AREA,PARK_VISITORS,PARK_DESCRIPTION);
		id.next();
		testPark = new Park(id.getLong(1), PARK_NAME, PARK_LOCATION, ESTABLISH_DATE, PARK_AREA, PARK_VISITORS, PARK_DESCRIPTION);
		parkDao = new JDBCParkDAO(getDataSource());
	}
	
	@Test
	public void get_all_parks () {
		List<Park> results = parkDao.getAllParks();
		for (Park park : results) {
			if (park.getParkId() == testPark.getParkId()) {
				assertParkEquals(testPark, park);
			}
		}
	}
	
	private void assertParkEquals(Park p1, Park p2) {
		Assert.assertEquals(p1.getParkId(), p2.getParkId());
		Assert.assertEquals(p1.getName(), p2.getName());
		Assert.assertEquals(p1.getLocation(), p1.getLocation());
		Assert.assertEquals(p1.getLocation(), p1.getLocation());
		Assert.assertEquals(p1.getParkDescription(), p2.getParkDescription());
		Assert.assertEquals(p1.getAnnualVisitorCount(), p2.getAnnualVisitorCount());
		Assert.assertEquals(p1.getEstablishedDate(), p2.getEstablishedDate());
	}
}
