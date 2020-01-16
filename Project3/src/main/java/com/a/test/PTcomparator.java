package com.a.test;

import java.util.Comparator;

import com.c.model.HallBean;

public class PTcomparator implements Comparator {
//http://www.51gjie.com/java/647.html
	public int compare(Object o1, Object o2) {
		ShowtimeBean stb1 = (ShowtimeBean) o1;
		ShowtimeBean stb2 = (ShowtimeBean) o2;
		double a=stb1.getPrice_time();
		double b=stb2.getPrice_time();
		

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