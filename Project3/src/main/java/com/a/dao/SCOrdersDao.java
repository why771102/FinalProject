package com.a.dao;

import java.util.List;

import com.a.model.SCOrdersBean;
import com.a.model.ShippingStatusBean;
import com.p.model.MemberBean;
import com.p.model.PayStatusBean;

public interface SCOrdersDao {
	
	public void insertOrder(SCOrdersBean scob);
	
	public MemberBean getMemberBeanById(Integer memberID);
	
	public ShippingStatusBean getShippingStatusBeanById(Integer shippingStatusID);
	
	public PayStatusBean getPayStatusBeanById(Integer paymentStatusID);

	public SCOrdersBean getOrder(Integer SCOrderID);

	public List<SCOrdersBean> getMemberOrders(String memberID, Integer paymentStatus);
	
	boolean updateStatus(SCOrdersBean ob);
}
