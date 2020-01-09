package com.a.dao;

import java.util.List;

import com.a.model.SCOrdersBean;

public interface SCOrdersDao {

	public SCOrdersBean getOrder(Integer SCOrderID, int Status);

	public List<SCOrdersBean> getMemberUnpaidOrders(String id);
	
	public List<SCOrdersBean> getMemberCompletedOrders(String id);
	
	boolean updateStatus(SCOrdersBean ob);
}
