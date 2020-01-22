package com.m.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.l.model.CategoriesBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.dao.ProductSaleEarnDao;
import com.m.model.ProductSaleEarnBean;

@Repository
public class ProductSaleEarnDaoImpl implements ProductSaleEarnDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// 第一次比完後, 之後用當天日期每天比就好!!
	// 第一次比完後, 之後用當天日期每天比就好!!
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MOrderBean> saveFoodInfoToDB() {
		Session session = factory.openSession();

		String hql = "SELECT DISTINCT playStartTime FROM ShowTimeHistoryBean ORDER BY playStartTime ASC";

		List<String> dates = new ArrayList<>();
		List<LocalDate> dates1 = new ArrayList<>();
		dates = session.createQuery(hql).getResultList();
		for (String date : dates) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(date, formatter).toLocalDate();
			dates1.add(orderDate);
		}
		List<LocalDate> newList = dates1.stream().distinct().collect(Collectors.toList());

		String hql1 = "FROM MOrderBean";
		List<MOrderBean> mobList = new ArrayList<>();
		mobList = session.createQuery(hql1).getResultList();

		String hql2 = "FROM MOrderDetailBean";
		List<MOrderDetailBean> modList = new ArrayList<>();
		modList = session.createQuery(hql2).getResultList();

		String hql3 = "FROM ProductsBean WHERE categoryID BETWEEN 4 AND 5";
		List<ProductsBean> pbList = new ArrayList<>();
		pbList = session.createQuery(hql3).getResultList();
	
		
		List<MOrderBean> moList = new ArrayList<>(); // 新創的在外面!!!
		Map<LocalDate, List<Integer>> dateAndOID = new LinkedHashMap<LocalDate, List<Integer>>();

		for (LocalDate date : newList) {
			List<MOrderDetailBean> mdList = new ArrayList<>();

			for (MOrderBean mob : mobList) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDate mOrderDate = LocalDateTime.parse(mob.getShowTimeHistoryBean().getPlayStartTime(), formatter)
						.toLocalDate();
				System.out.println("mOrderDate=== " + mOrderDate);
				System.out.println("date=== " + date);
				long Days = ChronoUnit.DAYS.between(mOrderDate, date);
				List<Integer> OIDs = new ArrayList<>();

				if (Days == 0) {
					moList.add(mob);
					System.out.println("moList~~~" + moList.size());

					OIDs.add(mob.getOrdersID());
					System.out.println("OID====" + OIDs);

					for (Integer i : OIDs) {
						System.out.println("---i---" + i);
						for (MOrderDetailBean modb : modList) {
							if (modb.getmOrderBean().getOrdersID() == i) {
								mdList.add(modb);
								System.out.println("mdList.size(): " + mdList.size());
							}
						}
					}
					
					System.out.println("pbList.size() =>" + pbList.size());

					dateAndOID.put(date, OIDs);
					System.out.println("dateAndOID------------" + dateAndOID.size());
				} else {
//					System.out.println("不符合 假資料中該日與mob(showid>playtime)比較");
				}
//				System.out.println("moList.size() 111=>" + moList.size());
			}
			
			for (ProductsBean pb : pbList) {
				ProductsBean productb = pb;
				Integer qty = 0; // 加總存db
				Integer price = 0;
				CategoriesBean cb = null;
//				productb = pb;
				for (MOrderDetailBean modb : mdList) {
					if (pb.getProductID() == modb.getProductsBean().getProductID()) {
						price = (int) Math.round(modb.getProductsBean().getUnitPrice() * modb.getDiscount());
						qty = qty + modb.getQuantity();
						cb = modb.getProductsBean().getCategoriesBean();
						ProductSaleEarnBean pseb = new ProductSaleEarnBean();
						pseb.setOrderDate(date.toString());
						pseb.setPrice(price);
						pseb.setQtyTotal(qty);
						pseb.setProductsBean(productb);
						pseb.setCategoriesBean(cb);
//						psebList.add(pseb);
						session.save(pseb);		
					}
				}
			}
			
		}
		System.out.println("dateAndOID------------" + dateAndOID.size());
