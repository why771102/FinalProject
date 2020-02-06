package com.p.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.HallBean;
import com.c.model.SeatsBean;
import com.l.model.CategoriesBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.l.model.TicketBean;
import com.p.model.MemberBean;


public interface MemberProductsQueryDao{
	
	//用MemberID來Query歷史訂單，直接用致緯的mOrderBean
	//希望能秀出1.電影名稱2.電影場次(日期和播出時間)3.票價4.訂票數量
	//5.用戶買了什麼
	//主要就是訂單內容啦
	//這個方法可能會非常複雜
	
	//查詢歷史訂票，因為可能會有很多筆，所以用list，前端要用for each取出來
	public List<MOrderBean> getMOrderBeanByMemberID(Integer memberID);//看看參數要填啥
	
	//查詢歷史訂票細節，用上面找出的的ordersID來查詢
	public MOrderDetailBean getListMOrderDetailBeanByOrdersID(Integer ordersID);
	
	//用ordersID來查訂票座位
	public TicketBean getTicketBeanByOrdersID(Integer ordersID);
	
	//用ordersID來查訂票座位2222
	public List<TicketBean> getTicketBeanByOrdersID2(Integer ordersID);
	
	
//	//取得MemberBean
//	public MemberBean getMemberBeanByMemberID(Integer memberID);
//	
//	//取得ProductsBean
//	public ProductsBean getProductsBeanByProductID(Integer productID);
//	
//	//(要塞進ProductsBean中)取得CategoriesBean
//	public CategoriesBean getCategoriesBeanByCategoryID(Integer categoryID);
//	
//	//取得MOrderDetailBean
//	public MOrderDetailBean getMOrderDetailBeanByOrdersID(Integer ordersID);
//	
//	//(要塞進TicketBean中)取得SeatBean
//	public SeatsBean getSeatBeanBySeatID(String SeatID);
//	
//	//取得ShowTimeHistoryBean
//	public ShowTimeHistoryBean getShowTimeHistoryBeanByShowTimeID(Integer showTimeID);
//	
//	//(要塞進ShowTimeHistoryBean中)取得HallBean
//	public HallBean getHallBeanByHallID(String hallID);
//	
//	//(要塞進ShowTimeHistoryBean中)取得RunBean
//	public RunningBean getRunningBeanByHallID(Integer rnuID);
//	
//	//(要塞進RunningBean中)
//	public MovieBean getMovieBeanByMovieID(Integer movieID);
	
	

}
