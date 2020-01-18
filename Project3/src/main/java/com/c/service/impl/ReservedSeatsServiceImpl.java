package com.c.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.model.ShowTimeHistoryBean;
import com.c.dao.NumberOfSeatsDao;
import com.c.dao.ReservedSeatsDao;
import com.c.model.ReservedSeatsBean;
import com.c.model.SeatsBean;
import com.c.service.ReservedSeatsService;

@Service
public class ReservedSeatsServiceImpl implements ReservedSeatsService {

	ReservedSeatsDao dao;
	NumberOfSeatsDao nosdao;
	
	@Autowired
	public void setDao(ReservedSeatsDao dao, NumberOfSeatsDao nosdao) {
		this.dao = dao;
		this.nosdao = nosdao;
	}
	
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> insertSeats() {
		return dao.insertSeats();
		
	}

	@Transactional
	@Override
	public void reserveSeat(Integer showTimeID, String seatID) {
		dao.reserveSeat(showTimeID, seatID);
		
	}

	@Transactional
	@Override
	public SeatsBean getSeatsById(String seatID) {
		return dao.getSeatsById(seatID);
	}

	@Transactional
	@Override
	public ShowTimeHistoryBean getShowTimeById(Integer showTimeID) {	
		return dao.getShowTimeById(showTimeID);
	}

	@Transactional
	@Override
	public void cancelReservedSeat(Integer showTimeID, String seatID) {
		dao.cancelReservedSeat(showTimeID, seatID);
	}

	@Transactional
	@Override
	public List<ReservedSeatsBean> getAllSeats(Integer showTimeID) {
		return dao.getAllSeats(showTimeID);
	}

	@Transactional
	@Override
	public String[] showSeatChart(List<ReservedSeatsBean> listRSB, Integer colNum, Integer rowNum, String hallID) {
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
				for(int seat = 0; seat < listRSB.size(); seat++) {
					String seatID = listRSB.get(seat).getSeatsBean().getSeatID();
					System.out.println(seatID);
					seatID = seatID.substring(1, seatID.length()).trim();//後面竟然有空格?!
					System.out.println("This is seatID: " + seatID);
					System.out.println("seatIDstr.equals(seatID): " + seatIDstr.equals(seatID));
					if(seatIDstr.equals(seatID)) {
						Integer seatStatus = listRSB.get(seat).getReservationStatusBean().getReservationStatusID();
						if(seatStatus == 1) { //不可出售
							seatStr += "u";
							listRSB.remove(seat);
							break;
						}else {
							
							Integer typeofSeat = listRSB.get(seat).getSeatsBean().getTypeOfSeatBean().getTypeofSeatID();
							if(typeofSeat == 0) { // 正常座位
								seatStr += "f";
								listRSB.remove(seat);
								break;
							}else if(typeofSeat == 1){ //輪椅座
								seatStr += "e";
								listRSB.remove(seat);
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
	
	


