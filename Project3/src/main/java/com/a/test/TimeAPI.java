package com.a.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;



public class TimeAPI {

	public static void main(String[] args) {
	/*參考網址:  https://magiclen.org/java-8-date-time-api/*/
		
	/*LocalDateTime	*/	
	 //有閏年與大小月區分
	 
	 
	//直接使用LocalDateTime類別來取得   目前系統的日期與時間
	 final LocalDateTime currentPoint = LocalDateTime.now(); 
	 System.out.println(currentPoint);
	 
	 //如果要設定時區
	 //UTC時間
	 final LocalDateTime currentPointUTC = LocalDateTime.now(Clock.systemUTC());
	 //同LocalDateTime.now();
	 final LocalDateTime currentPointDefault = LocalDateTime.now(Clock.systemDefaultZone());
	 //設定為+8的時區
	 final LocalDateTime currentPointPlus8 = LocalDateTime.now(Clock.system(ZoneId.of("+8")));
	
	 //用此格式 ofPattern("yyyy/MM/dd HH:mm:ss") 將字串轉成 LocalDateTime
	 final LocalDateTime qingmingParsed = LocalDateTime.parse("2015/04/05 12:30:30", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
	
	 System.out.println(qingmingParsed);
	 
	 /*LocalDateTime以系統時間為準  取現在時間方法*/
	 /*
	  * final LocalDateTime currentDateTime = LocalDateTime.now();
        final int year = currentDateTime.getYear();  
        final int month = currentDateTime.getMonthValue();
        final Month m = currentDateTime.getMonth();
        final int day = currentDateTime.getDayOfMonth();
        final DayOfWeek w = currentDateTime.getDayOfWeek();
        final int hour = currentDateTime.getHour();
        final int minute = currentDateTime.getMinute();
        final int second = currentDateTime.getSecond();
	  * 
	  */
	 
	 /*LocalDateTime 加減時間*/
	 //   加減時間
	 LocalDate currentDate = LocalDate.now();
	 final LocalDate thisMonth = currentDate.withDayOfMonth(1); //將日期指定為該月1號。注意這裡currentDate並沒有被改變！
	 final LocalDateTime nextWeekDateTime = LocalDateTime.now().plusWeeks(1);
	 final LocalDateTime next7DaysDateTime = LocalDateTime.now().plusDays(7);
	 final LocalDateTime nextTime = LocalDateTime.now().plusHours(2);
	 final LocalDateTime plusTime = LocalDateTime.now().plusMinutes(180);
	 final LocalDateTime betweenTime = LocalDateTime.now().minusMinutes(144);
	 
	 //日期與日期相加減(單位日子）

		     LocalDate startDate = LocalDate.of(2003, Month.MAY, 9);
		      System.out.println("开始时间：" + startDate);
		  
		      LocalDate endDate = LocalDate.of(2015, Month.JANUARY, 26);
		      System.out.println("结束时间：" + endDate);
		 
	     long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
		     System.out.println("两个时间之间的天数差为：" + daysDiff);
		     
	 //日期與日期相加減   （單位 年月日） 
		     LocalDate today2 = LocalDate.now();
		        System.out.println("Today : " + today2);
		        LocalDate birthDate = LocalDate.of(1993, Month.OCTOBER, 19);
		        System.out.println("BirthDate : " + birthDate);

		        Period p = Period.between(birthDate, today2);
		        System.out.println(p);
		        System.out.printf("年龄 : %d 年 %d 月 %d 日\n", p.getYears(), p.getMonths(), p.getDays());
	 
    //時間相減
		        Duration duration = Duration.between(LocalDateTime.now(),  plusTime);
		        long minust1 =duration.toMinutes();
		        System.out.println(duration.toMinutes());
		        
    //時間相減2        
		        LocalTime lt1 = LocalTime.parse("01:30:00");
		        LocalTime lt2 = LocalTime.parse("02:00:00");
		        LocalTime lt3 = lt1.plusHours(lt2.getHour()).plusMinutes(lt2.getMinute()).plusSeconds(lt2.getSecond());
		        LocalDateTime ldt = LocalDateTime.of(LocalDate.now(), lt3);System.out.println("lt3="+DateTimeFormatter.ofPattern("HH:mm:ss").format(ldt));
		        //lt3=03:30:00

		        		
		        
		        
	
	//formate LocalDateTime
	//減少時間精確度(Truncation)
	 final LocalDateTime secondsDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS); 
	 String a = currentDate.format( DateTimeFormatter.BASIC_ISO_DATE);//20200104
	 String b =LocalDateTime.now().format( DateTimeFormatter.ofPattern("yyyy:MM:DD HH:MM:SS"));//2020:01:13 11:01:78
	 System.out.println("String B:"+b);
	 
	 //取得目前這個月的最後一天
	 final LocalDateTime lastDayOfMonthDateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
	 System.out.println("----------------");
	 System.out.println(lastDayOfMonthDateTime);
	 // 取得距離目前最近的星期三
	 final LocalDateTime previousWednesdayDateTime = LocalDateTime.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
	 final LocalDateTime nextWednesdayDateTime = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
	
	 
	 /*LocalDateTime to LocalDate*/
	 LocalDateTime LDT =LocalDateTime.now(Clock.system(ZoneId.of("+8")));
	 LocalDate LD   = LDT.toLocalDate();
	 LocalDateTime    LDTNew  = LD.atTime(LocalTime.now(Clock.systemUTC()));
	 System.out.println("test=======");  
	 System.out.println(LDT+"|||"+LD+"|||"+LDTNew);  
	           
	/*LocalDateTime to Localtime*/
	LocalDateTime LDT2 =LocalDateTime.now(Clock.systemUTC());
	LocalTime LT   = LDT.toLocalTime();
	LocalDateTime  LDT2New  = LT.atDate(LocalDate.now(Clock.systemUTC()));
	 System.out.println("test=======");  
	 System.out.println(LDT2+"|||"+LT+"|||"+LDT2New);  
	           
	/*LocalDateTime to String*/
//	 定義樣式
	 DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	 LocalDateTime time = LocalDateTime.now();
	 String localTime = df.format(time);
	 LocalDateTime ldt1 = LocalDateTime.parse(localTime,df);
	 LocalDate ld = LocalDate.parse(localTime,df);
	 System.out.println("test=======");  
	 System.out.println(localTime);
	 System.out.println("LocalDateTime转成String类型的时间："+localTime);
	 System.out.println("String类型的时间转成LocalDateTime："+ldt1);
	 System.out.println("String类型的时间转成LocalDate："+ld);
     
    /*LocalDate to String*/
	   String str2 = "2017-11-21";
       DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");     
       LocalDate date2 = LocalDate.parse(str2, fmt);
//       LocalDateTime time2 = LocalDateTime.parse(str2, fmt);
       System.out.println("String parse localDate:"+date2);
//       System.out.println("time2:"+time2);
	 
	 
	 
	 
	 
	 /*LocalDateTime 與 ＳＱＬ 互轉 */
/*	 
	 //  LocalDate to Timestamp
     LocalDate now = LocalDate.now();
     Timestamp timestamp = Timestamp.valueOf(now.atStartOfDay());
     Timestamp timestamp2 =Timestamp.valueOf(LocalDateTime.now());
     System.out.println("now:"+now);        // 2019-06-14
     System.out.println("time:"+timestamp2);  // 2020-01-13 11:50:05.7509403

     //  Timestamp to LocalDate
     LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
     System.out.println(localDate);  // 2019-06-14
 */ 
     
	 
//		string && java.util.Date 互轉
     
     DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
     String str = "2016-12-11 17:17:10";   // 时间字符串
     Date date = null;
     try{
     date = format.parse(str);
     System.out.println("date:"+date);
     }catch(Exception e){
     e.printStackTrace();
     }
     System.out.println("test=======");  
     String today = (LocalDate.now().plusWeeks(1).format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"00:00:00"; 
     System.out.println(today);
     LocalDateTime createTime = LocalDateTime.parse("2015/04/05 12:30:30", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
     System.out.println("test=======");
     
     /*java.util.Date 與 java.sql.Date 互轉*/
  // util.date转换成sql.date
     java.util.Date utilDate = new java.util.Date(); //获取当前时间
     System.out.println("util:"+utilDate);
     java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
     System.out.println("sql:"+sqlDate);

     // sql.date转换成util.date
     java.sql.Date sqlDate1 = new java.sql.Date(new java.util.Date().getTime());
     System.out.println("sql1:"+sqlDate1);
     java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
     System.out.println("util1:"+utilDate1);
  
	 
     System.out.println("====-------");
     System.out.println(LocalDate.now().plusDays(30));  
     String create2 = ((LocalDate.now().plusDays(30)).toString()+" "+"00:00:00"); 
     String create3 = ((LocalDateTime.now().plusDays(30)).toString()); 
     LocalDate today1 = LocalDate.now();
	  LocalTime time1 = LocalTime.now();
	  String dateTime = today1.toString()+" "+time1.toString();
	 LocalDateTime runDate2=LocalDate.now().plusDays(1).atTime(12, 0);
	  LocalDateTime runDate = (LocalDateTime.now().plusDays(1)).truncatedTo(ChronoUnit.SECONDS);
	     LocalDateTime runtime=runDate2.plusMinutes(102);
	  System.out.println( runDate2 +"   "+runtime);
	}
	int a=1;
	int b=2;
	int c=3;
	List<Integer> list2 = new ArrayList<>(); 
	


}
