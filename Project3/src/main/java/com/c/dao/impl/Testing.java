package com.c.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
//		LocalDate currentDate = LocalDate.now();
//		LocalDate currentDatePlusAWeek = currentDate.plusDays(7);
//		String datestr = currentDatePlusAWeek.toString();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			Date d = new Date();
//			Date date = formatter.parse(datestr);
//			System.out.println(currentDate);
//			System.out.println(currentDatePlusAWeek);
//			System.out.println(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
		
//		String [] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
//		for(int i = 0 ; i < chars.length; i++) {
//			String c = chars[i].toString();
//			System.out.println(c);
//		}
//		for(int i = 0; i < 20; i++) {
//			Integer noOfOrdersEachDay = (int) (Math.random()*20)+50;
//			System.out.println("noOfOrdersPerDay: " + noOfOrdersEachDay);	
//		}
		
//		String A = "";
//		A += "b";
//		System.out.println(A);
//		String[] str = new String[5];
//		String abc = "abc";
//		
//		System.out.println(LocalDateTime.now().toString());
//		LocalDateTime starttime = LocalDateTime.now();
//		System.out.println(starttime);
//		LocalDate endTime = starttime.toLocalDate();
//		String et = (endTime.plusDays(7).toString())+" "+"00:00:00"; 
//		System.out.println(et);
//		String [] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
//		List<String> hallID = Arrays.asList(chars);
	
		List<String> hallID = getHallIDs();
		for(int x = 0; x < hallID.size(); x++) {
			System.out.println(hallID.get(x));
		}
	
	}
	private static List<String> getHallIDs() {
        return Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
	}

}
