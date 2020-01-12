package com.l.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.l.dao.ProductsDao;
import com.l.model.ProductsBean;


@Repository
public class ProductsDaoImpl implements ProductsDao{
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//查詢單筆
	@Override
	public ProductsBean getProduct(Integer productID) {
		Session session = factory.getCurrentSession();
		ProductsBean pb = session.get(ProductsBean.class, productID);
		return pb;
	}

	//查詢全部
	@Override
	@SuppressWarnings("unchecked")
	public List<ProductsBean> getProducts() {
		String hql="FROM ProductsBean";
		Session session=null;
		List<ProductsBean> list=new ArrayList<>();
		session = factory.getCurrentSession();
		list=session.createQuery(hql).getResultList();
		return list;
	}
	//查詢分類產品們
		@Override
		public List<String> getCategories(){
			String hql="Select Distinct p.category from ProductsBean p";
			Session session=factory.getCurrentSession();
			List<String> list=new ArrayList<>();
			list=session.createQuery(hql).getResultList();
			return list;
		}
	
	//用ID查詢分類產品 
		@Override
		public List<ProductsBean> getCategory(Integer category){
			String hql="from ProductsBean pb where pb.category=:category";
			Session session=factory.getCurrentSession();
			List<ProductsBean> list=new ArrayList<>();
			list=session.createQuery(hql).setParameter("category", category).getResultList();
			return list;
		}
	
	
	
	//用productID更新
	@Override
	public void updateProducts(Integer productID, String productName, Integer category, Integer unitPrice,
			Integer unitStock, Integer cost) {
		String hql="UPDATE ProductsBean SET productName=:newproductName, category=:newcategory, unitPrice=:newunitPrice, unitStock=:newunitStock, cost=:newcost WHERE productID=:id";
		Session session=factory.getCurrentSession();
			int n=session.createQuery(hql)	
					.setParameter("newproductName", productName)
					.setParameter("newcategory", category)
					.setParameter("newunitPrice", unitPrice)
					.setParameter("newunitStock", unitStock)
					.setParameter("newcost", cost)
					.executeUpdate();
	}
	
	//新增單筆
	@Override
	public void insertProduct(ProductsBean product) {
		Session session=factory.getCurrentSession();
		session.save(product);
	}


	



}
