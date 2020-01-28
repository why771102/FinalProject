package com.m.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(hob.getOrderDate(), formatter).toLocalDate();
			long SdOdDays = ChronoUnit.DAYS.between(Sd, orderDate);
			long EdOdDays = ChronoUnit.DAYS.between(Ed, orderDate);
			System.out.println("step1: getHallHrSubtotal()");
			System.out.println("sDate=>" + Sd);
			System.out.println("eDate=>" + Ed);
			System.out.println("orderDate=>" + orderDate);
			System.out.println("SdOdDays=>" + SdOdDays);
			System.out.println("EdOdDays=>" + EdOdDays);
			if (SdOdDays >= 0 && EdOdDays <= 0) {
				hobList.add(hob);
				System.out.println("符合 輸入查詢區間與hob日期比較");
				System.out.println("hob=>" + hobList.size());
			} else {
				System.out.println("不符合 輸入查詢區間與hob日期比較");
			}
		}
		System.out.println("step1: getHallHrSubtotal(), hobList=>" + Arrays.toString(hobList.toArray()));
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
			HallSaleBean hsb = new HallSaleBean(hob.getHb().getHallID(), hob.getHb().getPrice(), hob.getOrderHours(),
					hob.getHallSubtotal());
			hsbList.add(hsb);
//			}else {
//				System.out.println("產生List<HallSaleBean>錯誤");
//			}
		}
		System.out.println("step2: getHallSaleLists(), hsbList=>" + hsbList.size());
		return hsbList;
	}

	@Transactional
	@Override
	public List<HallSaleBean> getHallSaleOutput(List<HallSaleBean> hsbList) {
		List<HallSaleBean> hsbListToPage = new ArrayList<>();
		String[] hallName = "ABCDEFGH".split("");

		for (int x = 0; x < hallName.length; x++) {
			String savehallName = hallName[x];
			Integer hallSubtotal = 0;
			Integer orderHours = 0;
			Integer hallPrice = 0;
			HallSaleBean hsbTemp = new HallSaleBean();

			System.out.println("aaaa: " + hsbList.size());
			for (HallSaleBean hsb : hsbList) {
				// if HallID相等就存
				System.out.println("hallName[x]=>" + hallName[x]);
				System.out.println("hsb.getHallID()=>" + hsb.getHallID());

				if (hallName[x].equals(hsb.getHallID())) {
					System.out.println("123~~~");
					System.out.println("hallSubtotal" + hallSubtotal);
					System.out.println("orderHours" + orderHours);
//					savehallName = hallName[x];
					hallSubtotal = hallSubtotal + hsb.getHallSubtotal();
					orderHours = orderHours + hsb.getOrderHours();

					hallPrice = hsb.getPrice();
					hsbTemp.setHallID(savehallName);
					hsbTemp.setPrice(hallPrice);
					hsbTemp.setOrderHours(orderHours);
					hsbTemp.setHallSubtotal(hallSubtotal);
//					hsbList.remove(hsb);
					System.out.println("比對時,DB廳名&hsb廳名相同");
				} else {
					System.out.println("比對時,DB廳名&hsb廳名不同");
				}
//				HallSaleBean hsbTemp = new HallSaleBean(savehallName, hallPrice, orderHours, hallSubtotal);
//				hsbListToPage.add(hsbTemp);
			}
			if (hsbTemp.getHallID() != null) {
				hsbListToPage.add(hsbTemp);
			} else {
			}
		}
		System.out.println("取得完整資料待傳輸=>" + hsbListToPage.size());
		return hsbListToPage;
	}
}
