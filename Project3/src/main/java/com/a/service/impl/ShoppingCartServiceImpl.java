package com.a.service.impl;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.dao.ShoppingCartDao;
import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.service.ShoppingCartService;
import com.l.model.ProductsBean;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	ShoppingCartDao scdao;

	@Autowired
	public void setDao(ShoppingCartDao scdao) {
		this.scdao = scdao;
	}

	@Transactional
	@Override
	public Integer getShoppingCart(Integer memberID) {

		return scdao.getShoppingCart(memberID);
	}

	@Transactional
	@Override
	public List<SCOrderDetailBean> getOrderDetails(Integer SCOrderID) {
		// TODO Auto-generated method stub
		return scdao.getOrderDetails(SCOrderID);
	}

	@Transactional
	@Override
	public SCOrderDetailBean showShoppingCart(Integer SCOrderID) {
		// TODO Auto-generated method stub
		return scdao.showShoppingCart(SCOrderID);
	}

	@Transactional
	@Override
	public void deleteShoppingCart(Integer memberID) {
		scdao.deleteShoppingCart(memberID);
		;

	}

	@Transactional
	@Override
	public void deleteProduct(Integer SCOrderID, Integer productID) {
		scdao.deleteProduct(SCOrderID, productID);

	}

	@Transactional
	@Override
	public boolean updateQty(SCOrderDetailBean scodb) {
		return scdao.updateQty(scodb);

	}

	@Transactional
	@Override
	public Integer queryQty(Integer productId) {

		return scdao.queryQty(productId);
	}

	@Transactional
	@Override
	public void saveProduct(Integer SCOrderID, SCOrderDetailBean scodb) {
		scdao.saveProduct(SCOrderID, scodb);

	}

	@Transactional
	@Override
	public void createShoppingCart(SCOrdersBean scob) {
		scdao.createShoppingCart(scob);

	}

	@Transactional
	@Override
	public SCOrderDetailBean querySameProduct(Integer SCOrderID, SCOrderDetailBean scodb) {

		return scdao.querySameProduct(SCOrderID, scodb);
	}

	// getMemberID
	public Integer getMemberID(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mIDstr = null;
		int mID = 0;
		try {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if (name.equals("memberID")) {
					mIDstr = cookie.getValue();
				}
			}
		if (Integer.parseInt(mIDstr) == 0) {
			mID = 0;
		} else {
			mID = Integer.parseInt(mIDstr);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mID;
	}

}
