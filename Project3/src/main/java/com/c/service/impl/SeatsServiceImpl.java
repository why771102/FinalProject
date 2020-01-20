package com.c.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.dao.SeatsDao;
import com.c.model.HallBean;
import com.c.model.SeatStatusBean;
import com.c.model.SeatsBean;
import com.c.model.TypeOfSeatBean;
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
	public void updateSeatStatus(Integer status, String seatID, String flag) {
		dao.updateSeatStatus(status, seatID, flag);

	}

	@Transactional
	@Override
	public List<SeatsBean> getAllSeatsUsingHallID(String hallID) {
		return dao.getAllSeatsUsingHallID(hallID);
	}
	

	//輸出["AA01"....]格式
	@Override
	public String[] stringToStringArray(String seats, String hallID) {
		Gson gson = new Gson();
		String[] seatsArray = gson.fromJson(seats, String[].class);
		for(int seat = 0; seat < seatsArray.length; seat++) {
			String seatID;
			String row = seatsArray[seat].substring(0, 1);
			Integer seatNo =  Integer.parseInt(seatsArray[seat].substring(2, seatsArray[seat].length()));
			if(seatNo < 10) {
				seatID = hallID+row+0+seatNo;
			}else {
				seatID = hallID+row+seatNo;
			}
			seatsArray[seat] = seatID;
		}
		return seatsArray;	
	}
	
	
	@Transactional
	@Override
	public void saveSeats(String seats, String hallID, Integer typeOfSeat) {
		String[] seatsArray = stringToStringArray(seats, hallID);
		for(int seat = 0; seat < seatsArray.length; seat++) {
			String seatID = seatsArray[seat];
			String row = seatsArray[seat].substring(1, 2);
			System.out.println(row);
			Integer seatNo =  Integer.parseInt(seatsArray[seat].substring(2, seatsArray[seat].length()));
			
			Integer seatStatus = 0; //currently all available to be sold
			System.out.println("seatID: " + seatID + " hallID: " + hallID);
			SeatsBean sb = new SeatsBean(seatID,hallID, row, seatNo, typeOfSeat, seatStatus);
			this.insertSeats(sb);
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
				String seatIDstr;
				if(row < 10) {
					seatIDstr = chars[col-1]+0+row;
				}else {
					seatIDstr = chars[col-1]+row;
				}
				System.out.println("This is seatIDstr: " + seatIDstr);
				for(int seat = 0; seat < listSB.size(); seat++) {
					String seatID = listSB.get(seat).getSeatID();
					System.out.println(seatID);
					seatID = seatID.substring(1, seatID.length()).trim();//後面竟然有空格?!
					System.out.println("This is seatID: " + seatID);
					System.out.println("seatIDstr.equals(seatID): " + seatIDstr.equals(seatID));
					if(seatIDstr.equals(seatID)) {
						Integer seatStatus = listSB.get(seat).getSeatStatusBean().getSeatStatusID();
						if(seatStatus == 1) { //不可出售
							seatStr += "o";
							listSB.remove(seat);
							break;
						}else {
							Integer typeofSeat = listSB.get(seat).getTypeOfSeatBean().getTypeofSeatID();
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

	@Override
	public SeatsBean getSeat(String seatID) {
		return dao.getSeat(seatID);
	}

	@Override
	public TypeOfSeatBean getTypeOfSeatById(Integer typeOfSeat) {
		// TODO Auto-generated method stub
		return dao.getTypeOfSeatById(typeOfSeat);
	}

	@Override
	public SeatStatusBean getSeatStatusById(Integer seatStatus) {
		// TODO Auto-generated method stub
		return dao.getSeatStatusById(seatStatus);
	}

}
