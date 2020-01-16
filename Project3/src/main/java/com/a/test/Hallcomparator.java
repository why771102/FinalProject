package com.a.test;

import java.util.Comparator;

import com.c.model.HallBean;

public class Hallcomparator implements Comparator {
//http://www.51gjie.com/java/647.html
	public int compare(Object o1, Object o2) {
		HallBean hb1 = (HallBean) o1;
		HallBean hb2 = (HallBean) o2;
		int a=hb1.getColNum()*hb1.getRowNum();
		int b=hb2.getColNum()*hb2.getRowNum();
		

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