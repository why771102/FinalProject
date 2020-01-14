package com.l.dao;

import java.util.List;


import com.l.model.MOrderBean;
import com.l.model.ProductsBean;

public interface mOrderDao {
	//查詢場地票
	public List<MOrderBean> getProducts();

		
	//更新產品
	public void updateProducts(ProductsBean product);
	//新增產品
	public void insertProduct(ProductsBean product);

}
