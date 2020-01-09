package com.c.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class Testing {

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		LocalDate currentDatePlusAWeek = currentDate.plusDays(7);
		System.out.println(currentDate);
		System.out.println(currentDatePlusAWeek);

//		Date date= new Date();
//		 
//		 long time = date.getTime();
//		     System.out.println("Time in Milliseconds: " + time);
//		 
//		 Timestamp ts = new Timestamp(time);
//		 String x = ts.toString();
//		 x = x.substring(0, 10);
//		 System.out.println("Current Time Stamp: " + ts);
//		 System.out.println(x);
	}

}
