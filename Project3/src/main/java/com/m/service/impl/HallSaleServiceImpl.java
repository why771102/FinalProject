package com.m.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m.dao.HallSaleDao;
import com.m.model.HallSaleBean;
import com.m.service.HallSaleService;
import com.p.model.HallOrderBean;

@Service
public class HallSaleServiceImpl implements HallSaleService {

	HallSaleDao dao;
	HallSaleService service;

	@Autowired
	public void setDao(HallSaleDao dao) {
		this.dao = dao;
	}

	@Autowired
	public void setService(HallSaleService service) {
		this.service = service;
	}

	@Override
	public List<HallOrderBean> getHallOrder() {
		return dao.getHallOrder();
	}
	
	@Transactional
	@Override
	public List<HallOrderBean> getHallHrSubtotal(String sDate, String eDate) {
		List<HallOrderBean> getHobList = dao.getHallOrder();
		List<HallOrderBean> hobList = new ArrayList<>();

		LocalDate Sd = LocalDate.parse(sDate);
		LocalDate Ed = LocalDate.parse(eDate);

		for (HallOrderBean hob : getHobList) {
			LocalDate orderDate = LocalDateTime.parse(hob.getOrderDate()).toLocalDate();
			long SdOdDays = ChronoUnit.DAYS.between(Sd, orderDate);
			long OdEdDays = ChronoUnit.DAYS.between(orderDate, Ed);

			if (SdOdDays >= 0 && OdEdDays <= 0) {
				hobList.add(hob);
			} else {
				System.out.println("不符合所需輸入查詢區間與hob日期比較");
			}
		}
		return hobList;
	}

//	@Override
//	public List<HallBean> getHallPrice(List<HallOrderBean> hobList) {
//		return dao.getHallPrice(hobList);
//	}

	@Transactional
	@Override
	public List<HallSaleBean> getHallSaleLists(List<HallOrderBean> hobList) {
		List<HallSaleBean> hsbList = new ArrayList<>();

		for (HallOrderBean hob : hobList) {
//			if(hob.getHallID() == hob.getHb().getHallID()) {
			HallSaleBean hsb = new HallSaleBean(hob.getHallID(), hob.getHb().getPrice(), hob.getOrderHours(),
					hob.getHallSubtotal());
			hsbList.add(hsb);
//			}else {
//				System.out.println("產生List<HallSaleBean>錯誤");
//			}
		}
		return hsbList;
	}
	
	@Transactional
	@Override
	public List<HallSaleBean> getHallSaleOutput(List<HallSaleBean> hsbList) {
		List<HallSaleBean> hsbListToPage = new ArrayList<>();
		String[] hallName = "ABCDEFGH".split("");
		
		for (int x = 0; x < hallName.length; x++) {
			String savehallName = null;
			Integer hallSubtotal = 0;
			Integer orderHours = 0;
			Integer hallPrice = 0;
			for (HallSaleBean hsb: hsbList) {
				//if HallID相等就存
				if(hallName[x].equals(hsb.getHallID())) {
				savehallName = hallName[x];
				hallSubtotal = hallSubtotal + hsb.getHallSubtotal();
				orderHours = orderHours + hsb.getOrderHours();
				hallPrice = hsb.getPrice();
				hsbList.remove(hsb);
				}else {
					System.out.println("比對時,DB廳名&hsb廳名不同");
				}
			}
			HallSaleBean hsbTemp =  new HallSaleBean(savehallName, hallPrice, orderHours, hallSubtotal);
			hsbListToPage.add(hsbTemp);
		}
		return hsbListToPage;
	}

}
