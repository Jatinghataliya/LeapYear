package io.leap.year;

import java.util.Calendar;
import java.util.Date;

public class LeapYears {

	private boolean checkYear(int year) {
		
		boolean isLeapYear = false;
		
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					isLeapYear = true;
				} else {
					isLeapYear = false;
				}
			} else {
				isLeapYear = true;
			}
		} else {
			isLeapYear = false;
		}
		
		return isLeapYear;
		
	}
	
	public boolean isLeapYear(int year) {
		return checkYear(year);
	}
	
	public boolean isLeapYear(String year) throws Exception {
		try {
			return checkYear(Integer.parseInt(year));
		} catch (Exception e) {
			throw new NumberFormatException("Please provide year in format of YYYY");
		}
	}
	
	public boolean isLeapYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return checkYear(year);
	}
}
