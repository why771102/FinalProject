package com.m.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.c.model.NumberOfSeatsBean;
import com.google.gson.Gson;
import com.l.model.ProductsBean;
import com.l.model.mOrderDetailBean;
import com.m.dao.ProductSaleDao;

public class ProductSaleDaoImpl implements ProductSaleDao {

	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	//抓取頁面中所選的下拉式option種類, 輸出各對照項目的產品資訊
	public List<ProductsBean> getProductsInfo(Integer category, String orderDate) {
		String hql = "FROM products p WHERE p.category= :category";
		Session session = factory.getCurrentSession();
		List<ProductsBean> list = new ArrayList<>();
		list = session.createQuery(hql)
				.setParameter("category", category).getResultList();
		return list;
	}

	@Override
	public Timestamp getPlayStartTime(Integer showTimeID) {
		return null;
	}

	@Override
	public List<String> getProductsName(String orderDate) {
		String hql = "FROM products WHERE";
		
		Session session = factory.getCurrentSession();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONArray showProductOrder(String orderDate) {
		String hql = "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM mOrderDetail mod left join mod.products p"
				+ "left join mOrder mo left join showTimeHistory sth WHERE orderDate = :orderDate";
		Session session = factory.getCurrentSession();
       
		JSONArray ja = new JSONArray();
		
		List<Object[]> list = new ArrayList<>();
		list = session.createQuery("hql").setParameter("orderDate", orderDate).getResultList();
		Iterator itr = list.iterator();
		
		while(itr.hasNext()) {
	        JSONObject jo = new JSONObject();
	        String productName;
			
	        
		}
//        String productName = 
        
//		Gson gson = new Gson();
//		String jsonStr = "";
//		jsonStr = gson.toJson(a);
		
		return ja;
	}
//	on mod.productID = p.productID 
//    on mo.ordersID = mod.ordersID
	@Override
	public List<mOrderDetailBean> showProductOrder(Integer category, String orderDate) {

		return null;
	}
	
}
