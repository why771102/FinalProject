package com.a.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.HallBean;

public class runIDComparator implements Comparator {
//http://www.51gjie.com/java/647.html
	public int compare(Object o1, Object o2) {
		RunningBean rb1 = (RunningBean) o1;
		RunningBean rb2 = (RunningBean) o2;
	
	    int a = rb1.getRunID();
		int b = rb2.getRunID();
		
//		Timestamp aa=.valueOf(dateTime);
//		Timestamp bb=Timestamp.valueOf(dateTime2);
		//2038year unit時間會掛掉喔ＸＤＤＤ
//		int a = Integer.parseInt(aa.toString());
//		int b = Integer.parseInt(bb.toString());
//		
		
	
//		double a=sthb1.getPlayStartTime();
//		double b=sthb2.getPrice_time();
		

//		System.out.println("-------");
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println("-------");
		if (a < b) {
		
			return 1;
		} else if(a == b){
		
			return 0;
		}else {
		
			return -1;
		}
			
	}

}