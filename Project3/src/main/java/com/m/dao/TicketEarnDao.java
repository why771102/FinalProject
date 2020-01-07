package com.m.dao;

public interface TicketEarnDao {
	
	//線上票券收入DBT: Products => productID, productName(電影名稱?), category(1純票/2優惠票), cost(拆帳成本?)
	
	//實體票券收入DBT: PaymentReceived => amount,　numberOfTickets
	
	//實體票券電影名稱待整理DBT: seatOrder？　場次數？
	
	//DBT: movies => movieID, title, profitRatio拆帳, runningTime片長, status上映狀態
	
	//DBT: running => release上映日, offDate實際下映日

	
	//線上隨餐收入DBT: Products => productID, productName, category(3隨餐收入), cost

	//DBT: OrderDetail => productID, unitPrice, quantity, discount

}
