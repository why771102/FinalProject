package com.c.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Testing {

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		LocalDate currentDatePlusAWeek = currentDate.plusDays(7);
		String datestr = currentDatePlusAWeek.toString();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = new Date();
			Date date = formatter.parse(datestr);
			System.out.println(currentDate);
			System.out.println(currentDatePlusAWeek);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

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
