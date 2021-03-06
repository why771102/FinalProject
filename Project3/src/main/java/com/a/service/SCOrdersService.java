package com.a.service;

import java.util.List;

import com.a.model.SCOrdersBean;
import com.p.model.MemberBean;

public interface SCOrdersService {

	
public void insertOrder(SCOrdersBean scob);
	
	public MemberBean getMemberBeanById(Integer memberID);

	public SCOrdersBean getOrder(Integer SCOrderID);

	public List<SCOrdersBean> getMemberOrders(Integer memberID, Integer paymentStatus);
	
	boolean updateStatus(SCOrdersBean ob);
}
