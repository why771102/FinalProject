package com.m.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {

	 public static LocalDateTime convertToEntityAttribute(Timestamp ts) {
	    	if(ts!=null){
	    		   return ts.toLocalDateTime();
	    	}
	    	return null;
	    }
	 
		public static void compareValue(String x, String y) {
			if( x.equals(y) ) {
				System.out.println("x equals y");
			}else {
				System.out.println("no match");
			}	
		}

	
	public static void main(String[] args) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		LocalDateTime ldt = convertToEntityAttribute(ts);
		
		compareValue("哈囉123", "哈囉");
		
//		String playStartTimeA = "2020-01-01";
//		String playStartTimeB = "2020-01-09";
//		LocalDate start = LocalDate.parse(playStartTimeA);
//		LocalDate end = LocalDate.parse(playStartTimeB);
//		List<LocalDate> totalDates = new ArrayList<>();
//		while (!start.isAfter(end)) {
//		    totalDates.add(start);
//		    start = start.plusDays(1);
//		}
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String playStartTimeC = "2020-01-01";
		String playStartTimeD = "2020-01-01";
		
		 Date date= new Date();
		 long time = date.getTime();
//		     System.out.println("Time in Milliseconds: " + time);
		 
		 Timestamp ts1 = new Timestamp(time);
		 LocalDate ld = ts.toLocalDateTime().toLocalDate();
		 System.out.println("Current Time Stamp: " + ts1);
		 System.out.println("Current LocalDateFormat: " + ld);
		 
		 
//		LocalDateTime test1 = LocalDateTime.parse(playStartTimeC, formatter);
//		LocalDateTime test2 = LocalDateTime.parse(playStartTimeD, formatter);
		
		LocalDate sd = LocalDate.parse(playStartTimeC);
		LocalDate ed = LocalDate.parse(playStartTimeD);
//		LocalDate re = test2-test1;
//		System.out.println(sd + "&" + ed);
		
//		for(LocalDate date: totalDates) {
//			String a = date.toString();
//			System.out.println(a instanceof String);
//		}

//		String startDate = "2016 01 02";
//		String passedDate = "2016 02 29";

//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
//		LocalDate date1 = LocalDate.parse(startDate, formatter);
//		LocalDate date2 = LocalDate.parse(passedDate, formatter);
		
		//long example = ChronoUnit.DAYS.between(beforeDate, afterDate);
		//=>>> afterDate - beforeDate
		
		long elapsedDays = ChronoUnit.DAYS.between(sd, ed);
		if(elapsedDays>0) { 
			System.out.println(">0");
		}else if(elapsedDays == 0)
		System.out.println("=0");
		else {
			System.out.println("<0");
		}
		System.out.println(elapsedDays);
		
	}
	

	
}
