package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

	
	@Test
	public void test_convert_to_string() {
		String string = Util.convertBigDecimalToDollarString(new BigDecimal("3.50"));
		Assert.assertEquals("$3.50", string);
	}
	
	@Test
	public void test_date_check() {
		Assert.assertEquals("January", Util.convertMonthIntToString(1));
		Assert.assertEquals("February", Util.convertMonthIntToString(2));
		Assert.assertEquals("March", Util.convertMonthIntToString(3));
		Assert.assertEquals("April", Util.convertMonthIntToString(4));
		Assert.assertEquals("May", Util.convertMonthIntToString(5));
		Assert.assertEquals("June", Util.convertMonthIntToString(6));
		Assert.assertEquals("July", Util.convertMonthIntToString(7));
		Assert.assertEquals("August", Util.convertMonthIntToString(8));
		Assert.assertEquals("September", Util.convertMonthIntToString(9));
		Assert.assertEquals("October", Util.convertMonthIntToString(10));
		Assert.assertEquals("November", Util.convertMonthIntToString(11));
		Assert.assertEquals("December", Util.convertMonthIntToString(12));
		Assert.assertEquals("Octanuary IDK WHAT DID YOU ENTER", Util.convertMonthIntToString(13));
	}
}
