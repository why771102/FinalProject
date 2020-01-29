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
		String hql = "SELECT c.categoryName FROM CategoriesBean c " + "WHERE c.categoryID BETWEEN 4 AND 6";
		Session session = factory.getCurrentSession();
		List<String> categoryNames = new ArrayList<>();
		categoryNames = session.createQuery(hql).getResultList();

		String ans = "";
		ans += "<SELECT id='categoryNames' onclick='sendCate()'>"
				+ "<option value='' selected='' disabled=''>請選擇</option>" + "<option value='all'>全部商品</option>"
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

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID " + "BETWEEN 4 AND 6";
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

		String hql1 = "SELECT productID FROM ProductsBean WHERE categoryID " + "BETWEEN 4 AND 5";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).getResultList();

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
			if (pseb1.getPrice() != 0) {
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

		String hql1 = "SELECT DISTINCT productID FROM ProductSaleEarnBean WHERE categoryID = 4 AND orderDate "
				+ "BETWEEN :sDate AND :eDate";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

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
			if (pseb1.getPrice() != 0) {
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

		String hql1 = "SELECT DISTINCT productID FROM ProductSaleEarnBean WHERE categoryID = 5 AND orderDate "
				+ "BETWEEN :sDate AND :eDate";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

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
			if (pseb1.getPrice() != 0) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}

	// 選擇6
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM ProductSaleEarnBean WHERE categoryID = 6 AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

		String hql1 = "SELECT DISTINCT productID FROM ProductSaleEarnBean WHERE categoryID = 6 AND orderDate "
				+ "BETWEEN :sDate AND :eDate";
		List<Integer> PIDs = new ArrayList<>();
		PIDs = session.createQuery(hql1).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();

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
			if (pseb1.getPrice() != 0) {
				psList.add(pseb1);
			} else {
			}
		}
		session.close();
		return psList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleEarnBean> getInfoByDate(String pName, String sDate, String eDate) {
		Session session = factory.openSession();
//		String hql = "SELECT productID FROM ProductsBean WHERE productName = :productName";
		Integer pid = session.get(ProductsBean.class, pName).getProductID();
		String hql = "FROM ProductSaleEarnBean WHERE productID = :pid AND orderDate BETWEEN :sDate AND :eDate";
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		psebList = session.createQuery(hql).setParameter("pid", pid).setParameter("sDate", sDate)
				.setParameter("eDate", eDate).getResultList();

		session.close();
		return psebList;
	}

	// ==================================================================================================================
	// 存飲食到資料庫方法step 1 ---- NEW
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

