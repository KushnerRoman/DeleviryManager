package com.utils.ServiceUtils;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;



public interface DateAndTimeUtils { 
	
	
	public static  LocalTime getCurrentTime() {
		
		return LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		
	}
	
	public static  LocalDate getCurrentDate() {
		return LocalDate.now();
	}
	
	public static  boolean checkFiveMinutesTimeOutOrder(Time orderTime) {
		
		LocalTime timeCheck=orderTime.toLocalTime();
		LocalTime timePlusFive=timeCheck.plusMinutes(5);
		if(timePlusFive.isBefore(getCurrentTime()))return true;
		
		return false;
	}

}
