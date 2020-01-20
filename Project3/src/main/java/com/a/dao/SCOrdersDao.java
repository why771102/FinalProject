package com.a.dao;

import java.util.List;

import com.a.model.SCOrdersBean;
import com.p.model.MemberBean;

public interface SCOrdersDao {
	
	public void insertOrder(SCOrdersBean scob);
	
	public MemberBean getMemberBeanById(Integer memberID);

	public SCOrdersBean getOrder(Integer SCOrderID);

	public List<SCOrdersBean> getMemberOrders(String memberID, Integer paymentStatus);
	
	boolean updateStatus(SCOrdersBean ob);
}
