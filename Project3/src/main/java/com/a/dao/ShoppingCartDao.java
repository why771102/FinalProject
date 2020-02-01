package com.a.dao;

import java.util.List;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.l.model.ProductsBean;

public interface ShoppingCartDao {

	// 查詢此member 在order table裡面status = 0 是否有東西 返回orderID
	public Integer getShoppingCart(Integer memberID);

	// 如果有東西在DB 把shoppingCart table 全部撈出
	public List<SCOrderDetailBean> getOrderDetails(Integer SCOrderID);

	// 顯示shopping cart裡放的商品
	public SCOrderDetailBean showShoppingCart(Integer SCOrderID);

	// 全數刪除order table裡面的資料 (記得要先刪掉fk)
	public void deleteShoppingCart(Integer memberID);

	public void deleteProduct(Integer SCOrderID, Integer productID);

	// 按了購買後 如果有數量的更改
	public void updateQty(SCOrderDetailBean scodb);

	// 查詢庫存(假設庫存都沒了 delete購物車商品)
	public Integer queryQty(Integer productId);

	// 存商品
	public void saveProduct(Integer SCOrderID, SCOrderDetailBean scodb);

	public void createShoppingCart(SCOrdersBean scob);

	public SCOrderDetailBean querySameProduct(Integer SCOrderID, SCOrderDetailBean scodb);
	
	//加入商品頁的下拉式選單
//	public String getAllProductsFromCate();
	
	

}
