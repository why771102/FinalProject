package com.a.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;



public class TimeAPI2 {

	public static void main(String[] args) {
	/*參考網址:  https://magiclen.org/java-8-date-time-api/*/
		
	/*	Instant */
//		Instant類別用來定義一個瞬間的時間點，譬如說：「現在UTC的時間是西元2015年4月3日凌晨1點整。」
//		Instant只能夠表示UTC的時間，並沒有時區概念。 Z 表示此時間為UTC時區(格林威治時間)
//
		Instant instant_a = Instant.parse("2015-04-03T00:00:00Z"); //Z不可以省略 //T作為把日期與時間放在一起的接口
//		也可以使用Instant類別的ofEpochMilli或是ofEpochSecond方法來代入UTC的
//		「西元2015年4月3日凌晨1點整」與「西元1970年1月1日凌晨0點整」(Epoch Time)所差距的秒數，
//		單位分別為毫秒與秒。這個差距的數值通常為64位元的長整數(long)型態，
//		就是我們常說與常用的「時間戳記(Timestamp)」啦！
//
//		UTC的「西元2015年4月3日凌晨1點整」與「西元1970年1月1日凌晨0點整」
//		共相差了1428019200000毫秒，因此也可以寫成以下程式來產生Instant物件：
		Instant instant_A = Instant.ofEpochMilli(1428019200000L);
//		如果要取得目前的時間點(或時間戳記)，可以使用Instant類別的now方法，用法將在介紹建立LocalDate與LocalTime時提到。	
//	
		
	/*	Duration */
//		Duration類別用來定義一個時間區段，譬如說：「從甲地到乙地，開車開了20分鐘。」
//		這就是一個時間區段的描述。如果要用Duration類別產生出符合上述句子的物件，可以寫成程式如下：
//
		final Duration duration_a = Duration.parse("PT20M");
//		或是使用Duration類別提供的of、ofXXXX的方法，如下：
//
		final Duration duration_A = Duration.ofMinutes(20);	

		/*	Instant && Duration 加減*/	
	//兩個時間相加
	 Instant instant = Instant.parse("2015-04-03T00:00:00Z");
	 Duration duration = Duration.parse("PT148M"); //PT數字M代表分鐘
	 Duration duration_2 = Duration.ofMinutes(148);	//與上面意思相等
	 Instant newInstant = instant.plus(duration_2); //會再產生出新的「2015-04-03T00:20:00Z」之Instant物件
	 System.out.println(newInstant); //result : 2015-04-03T02:28:00Z
    //兩個時間相減	 
//	 也可以使用Duration的between來計算兩個Instant物件的時間差，如下：

	 Instant instant1 = Instant.parse("2015-04-03T00:00:00Z");
	 Instant instant2 = Instant.parse("2015-04-03T00:20:00Z");
	 Duration duration12 = Duration.between(instant1, instant2); //注意參數的順序！
	 System.out.println(duration12);
	 
	 //預設時區
	 final ZoneId zoneidDefault = ZoneId.systemDefault(); //系統預設時區
	 final ZoneId zoneidPlus8 = ZoneId.of("UTC+8"); //UTC時間+8
	 Instant nowInstant = instant.now();
	 final LocalDateTime nowLocalDateTime = LocalDateTime.ofInstant(nowInstant, zoneidPlus8);
	 System.out.println(nowLocalDateTime);
	 
	 
	}

}