//	// 存周邊商品到資料庫方法step 1 ---- NEW
//	// 計算目前資料數的日期
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<LocalDate> getPeripheralDates() {
//		String hql = "SELECT DISTINCT orderDate FROM SCOrdersBean ORDER BY orderDate ASC";
//		Session session = factory.getCurrentSession();
//		List<String> dates = new ArrayList<>();
//		List<LocalDate> dates1 = new ArrayList<>();
//		dates = session.createQuery(hql).getResultList();
//		for (String date : dates) {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//			LocalDate orderDate = LocalDateTime.parse(date, formatter).toLocalDate();
//			dates1.add(orderDate);
//		}
//		List<LocalDate> newList = dates1.stream().distinct().collect(Collectors.toList());
//
//		return newList;
//	}
//
//	// 存周邊商品到資料庫方法step 2 ---- NEW
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<SCOrdersBean> getPeripheralSCOrder(LocalDate orderDate) {
//		String hql = "FROM SCOrdersBean";
//		Session session = factory.getCurrentSession();
//		List<SCOrdersBean> SCOrdersList = new ArrayList<>();
//		SCOrdersList = session.createQuery(hql).getResultList();
//		List<SCOrdersBean> SCOList = new ArrayList<>();
//
//		for (SCOrdersBean scob : SCOrdersList) {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//			LocalDate SCOorderDate = LocalDateTime.parse(scob.getOrderDate(), formatter).toLocalDate();
//			long Days = ChronoUnit.DAYS.between(SCOorderDate, orderDate);
//			if (Days == 0) {
//				SCOList.add(scob);
////					System.out.println("符合 假資料中該日與scob日期比較");
//				System.out.println("scob=>" + SCOList.size());
//			} else {
//				System.out.println("不符合 假資料中該日與scob日期比較");
//			}
//		}
//		return SCOList;
//	}
//
//	// 存周邊商品到資料庫方法step 3 ---- NEW
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<SCOrderDetailBean> getPeripheralSCODs(List<SCOrdersBean> scbList) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM SCOrderDetailBean";
//		List<SCOrderDetailBean> SCODList1 = new ArrayList<>();
//		SCODList1 = session.createQuery(hql).getResultList();
//
//		List<SCOrderDetailBean> scodList = new ArrayList<>();
//		for (SCOrdersBean scb : scbList) {
//			for (SCOrderDetailBean scodb : SCODList1) {
//				if (scb.getsCOrderID() == scodb.getSCOrdersBean().getsCOrderID()) {
//					scodList.add(scodb);
//
//				} else {
//					System.out.println("比對時od & odb OID不相同");
//				}
//			}
//		}
//		return scodList;
//	}
//
//	// 存周邊商品到資料庫方法step 4 ---- NEW
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ProductSaleEarnBean> getPeripheralPBs(List<SCOrderDetailBean> scodList) {
//		List<ProductsBean> pbList = new ArrayList<>();
//		String hql = "FROM ProductsBean WHERE categoryID = 6";
//		Session session = factory.getCurrentSession();
//		pbList = session.createQuery(hql).getResultList();
//
//		List<ProductSaleEarnBean> psebList = new ArrayList<>();
////		Integer productID = null; //要存DB
////		LocalDate orderDate = null; //要存DB
////		Double discount = 0.0; //拿unitprice出來算
//		ProductsBean productb = null;
//		Integer qty = 0; // 加總存db
//		Integer price = 0;
//
//		for (ProductsBean pb : pbList) {
//			productb = pb;
//			for (SCOrderDetailBean scodb : scodList) {
//				if (pb.getProductID() == scodb.getProductsBean().getProductID()) {
////					productID = pb.getProductID();
//					price = Math.round(scodb.getProductsBean().getUnitPrice() * (1 - scodb.getDiscount()));
//					qty = qty + scodb.getQuantity();
//				} else {
//					System.out.println("比對時pb & scod產品名稱不相同");
//				}
//			}
//			ProductSaleEarnBean pseb = new ProductSaleEarnBean(null, productb, qty, price);
//			psebList.add(pseb);
//		}
//		return psebList;
//	}

	@SuppressWarnings("unchecked")
	@Override
	// 計算周邊商品的過程step1 ===========NEW
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB) {
		String hql = "FROM SCOrdersBean";
//		String hql1 = "FROM products p "
//				+ "left join p.SCOrderDetail scod left join scod.SCOrders sco "
//				+ "WHERE sco.orderDate BETWEEN :orderDateA AND :orderDateB";
		// on p.productID = scod.productID;
		// on scod.SCOrderID = sc.SCOrderID;
		Session session = factory.getCurrentSession();
		List<SCOrdersBean> SCOrdersList = new ArrayList<>();
		List<SCOrdersBean> SCODList = new ArrayList<>();
		SCOrdersList = session.createQuery(hql).getResultList();

		LocalDate Sd = LocalDate.parse(orderDateA);
		LocalDate Ed = LocalDate.parse(orderDateB);
		for (SCOrdersBean scob : SCOrdersList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(scob.getOrderDate(), formatter).toLocalDate();
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

	// 計算4,5的過程step1 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowTimeHistoryBean> getMovieDate(String playStartTimeA, String playStartTimeB) {
		String hql = "FROM ShowTimeHistoryBean";
		Session session = factory.getCurrentSession();
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		sthbList = session.createQuery(hql).getResultList();

		List<ShowTimeHistoryBean> sthbList1 = new ArrayList<>();

		LocalDate Sd = LocalDate.parse(playStartTimeA);
		LocalDate Ed = LocalDate.parse(playStartTimeB);

		for (ShowTimeHistoryBean sthb : sthbList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(sthb.getPlayStartTime(), formatter).toLocalDate();

			long SdOdDays = ChronoUnit.DAYS.between(Sd, orderDate);
			long EdOdDays = ChronoUnit.DAYS.between(Ed, orderDate);

			if (SdOdDays >= 0 && EdOdDays <= 0) {
				sthbList1.add(sthb);
				System.out.println("符合 輸入查詢區間與sthb日期比較");
				System.out.println("scob=>" + sthbList1.size());
			} else {
				System.out.println("不符合 輸入查詢區間與sthb日期比較");
			}
		}
		return sthbList1;
	}

	// 計算4,5的過程step2 ===========NEW

	@SuppressWarnings("unchecked")
	@Override
	public List<MOrderDetailBean> getMODBList() {
		String hql = "FROM MOrderDetailBean";
		List<MOrderDetailBean> modbList = new ArrayList<>();
		Session session = factory.getCurrentSession();
		modbList = session.createQuery(hql).getResultList();
		return modbList;
	}

	// 計算4的過程step3 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getFoodPB4() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 4";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}

	// 計算5的過程step3 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getFoodPB5() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 5";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}

	// 計算4+5的過程step3 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getAllFoodPB() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID BETWEEN 4 AND 5";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}

	// 選下拉4, 5飲食step4 ====NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleBean> showFoodOutput(List<ShowTimeHistoryBean> sthbList, List<MOrderDetailBean> modbList,
			List<ProductsBean> pbList) {
		String hql = "FROM MOrderBean";
		Session session = factory.getCurrentSession();
		List<MOrderBean> mobList = new ArrayList<>();
		mobList = session.createQuery(hql).getResultList();

		List<ProductSaleBean> psbList = new ArrayList<>();
		String saveProductName = null;
		Integer qty = 0;
		Integer unitPrice = 0;
		Integer productSubtotal = 0;
		Integer cost = 0;
		Integer earn = 0;
		Integer earnTotal = 0;
		for (ShowTimeHistoryBean sthb : sthbList) {
			for (MOrderBean mob : mobList) {
				if (sthb.getShowTimeId().equals(mob.getShowTimeHistoryBean().getShowTimeId())) {
					for (MOrderDetailBean modb : modbList) {
						if (mob.getOrdersID() == modb.getmOrderBean().getOrdersID()) {
							for (ProductsBean pb : pbList) {
								if (pb.getProductID() == modb.getProductsBean().getProductID()) {
									saveProductName = pb.getProductName();
									qty = qty + modb.getQuantity();
									unitPrice = unitPrice
											+ (int) Math.round(modb.getSellUnitPrice() * modb.getDiscount());
									productSubtotal = productSubtotal + (unitPrice * qty);
									cost = cost + pb.getCost();
									earn = earn + (unitPrice - cost);
									earnTotal = earnTotal + earn;
									ProductSaleBean psb = new ProductSaleBean(saveProductName, qty, unitPrice, cost,
											earn, productSubtotal, earnTotal);
									psbList.add(psb);
								} else {
									System.out.println("比對時, pb & modb的PID不同");
								}
							}
						} else {
							System.out.println("比對時, mob & modb的OID不同");
						}
					}
				} else {
					System.out.println("比對時, sthb & mob的showtime不同");
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

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<String> getDistinctProductNames() {
//		List<String> productNames = new ArrayList<>();
//		String hql = "SELECT DISTINCT productName FROM products";
//		Session session = factory.getCurrentSession();
//		productNames = session.createQuery(hql).getResultList();
//		return productNames;
//	}

//	// 存飲食到資料庫方法step 2 ---- NEW
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<MOrderDetailBean> getFoodSCOrder1() {
//		String hql = "FROM MOrderBean";
//		Session session = factory.openSession();
//
//		List<MOrderBean> mOrdersList = new ArrayList<>();
//		mOrdersList = session.createQuery(hql).getResultList();
//		
//		String hql1 = "FROM MOrderDetailBean";
//		List<MOrderDetailBean> mOdList = new ArrayList<>();
//		mOdList = session.createQuery(hql1).getResultList();
//		
//		List<MOrderDetailBean> mb = new ArrayList<>(); 
//		
//		for(MOrderBean mob : mOrdersList) {
//			Integer total = 0;
//			for(MOrderDetailBean modb : mOdList) {
//				if(mob.getOrdersID() == modb.getmOrderBean().getOrdersID()) {
//					total = total + modb.getSellUnitPrice();
//					MOrderDetailBean b = new MOrderDetailBean();
//					b.setSellUnitPrice(total);
//				}else {
//					System.out.println("test~");
//				}
//				
//				System.out.println("total==> " + total);
//			}
//		}
//		return mb;
//	}
}
