package com.p.service;

import java.util.List;

import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.TicketBean;

public interface MemberProductsQueryService {
	//查詢歷史訂票，因為可能會有很多筆，所以用list，前端要用for each取出來
	public List<MOrderBean> getMOrderBeanByMemberID(Integer memberID);//看看參數要填啥
	
	//查詢歷史訂票細節，用上面找出的的ordersID來查詢
	public MOrderDetailBean getListMOrderDetailBeanByOrdersID(Integer ordersID);
	
	//上面兩個資料進行比對
	public List<MOrderDetailBean> checkMOrder(Integer memberID);
	
	//用ordersID來查訂票座位
	public TicketBean getTicketBeanByOrdersID(Integer ordersID);
	
	//票與mOrder進行比對
	public List<TicketBean> checkTicket(Integer memberID);
	
	//用ordersID來查訂票座位2222
	public List<TicketBean> getTicketBeanByOrdersID2(Integer ordersID);
}
