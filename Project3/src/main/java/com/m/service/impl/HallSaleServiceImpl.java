package com.m.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Override
	public List<HallSaleBean> getHSBOutput(List<HallOrderBean> hobList) {
		List<HallSaleBean> hsbList = new ArrayList<>();
		
		for (HallOrderBean hob : hobList) {
//			if(hob.getHallID() == hob.getHb().getHallID()) {
				HallSaleBean hsb = new HallSaleBean(hob.getHallID(), hob.getHb().getPrice(), 
						hob.getOrderHours(), hob.getHallSubtotal());
				hsbList.add(hsb);
//			}else {
//				System.out.println("產生List<HallSaleBean>錯誤");
//			}
		}
		return hsbList;
	}
}
