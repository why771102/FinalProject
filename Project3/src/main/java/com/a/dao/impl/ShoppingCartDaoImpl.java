package com.a.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.ShoppingCartDao;
import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.l.model.ProductsBean;
import com.p.model.MemberBean;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
	
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Integer getShoppingCart(Integer memberID) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT sCOrderID FROM SCOrdersBean WHERE memberID = :memberID AND payStatusNO = 0";
		Integer SCOrderID = null;
		try {
			SCOrderID = (Integer) session.createQuery(hql).setParameter("memberID", memberID).getSingleResult();
			
		} catch(NoResultException e) {
			//SCOrderID = null
			return SCOrderID;
		}
		//SCOrderID 會有數字
		return SCOrderID;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SCOrderDetailBean> getOrderDetails(Integer SCOrderID) {
		List<SCOrderDetailBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String hql = "FROM SCOrderDetailBean WHERE SCOrderID = :SCOrderID";
		list = session.createQuery(hql).setParameter("SCOrderID", SCOrderID).getResultList();
		return list;
	}

	@Override
	public SCOrderDetailBean showShoppingCart(Integer SCOrderID){
		Session session = factory.getCurrentSession();
		SCOrderDetailBean sodb = session.get(SCOrderDetailBean.class, SCOrderID);
		return sodb;
	}

	@Override
	public void deleteShoppingCart(Integer memberID) {
		String hql = "DELETE FROM SCOrder WHERE memberID = :memberID AND payStatusNO = 0";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("memberID", memberID).executeUpdate();
	}

	@Override
	public void deleteProduct(Integer SCOrderID, Integer productID) {
		String hql = "DELETE FROM SCOrderDetailBean WHERE SCOrderID= :SCOrderID and productId= :productID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql)
					.setParameter("SCOrderID", SCOrderID)
					.setParameter("productID", productID)
					.executeUpdate();
	}
	
	@Override
	public boolean updateQty(SCOrderDetailBean scodb) {
		System.out.println("scodb.getQuantity()" + scodb.getQuantity());
		System.out.println("scodb.getSCOrderID()" + scodb.getSCOrderID());
		System.out.println("scodb.getProductID()" + scodb.getProductID());
		String hql = "UPDATE SCOrderDetailBean SET quantity= :quantity where SCOrderID= :SCOrderID and productId = :productId";
		Session session = factory.getCurrentSession();
		try {
		session.createQuery(hql)
				.setParameter("quantity", scodb.getQuantity())
				.setParameter("SCOrderID", scodb.getSCOrderID())
				.setParameter("productId", scodb.getProductID())
				.executeUpdate();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Integer queryQty(Integer productId) {
//		String sql = "SELECT unitStock FROM products where productID= ?";
		Session session = factory.getCurrentSession();
		ProductsBean pb = session.get(ProductsBean.class, productId);
		Integer quantity = pb.getUnitStock();
		return quantity;
	}

	@Override
	public void saveProduct(Integer SCOrderID, SCOrderDetailBean scodb) {
		Session session = factory.getCurrentSession();
		SCOrdersBean scob = session.get(SCOrdersBean.class, SCOrderID);
		scodb.setSCOrdersBean(scob);
		session.save(scodb);
	}

	@Override
	public void createShoppingCart(SCOrdersBean scob) {
		Session session = factory.getCurrentSession();
		MemberBean mb = getMemberBeanById(scob.getMemberID());
		scob.setMemberBean(mb);
		session.save(scob);
	}
	
	public MemberBean getMemberBeanById(Integer memberID) {
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, memberID);
		return mb;
	}

	// 在 OrderDetailProducts member 購物車裡找有沒有相同的商品
	@Override
	public SCOrderDetailBean querySameProduct(Integer SCOrderID, SCOrderDetailBean scodb) {
		SCOrderDetailBean scodb2 = new SCOrderDetailBean();
		scodb2.setQuantity(0);
		Session session = factory.getCurrentSession();
		try {
			String hql = "FROM SCOrderDetailBean WHERE SCOrderID = :SCOrderID and productID= :productID";
			scodb2 = (SCOrderDetailBean) session.createQuery(hql).setParameter("SCOrderID", SCOrderID)
					.setParameter("productID", scodb.getProductID()).getSingleResult();
			return scodb2;
		} catch (Exception e) {
			System.out.println("並無放入過此商品進購物車");
            return scodb2;
		}
    }
//
//	@Override
//	public String getAllProductsFromCate() {
//			String ans = "";
//	        List<String> list = getAllHall();
//	        ans += "<SELECT id='hallID' onchange='showSeats()'>";
//	        ans += "<option value='' selected='' disabled=''>請選擇</option>";
//	        for (String hallID : list) {
//	            if (hallID.equals(selected)) {
//	                ans += "<option value='" + hallID + "' selected>" + hallID + "</option>";
//	            } else {
//	                ans += "<option value='" + hallID + "'>" + hallID + "</option>";
//	            }
//	        }
//	        ans += "</SELECT>";
//	        return ans;
//	}
//	
//	public List<String> getAllProducts(){
//		String hql = "";
//		return null;
//	}

}
