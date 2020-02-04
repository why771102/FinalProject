package com.m.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.CategoriesBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleBean;
import com.m.model.ProductSaleEarnBean;

@Repository
public class ProductSaleDaoImpl implements ProductSaleDao {

	SessionFactory factory;
	ProductSaleDao dao;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Autowired
	public void setDao(ProductSaleDao dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getCategoryNames() {
		String hql = "SELECT c.categoryName FROM CategoriesBean c " + "WHERE c.categoryID BETWEEN 4 AND 13";
		Session session = factory.getCurrentSession();
		List<String> categoryNames = new ArrayList<>();
		categoryNames = session.createQuery(hql).getResultList();

		String ans = "";
		ans += "<SELECT id='categoryNames'>"
				+ "<option value='all' selected=''>全部商品</option>"
				+ "<option value='allFood'>餐點總覽</option>";
		for (String cate : categoryNames) {
			ans += "<option value='" + cate + "'>" + cate + "</option>";
		}
		ans += "</SELECT>";
		return ans;
	}

	// default and 全部選項
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getAllProductInfo(String sDate, String eDate) {
		System.out.println("sDate---" + sDate);
		System.out.println("eDate---" + eDate);

		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		System.out.println("psebList.size()" + psebList.size());
//		System.out.println("psebList: " + psebList.get(0).getProductsBean().getProductName());

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID BETWEEN 4 AND 13";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			CategoriesBean cb = null;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					cb = pseb.getCategoriesBean();
						
					pseb1.setCategoriesBean(cb);
					System.out.println("__________" + cb.getCategoryID() + "________________");
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}

	// 選擇all food
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getAllFoodInfo(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID BETWEEN 4 AND 5 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID BETWEEN 4 AND 5";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}

	// 選擇4
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getFoodInfo4(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 4 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 4";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}

	// 選擇5
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getFoodInfo5(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 5 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 5";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}

	// 選擇6~13
	//6
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID BETWEEN 6 AND 13 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID BETWEEN 6 AND 13";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//6
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo6(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 6 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 6";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//7
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo7(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 7 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 7";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//8
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo8(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 8 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 8";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//9
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo9(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 9 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 9";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//10
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo10(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 10 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 10";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//11
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo11(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 11 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 11";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//12
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo12(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 12 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 12";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//13
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo13(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 13 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID = 13";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();
		System.out.println("PIDs.size()" + PIDs.size());

		List<ProductSaleEarnBean> psList = new ArrayList<>();

		for (Integer i : PIDs) {
			String productName = null;
			Integer unitPrice = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer qty = 0;
			Integer subtotal = 0;
			Integer earnSubtotal = 0;
			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean();
			for (ProductSaleEarnBean pseb : psebList) {
				if (i == pseb.getProductsBean().getProductID()) {
					productName = pseb.getProductsBean().getProductName();
					unitPrice = pseb.getPrice();
					qty = qty + pseb.getQtyTotal();
					subtotal = subtotal + pseb.getPrice() * pseb.getQtyTotal();
					
					cost = pseb.getProductsBean().getCost();
					earn = unitPrice - cost;
					earnSubtotal = qty * earn;
					
					pseb1.setProductsBean(pseb.getProductsBean());
					pseb1.setProductName(productName);
					pseb1.setPrice(unitPrice);
					pseb1.setQtyTotal(qty);
					pseb1.setSubtotal(subtotal);
					pseb1.setCost(cost);
					pseb1.setEarn(earn);
					pseb1.setEarnSubtotal(earnSubtotal);
					
				} else {
//					System.out.println("出現不應該會有的PID比對!");
				}
			}
//			ProductSaleEarnBean pseb1 = new ProductSaleEarnBean(productName, unitPrice, qty, subtotal);
			if (pseb1.getPrice() != null) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}
	
	//p2 method
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getInfoByDate(Integer productID, String sDate, String eDate) {
		Session session = factory.openSession();
//		String hql = "SELECT productID FROM ProductsBean WHERE productName = :productName";
//		Integer pid = session.get(ProductsBean.class, pName).getProductID();
		String hql = "FROM ProductSaleEarnBean WHERE productID = :productID AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList1 = new ArrayList<>();
		psebList1 = session.createQuery(hql).setParameter("productID", productID).setParameter("sDate", sDate)
				.setParameter("eDate", eDate).getResultList();
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		for(ProductSaleEarnBean pseb : psebList1) {
			Integer sub = pseb.getPrice() * pseb.getQtyTotal();
			Integer cost = pseb.getProductsBean().getCost();
			Integer earn = pseb.getPrice() - cost;
			Integer earnSubtotal = sub - cost * pseb.getQtyTotal();
			pseb.setSubtotal(sub);
			pseb.setCost(cost);
			pseb.setEarn(earn);
			pseb.setEarnSubtotal(earnSubtotal);
			psebList.add(pseb);
		}
		
		session.close();
		System.out.println("psebList.size()=>" + psebList.size());
		return psebList;
	}
	
	@Override
	public String getPname(Integer productID) {
		Session session = factory.getCurrentSession();
		String productName = session.get(ProductsBean.class, productID).getProductName();
		return productName;
	}
	
	// 計算目前資料數的日期
	@SuppressWarnings("unchecked")
	@Override
	public List<LocalDate> getFoodDates() {
		String hql = "SELECT DISTINCT playStartTime FROM ShowTimeHistoryBean ORDER BY playStartTime ASC";
		Session session = factory.getCurrentSession();
		List<String> dates = new ArrayList<>();
		List<LocalDate> dates1 = new ArrayList<>();
		dates = session.createQuery(hql).getResultList();
		for (String date : dates) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(date, formatter).toLocalDate();
			dates1.add(orderDate);
		}
		List<LocalDate> newList = dates1.stream().distinct().collect(Collectors.toList());
		return newList;
	}
	// ==================================================================================================================


	@SuppressWarnings("unchecked")
	@Override
	// 計算周邊商品的過程step1 ===========NEW
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB) {
		String hql = "FROM SCOrdersBean";
		Session session = factory.getCurrentSession();
		List<SCOrdersBean> SCOrdersList = new ArrayList<>();
		List<SCOrdersBean> SCODList = new ArrayList<>();
		SCOrdersList = session.createQuery(hql).getResultList();

		LocalDate Sd = LocalDate.parse(orderDateA);
		LocalDate Ed = LocalDate.parse(orderDateB);
		for (SCOrdersBean scob : SCOrdersList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(scob.getOrdDate(), formatter).toLocalDate();
			long SdOdDays = ChronoUnit.DAYS.between(Sd, orderDate);
			long EdOdDays = ChronoUnit.DAYS.between(Ed, orderDate);
			if (SdOdDays >= 0 && EdOdDays <= 0) {
				SCODList.add(scob);
				System.out.println("符合 輸入查詢區間與scob日期比較");
				System.out.println("scob=>" + SCODList.size());
			} else {
				System.out.println("不符合 輸入查詢區間與scob日期比較");
			}
		}
		return SCODList;
		// SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost
	}

	// 計算周邊商品的過程step2 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getPeripheralPB() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 6";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}

	// 計算周邊商品的p1輸出step3 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleBean> getPeripheralSCOD(List<ProductsBean> pbList, List<SCOrdersBean> scbList) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SCOrderDetailBean";
		List<SCOrderDetailBean> SCODList1 = new ArrayList<>();
		SCODList1 = session.createQuery(hql).getResultList();
		List<ProductSaleBean> psbList = new ArrayList<>();

		String saveProductName = null;
		Integer unitPrice = 0;
//		Double discount = 0.0;
		Integer qty = 0;
		Integer productSubtotal = 0;
		Integer cost = 0;
		Integer earn = 0;
		Integer earnTotal = 0;
		for (SCOrdersBean scb : scbList) {
			for (SCOrderDetailBean scodb : SCODList1) {
				if (scb.getsCOrderID() == scodb.getSCOrderID()) {
					for (ProductsBean pb : pbList) {
						if (pb.getProductName().equals(scodb.getProductsBean().getProductName())) {
							productSubtotal = productSubtotal + scb.getTotal();
							unitPrice = unitPrice + scodb.getProductsBean().getUnitPrice(); // getPBean
							saveProductName = scodb.getProductsBean().getProductName();
//							scodb.getProductsID();
							qty = qty + scodb.getQuantity();
							cost = cost + scodb.getProductsBean().getCost();
							earn = earn + (unitPrice - cost);
							earnTotal = earnTotal + earn;
							productSubtotal = productSubtotal + (unitPrice * qty);
							ProductSaleBean psb = new ProductSaleBean(saveProductName, qty, unitPrice, cost, earn,
									productSubtotal, earnTotal);
							psbList.add(psb);
						} else {
							System.out.println("比對時pb & scod產品名稱不相同");
						}
					}
				} else {
					System.out.println("比對時od & odb OID不相同");
				}
			}
		}
		return psbList;
	}

	@Override
	public Integer getCategory(String pName) {
		String hql = "SELECT category FROM ProductsBean WHERE productName= :pName";
		Session session = factory.getCurrentSession();
		Integer CID = (Integer) session.createQuery(hql).getSingleResult();
		return CID;
	}
}
