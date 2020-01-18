package com.a.dao.impl;

import java.util.List;

import com.a.dao.SCOrdersDao;
import com.a.model.SCOrdersBean;

public class SCOrdersDaoImpl implements SCOrdersDao {

	@Override
	public SCOrdersBean getOrder(Integer SCOrderID, int Status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SCOrdersBean> getMemberUnpaidOrders(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SCOrdersBean> getMemberCompletedOrders(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStatus(SCOrdersBean ob) {
		// TODO Auto-generated method stub
		return false;
	}

}
