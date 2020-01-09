package com.m.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleBean;

@Repository
public class ProductSaleDaoImpl implements ProductSaleDao {

	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	//全部之總飲食
	public List<ProductSaleBean> showAllFoodOrders(String playStartTimeA, String playStartTimeB) {
		String hql = "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM products p left join p.mOrderDetail mod"
				+ "left join mod.mOrder mo left join mo.showTimeHistory sth "
				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB";
		//		on p.productID = mod.productID
		//	    on mod.ordersID = mo.ordersID
		//		on mo.showTimeID = sth.showTimeID
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrdersList = new ArrayList<>();
		foodOrdersList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
				.setParameter("playStartTimeB", playStartTimeB).getResultList();
		return foodOrdersList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	//全部之總周邊
	public List<ProductSaleBean> showPeripheralOrders(String orderDateA, String orderDateB) {
		String hql = "SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost FROM products p "
				+ "left join p.SCOrderDetail scod left join scod.SCOrders sco "
				+ "WHERE sco.orderDate BETWEEN :orderDateA AND :orderDateB";
	//	on p.productID = scod.productID;
	//	on scod.SCOrderID = sc.SCOrderID;
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> periperalOrdersList = new ArrayList<>();
		periperalOrdersList = session.createQuery(hql).setParameter("orderDateA", orderDateA)
				.setParameter("orderDateB", orderDateB).getResultList();
		return periperalOrdersList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	//選下拉4, 5飲食p1
	public List<ProductSaleBean> showFoodOrder(Integer category, String playStartTimeA, String playStartTimeB) {
		String hql = "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM products p mod left join p.mOrderDetail mod"
				+ "left join mod.mOrder mo left join mo.showTimeHistory sth "
				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB AND p.cateogry = :category";
		//		on p.productID = mod.productID
		//	    on mod.ordersID = mo.ordersID
		//		on mo.showTimeID = sth.showTimeID
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrderList = new ArrayList<>();
		foodOrderList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
				.setParameter("playStartTimeB", playStartTimeB)
				.setParameter("category", category).getResultList();
		return foodOrderList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	//選下拉總飲食p1 
	public List<ProductSaleBean> showFoodOrders(Integer categoryA, Integer categoryB, String playStartTimeA, String playStartTimeB) {
		String hql = "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM products p left join p.mOrderDetail mod"
				+ "left join mod.mOrder mo left join mo.showTimeHistory sth "
				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB AND p.cateogry BETWEEN :categoryA AND :categoryB";
		//		on p.productID = mod.productID
		//	    on mod.ordersID = mo.ordersID
		//		on mo.showTimeID = sth.showTimeID
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrdersList = new ArrayList<>();
		foodOrdersList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
				.setParameter("playStartTimeB", playStartTimeB)
				.setParameter("categoryA", categoryA)
				.setParameter("categoryB", categoryB).getResultList();
		return foodOrdersList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	//選下拉單個周邊p1
	public List<ProductSaleBean> showPeripheralOrder(Integer category, String orderDateA, String orderDateB) {
		String hql = "SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost FROM products p left join p.SCOrderDetail scod"
				+ "left join scod.SCOrders sco WHERE p.category = :category "
				+ "AND sco.orderDate BETWEEN :orderDateA AND :orderDateB";
		//	on p.productID = scod.productID;
		//	on scod.SCOrderID = sco.SCOrderID;
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> periperalOrderList  = new ArrayList<>();
		periperalOrderList = session.createQuery(hql).setParameter("category", category)
				.setParameter("orderDateA", orderDateA)
				.setParameter("orderDateB", orderDateB).getResultList();
		return periperalOrderList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	//選下拉總周邊p1 
	public List<ProductSaleBean> showPeriperalOrders(Integer categoryA, Integer categoryB, String orderDateA, String orderDateB) {
		String hql = "SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost FROM products p left join p.SCOrderDetail scod"
				+ "left join scod.SCOrders sco WHERE p.category BETWEEN :categoryA AND :categoryB "
				+ "AND sco.orderDate BETWEEN :orderDateA AND :orderDateB";
		//	on p.productID = scod.productID;
		//	on scod.SCOrderID = sco.SCOrderID;
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> periperalOrders  = new ArrayList<>();
		periperalOrders = session.createQuery(hql).setParameter("categoryA", categoryA)
				.setParameter("categoryB", categoryB)
				.setParameter("orderDateA", orderDateA)
				.setParameter("orderDateB", orderDateB).getResultList();
		return periperalOrders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB) {
		String hql= "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM products p left join p.mOrderDetail mod"
				+ "left join mod.mOrder mo left join mo.showTimeHistory sth "
				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB AND p.productName= :productName"
				+ "ORDER BY sth.playStartTime ASC";
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrderByTimeList = new ArrayList<>();
		foodOrderByTimeList = session.createQuery(hql).setParameter("productName", productName)
				.setParameter("playStartTimeA", playStartTimeA).setParameter("playStartTimeB",playStartTimeB)
				.getResultList();
		return foodOrderByTimeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB) {
		String hql = "SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost FROM products p "
				+ "left join p.SCOrderDetail scod left join scod.SCOrders sco "
				+ "WHERE sco.orderDate BETWEEN :orderDateA AND orderDateB AND p.productName = :productName"
				+ "ORDER BY sco.orderDate ASC";
		//	on p.productID = scod.productID;
		//	on scod.SCOrderID = sco.SCOrderID;
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> peripheralOrderByTimeList = new ArrayList<>();
		peripheralOrderByTimeList = session.createQuery(hql).setParameter("productName", productName)
				.setParameter("orderDateA", orderDateA).setParameter("orderDateB", orderDateB).getResultList();
		return peripheralOrderByTimeList;
	}

	@Override
	public List<LocalDate> showEachDate(String sDate, String eDate) {
		LocalDate start = LocalDate.parse(sDate);
		LocalDate end = LocalDate.parse(eDate);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
		    totalDates.add(start);
		    start = start.plusDays(1);
		}
		return totalDates;
	}
	
}
