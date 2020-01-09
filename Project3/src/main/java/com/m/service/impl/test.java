package com.m.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		String playStartTimeA = "2020-01-01";
		String playStartTimeB = "2020-01-09";
		LocalDate start = LocalDate.parse(playStartTimeA);
		LocalDate end = LocalDate.parse(playStartTimeB);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
		    totalDates.add(start);
		    start = start.plusDays(1);
		}
//		for(LocalDate date: totalDates) {
//			String a = date.toString();
//			System.out.println(a instanceof String);
//		}

	}

}
