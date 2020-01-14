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
		System.out.println("colNum: " + colNum);
		System.out.println("rowNum: " + rowNum);
		for(int col = 1; col <= colNum; col++) {
			String seatStr = "";
			for(int row = 1 ; row <= rowNum; row++) {
				String seatIDstr = chars[col-1]+row;
				System.out.println("This is seatIDstr: " + seatIDstr);
				for(int seat = 0; seat < listSB.size(); seat++) {
					String seatID = listSB.get(seat).getSeatID();
					seatID = seatID.substring(1, seatID.length()-1);//後面竟然有空格?!
					System.out.println("This is seatID: " + seatID);
					System.out.println("seatIDstr.equals(seatID): " + seatIDstr.equals(seatID));
					if(seatIDstr.equals(seatID)) {
						Integer seatStatus = listSB.get(seat).getSeatStatus();
						if(seatStatus == 1) { //不可出售
							seatStr += "o";
							listSB.remove(seat);
							break;
						}else {
							Integer typeofSeat = listSB.get(seat).getTypeOfSeat();
							if(typeofSeat == 0) { // 正常座位
								seatStr += "f";
								listSB.remove(seat);
								break;
							}else if(typeofSeat == 1){ //輪椅座
								seatStr += "e";
								listSB.remove(seat);
								break;
							}
						}
					}else {
						seatStr += "_"; //走道 (當坐位在DB不存在的時候)
						break;
					}
				}
				seats[col-1] = seatStr;
				System.out.println(seatStr);
			}
		}
		return seats;
	}

}
