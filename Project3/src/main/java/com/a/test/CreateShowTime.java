package com.a.test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

public class CreateShowTime {

	public static void main(String[] args) {


		String[] movie1 = { "a", "180", "28" };
		String[] movie2 = { "b", "128", "35" };
		String[] movie3 = { "c", "152", "20" };
		String[] movie4 = { "d", "93", "43" };

		List<String[]> list_A = new ArrayList<>();
		List<String[]> list_B = new ArrayList<>();
		List<String[]> list_R = new ArrayList<>();
		list_R.add(movie1);
		list_R.add(movie2);
		list_R.add(movie3);
		list_R.add(movie4);
		System.out.println(list_R.get(0)[0]); // a

		for (int i = 0; i < list_R.size(); i++) {
			System.out.println(list_R.get(i)[2]);

		}
		System.out.println("--------");
		int A = 17 * 60;// 大廳
		int B = 17 * 60;// 小廳
		int R = 10;
		// 根據p/t值 排列順序
		Comparator comp = new Mycomparator();
		Collections.sort(list_R, comp);
		for (int i = 0; i < list_R.size(); i++) {
			System.out.println(list_R.get(i)[2]);
		}
		// 排進Ａ聽
		while (A > 0 && B > 0) {
			if (A > 0) {
				if (A > (Integer.parseInt(list_R.get(0)[1]))) {
					list_A.add(list_R.get(0));
					A = A - (Integer.parseInt(list_R.get(0)[1])) - R;
					double r = Double.parseDouble(list_R.get(0)[2]) * 0.8;
					list_R.get(0)[2] = String.valueOf(r);
					System.out.println("A剩幾分鐘:" + A);
					Collections.sort(list_R, comp);
				} else {
					// 排進B聽
					if (B > (Integer.parseInt(list_R.get(0)[1]))) {
						list_B.add(list_R.get(0));
						B = B - (Integer.parseInt(list_R.get(0)[1])) - R;
						double r = Double.parseDouble(list_R.get(0)[2]) * 0.8;
						list_R.get(0)[2] = String.valueOf(r);
						System.out.println("B剩幾分鐘:" + B);
						Collections.sort(list_R, comp);
					} else {
						break;
					}
				}
			}
		}
		LocalDateTime Datetime = LocalDateTime.parse("2015/04/05 12:00:00", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		LocalTime time=Datetime.toLocalTime();
		LocalTime time2=Datetime.toLocalTime();
		System.out.println("A廳");
//		time=time.minusMinutes(Integer.parseInt(list_A.get(list_A.size()-1)[1]));
//		time2=time2.minusMinutes(B);
		for (int i = 0; i < list_A.size(); i++) {
			System.out.println(list_A.get(i)[0]);
			
			System.out.println("time:"+time);
			
			System.out.println("-------");
			time =time.plusMinutes(Integer.parseInt(list_A.get(i)[1])+R);
			
			System.out.println(time);
			
			
			System.out.println("-------");
		}//d(93)b(128)d(93)b(128)a(180)d(93)a(180)
		 //0    1     2    3     4     5    6
		//換順序 

	
		//bdcbadc
		System.out.println("B廳");
		for (int i = 0; i < list_B.size(); i++) {
			System.out.println(list_B.get(i)[0]);

//			System.out.println("time:"+time2);
//			System.out.println("-------");
//			time2 =time2.plusMinutes(Integer.parseInt(list_B.get(i)[1])+R);
//			System.out.println(time2);
//			
//			
//			System.out.println("-------");
		}

	}

}
