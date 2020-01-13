package com.a.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.test.ShowtimeBean;
import com.p.model.HallOrderBean;

public interface TimeDao {
//String to LocalDate
	
	public LocalDate  StringToLocalDate(String Date);
	public LocalDateTime  StringToLocalDateTime(String DateTime);
	
	public String  DateToString(LocalDate Date);
	
	public int daysDiff(String Date1,String Date2);
	public int TimeDiff(String Time1,String Time2);
	
	

}
