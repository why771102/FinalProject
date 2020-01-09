package com.a.test;

import java.util.Comparator;

public class Mycomparator implements Comparator {
//http://www.51gjie.com/java/647.html
	public int compare(Object o1, Object o2) {
		String[] p1 = (String[]) o1;
		String[] p2 = (String[]) o2;
		double a = Double.parseDouble(p1[2]);
		double b = Double.parseDouble(p2[2]);
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