package com.c.dao;

import java.util.List;

import com.c.model.SeatsBean;

public interface SeatsDao {
	
	public List<SeatsBean> createSeatingTable();
	
	public void insertSeats(List<SeatsBean> list);
	
	public void insertNumberofSeats();
	
	

}
