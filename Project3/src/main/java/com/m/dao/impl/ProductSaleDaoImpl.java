package com.m.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.l.model.CategoriesBean;
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
	public String getCategoryNames() {
		String hql = "SELECT c.categoryName FROM CategoriesBean c "
				+ "WHERE c.categoryID BETWEEN 4 AND 6";
		Session session = factory.getCurrentSession();
		List<String> categoryNames = new ArrayList<>();
		categoryNames = session.createQuery(hql).getResultList();
        
		String ans = "";
        ans += "<SELECT id='categoryNames' onchange='showCate()'>"
        		+ "<option value='' selected='' disabled=''>請選擇</option>"
        		+ "<option value='all'>全部商品</option>"
        		+ "<option value='allFood'>餐點總覽</option>";
        for (String cate : categoryNames) {
                ans += "<option value='" + cate + "'>" + cate + "</option>";
        }
        ans += "</SELECT>";
		return ans;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	//全部之總飲食
	public List<ProductSaleBean> showAllProductOrders(String playStartTimeA, String playStartTimeB) {
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
	public List<ProductSaleBean> getPeripheralOrders(String orderDateA, String orderDateB) {
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
	public List<ProductSaleBean> showFoodOrder(String categoryName, String playStartTimeA, String playStartTimeB) {
		String hql = "SELECT p.productName, mod.unitPrice, mod.discount, mod.quantity, p.cost FROM products p mod left join p.categories c"
				+ "left join c.mOrderDetail mod left join mod.mOrder mo left join mo.showTimeHistory sth"
				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB AND c.categoryName = :categoryName";
		//		on p.categoryID = c.categoryID
		//		on p.productID = mod.productID
		//	    on mod.ordersID = mo.ordersID
		//		on mo.showTimeID = sth.showTimeID
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrderList = new ArrayList<>();
		foodOrderList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
				.setParameter("playStartTimeB", playStartTimeB)
				.setParameter("categoryName", categoryName).getResultList();
		return foodOrderList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	//選下拉總飲食p1 
	public List<ProductSaleBean> showFoodOrders(String playStartTimeA, String playStartTimeB) {
		String hql = "SELECT p.productName, mod.unitPrice, mod.discount, mod.quantity, p.cost FROM products p left join p.categories c"
				+ "p.mOrderDetail mod left join mod.mOrder mo left join mo.showTimeHistory sth WHERE sth.playStartTime BETWEEN"
				+ ":playStartTimeA AND :playStartTimeB AND c.categoryID BETWEEN 4 AND 5";
		//		on p.categoryID = c.categoryID
		//		on p.productID = mod.productID
		//	    on mod.ordersID = mo.ordersID
		//		on mo.showTimeID = sth.showTimeID
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrdersList = new ArrayList<>();
		foodOrdersList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
				.setParameter("playStartTimeB", playStartTimeB).getResultList();
		return foodOrdersList;
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	//選下拉單個周邊p1
//	public List<ProductSaleBean> showPeripheralOrder(String categoryName, String orderDateA, String orderDateB) {
//		String hql = "SELECT p.productName, scod.unitPrice, scod.discount, scod.quantity, p.cost FROM products p left join"
//				+ "p.categories c left join p.SCOrderDetail scod left join scod.SCOrders sco WHERE c.categoryName = :categoryName"
//				+ "AND sco.orderDate BETWEEN :orderDateA AND :orderDateB";
//		//	on p.categoryID = c.categoryID
//		//	on p.productID = scod.productID;
//		//	on scod.SCOrderID = sco.SCOrderID;
//		Session session = factory.getCurrentSession();
//		List<ProductSaleBean> periperalOrderList  = new ArrayList<>();
//		periperalOrderList = session.createQuery(hql).setParameter("categoryName", categoryName)
//				.setParameter("orderDateA", orderDateA)
//				.setParameter("orderDateB", orderDateB).getResultList();
//		return periperalOrderList;
//	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	//選下拉總周邊p1 
//	public List<ProductSaleBean> showPeriperalOrders(String categoryNameA, String categoryNameB, String orderDateA, String orderDateB) {
//		String hql = "SELECT p.productName, scod.unitPrice, scod.discount, scod.quantity, p.cost FROM products p left join "
//				+ "p.categories c left join p.SCOrderDetail scod left join scod.SCOrders sco WHERE c.categoryName"
//				+ "BETWEEN :categoryNameA AND :categoryNameB AND sco.orderDate BETWEEN :orderDateA AND :orderDateB";
//		//	on p.categoryID = c.categoryID
//		//	on p.productID = scod.productID;
//		//	on scod.SCOrderID = sco.SCOrderID;
//		Session session = factory.getCurrentSession();
//		List<ProductSaleBean> periperalOrders  = new ArrayList<>();
//		periperalOrders = session.createQuery(hql).setParameter("categoryNameA", categoryNameA)
//				.setParameter("categoryNameB", categoryNameB)
//				.setParameter("orderDateA", orderDateA)
//				.setParameter("orderDateB", orderDateB).getResultList();
//		return periperalOrders;
//	}

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

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDistinctProductNames() {
		List<String> productNames = new ArrayList<>();
		String hql = "SELECT DISTINCT productName FROM products";
		Session session = factory.getCurrentSession();
		productNames = session.createQuery(hql).getResultList();
		return productNames;
	}
	
}
