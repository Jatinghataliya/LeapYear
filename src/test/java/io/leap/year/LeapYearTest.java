package io.leap.year;

import java.util.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

@Tag("LeapYear")
@DisplayName("Lear Year")
public class LeapYearTest {

	private static Logger logger = LoggerFactory.getLogger(LeapYearTest.class);
	
	private static final String ERROR_MESSAGE = "Please provide year in format of YYYY";
	
	private LeapYears leapYears;
	
	@BeforeAll
	static void start() {
		logger.info(() -> "========================================");
		logger.info(() -> "Start Test Cases");
		logger.info(() -> "========================================");
	}
	
	@BeforeEach
	void init() {
		leapYears = new LeapYears();
	}
	
	@AfterAll
	static void end() {
		logger.info(() -> "========================================");
		logger.info(() -> "End Test Cases");
		logger.info(() -> "========================================");
	}
	
	@Test
	@Order(1)
	@DisplayName("Wrong Data")
	void wrongyear() {
		Assertions.assertThrows(NumberFormatException.class, () -> leapYears.isLeapYear("two zero zero zero "), ERROR_MESSAGE);
	}
	
	@Test
	@Order(4)
	@DisplayName("Right Year")
	@Disabled
	void rightYear() {
		Assertions.assertThrows(NumberFormatException.class, () -> leapYears.isLeapYear("2000"), ERROR_MESSAGE);
	}
	
	@Test
	@Order(2)
	@DisplayName("Not Leap Year")
	void notLeapYear() {
		try {
			Assertions.assertNotEquals(true, leapYears.isLeapYear("1979"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Leap Year")
	@Order(5)
	void leapYear() {
		try {
			Assertions.assertEquals(true, leapYears.isLeapYear("2000"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	@DisplayName("Is Leap Year")
	@Order(6)
	void isLeapYear(){
		Assertions.assertEquals(true, leapYears.isLeapYear(2005));
	}
	
	@Test
	@Order(3)
	@DisplayName("Current Year")
	void currentYear() {
		Assertions.assertEquals(true, leapYears.isLeapYear(new Date()));
	}
}