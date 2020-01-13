package com.c.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.dao.SeatsDao;
import com.c.model.HallBean;
import com.c.model.SeatsBean;
import com.c.service.SeatsService;
import com.google.gson.Gson;

@Service
public class SeatsServiceImpl implements SeatsService {

	SeatsDao dao;

	@Autowired
	public void setDao(SeatsDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public void insertSeats(SeatsBean sb) {
		dao.insertSeats(sb);

	}

	@Transactional
	@Override
	public HallBean getHallById(String hallID) {
		return dao.getHallById(hallID);
	}

	@Transactional
	@Override
	public void updateSeatStatus(Integer status, String seatID) {
		dao.updateSeatStatus(status, seatID);

	}

	@Transactional
	@Override
	public List<SeatsBean> getAllSeats(String hallID) {
		return dao.getAllSeats(hallID);
	}

	@Transactional
	@Override
	public void saveSeats(String seats, String hallID) {
		
		Gson gson = new Gson();

		String[] array = gson.fromJson(seats, String[].class);
		for(int seat = 0; seat < array.length; seat++) {
			String row = array[seat].substring(0, 1);
			Integer seatNo =  Integer.parseInt(array[seat].substring(array[seat].length()-1, array[seat].length()));
			String seatID = hallID+row+seatNo;
			Integer typeOfSeat = 0; //currently all normal seats
			Integer seatStatus = 0; //currently all available to be sold
			SeatsBean sb = new SeatsBean(seatID, row, seatNo, typeOfSeat, seatStatus, hallID);
			this.insertSeats(sb);
			System.out.println(sb);
		}
		
	}

	//將讀到的seats轉成seatmap格式
	@Transactional
	@Override
	public String[] showSeatChart(List<SeatsBean> listSB, Integer colNum, Integer rowNum) {
		String[] seats = new String[colNum];
		String [] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		for(int col = 0; col < colNum; col++) {
			for(int row = 0 ; row < rowNum; row++) {
				String seatStr = "";
				String seatIDstr = chars[col]+row;
				for(int seat = 0; seat < listSB.size(); seat++) {
					String seatID = listSB.get(seat).getSeatID();
					seatID = seatID.substring(1, seatID.length());
					if(seatIDstr.equalsIgnoreCase(seatID)) {
						Integer seatStatus = listSB.get(seat).getSeatStatus();
						if(seatStatus == 1) { //不可出售
							seatStr += "o";
							listSB.remove(seat);
						}else {
							Integer typeofSeat = listSB.get(seat).getTypeOfSeat();
							if(typeofSeat == 0) { // 正常座位
								seatStr += "f";
								listSB.remove(seat);
							}else if(typeofSeat == 1){ //輪椅座
								seatStr += "e";
								listSB.remove(seat);
							}
						}
					}else {
						seatStr += "_"; //走道 (當坐位在DB不存在的時候)
					}
					seats[col] = seatStr;
				}
			}
		}
		return seats;
	}

}