//		Set<LocalDate> keys = dateAndOID.keySet();
//		System.out.println("All keys are: " + keys);
//		Set<Entry<LocalDate, List<Integer>>> value = dateAndOID.entrySet();
//		System.out.println("All values are: " + value);
//		 To get all key: value
//		for (LocalDate key : keys) {
//			for (int i = 0; i < dateAndOID.get(key).size(); i++) {
//			System.out.println("map list=>" + dateAndOID);
//			System.out.println(key + ": " + dateAndOID.get(key));
//			}
//		}
		session.close();
		return moList;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SCOrdersBean> savePheriperalDB() {
		Session session = factory.openSession();

		String hql = "SELECT DISTINCT orderDate FROM SCOrdersBean ORDER BY orderDate ASC";

		List<String> dates = new ArrayList<>();
		List<LocalDate> dates1 = new ArrayList<>();
		dates = session.createQuery(hql).getResultList();
		for (String date : dates) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(date, formatter).toLocalDate();
			dates1.add(orderDate);
		}
		List<LocalDate> newList = dates1.stream().distinct().collect(Collectors.toList());

		String hql1 = "FROM SCOrdersBean";
		List<SCOrdersBean> scobList = new ArrayList<>();
		scobList = session.createQuery(hql1).getResultList();

		String hql2 = "FROM SCOrderDetailBean";
		List<SCOrderDetailBean> scodList = new ArrayList<>();
		scodList = session.createQuery(hql2).getResultList();

		String hql3 = "FROM ProductsBean WHERE categoryID = 6";
		List<ProductsBean> pbList = new ArrayList<>();
		pbList = session.createQuery(hql3).getResultList();
	
		
		List<SCOrdersBean> scoList = new ArrayList<>(); // 新創的在外面!!!
		Map<LocalDate, List<Integer>> dateAndSCOID = new LinkedHashMap<LocalDate, List<Integer>>();

		for (LocalDate date : newList) {
			List<SCOrderDetailBean> sdList = new ArrayList<>();

			for (SCOrdersBean scob : scobList) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDate SCOrderDate = LocalDateTime.parse(scob.getOrderDate(), formatter).toLocalDate();
				System.out.println("SCOrderDate=== " + SCOrderDate);
				System.out.println("date=== " + date);
				long Days = ChronoUnit.DAYS.between(SCOrderDate, date);
				List<Integer> SCOIDs = new ArrayList<>();

				if (Days == 0) {
					scoList.add(scob);
					System.out.println("moList~~~" + scoList.size());

					SCOIDs.add(scob.getsCOrderID());
					System.out.println("SCOID====" + SCOIDs);

					for (Integer i : SCOIDs) {
						System.out.println("---i---" + i);
						for (SCOrderDetailBean scod : scodList) {
							if (scod.getSCOrdersBean().getsCOrderID() == i) {
								sdList.add(scod);
								System.out.println("sdList.size(): " + sdList.size());
							}
						}
					}
					
					System.out.println("pbList.size() =>" + pbList.size());

					dateAndSCOID.put(date, SCOIDs);
					System.out.println("dateAndOID------------" + dateAndSCOID.size());
				} else {
//					System.out.println("不符合 假資料中該日與mob(showid>playtime)比較");
				}
//				System.out.println("moList.size() 111=>" + moList.size());
			}
			
			for (ProductsBean pb : pbList) {
				ProductsBean productb = pb;
				Integer qty = 0; // 加總存db
				Integer price = 0;
//				productb = pb;
				for (SCOrderDetailBean scodb : sdList) {
					if (pb.getProductID() == scodb.getProductsBean().getProductID()) {
						//要注意discount大家寫法是否相同 否則容易變0!!!
						price = (int) Math.round(scodb.getProductsBean().getUnitPrice() * scodb.getDiscount());
						qty = qty + scodb.getQuantity();
						ProductSaleEarnBean pseb = new ProductSaleEarnBean();
						pseb.setOrderDate(date.toString());
						pseb.setPrice(price);
						pseb.setQtyTotal(qty);
						pseb.setProductsBean(productb);
//						psebList.add(pseb);
						session.save(pseb);		
					}
				}
			}
			
		}
		System.out.println("dateAndSCOID------------" + dateAndSCOID.size());
//		Set<LocalDate> keys = dateAndOID.keySet();
//		System.out.println("All keys are: " + keys);
//		Set<Entry<LocalDate, List<Integer>>> value = dateAndOID.entrySet();
//		System.out.println("All values are: " + value);
//		 To get all key: value
//		for (LocalDate key : keys) {
//			for (int i = 0; i < dateAndOID.get(key).size(); i++) {
//			System.out.println("map list=>" + dateAndOID);
//			System.out.println(key + ": " + dateAndOID.get(key));
//			}
//		}
		session.close();
		return scobList;
	}
}
