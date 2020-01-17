package com.m.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.l.model.MOrderBean;

public class TicketSaleBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public TicketSaleBean() {}
	
	String hallID;
	Integer genre; //電影類型

	String title; //movieName
	Integer countShowTime; 	//場次數
	Integer hallSeats; //廳的座位總數 (廳的座位數 * 場次數)
	Integer hallSaleSeats; //售出廳的座位總數 (售出廳的座位數 * 場次數)
	Integer avgHallSaleSeats; //平均滿座率
	Double avgPerOrder; //平均單筆消費 (總銷售額ticketSaleSubtotal / 售出廳的座位總數hallSaleSeats)
	Long ticketSaleSubtotal; //總銷售額(含票與飲食)

	Integer ticketPrice; //票價錢
	Long ticketSaleTotal; //票卷銷售總額 (票價錢 * 每筆訂單售出數 相加)
	Long foodSaleTotal; //商品銷售總額
	Integer movieHours;//片長(分鐘) 
	Double avgSalePerHour; //營收時比(銷售總金額ticketSaleSubtotal / (片長movieHours * 場次數countShowTime))

	//earn表格所需欄位
	Double profitRatio; 	//拆帳 0.4(我們是4), 0.5(我們是5), 0.6(我們是6)
	Double ticketEarnTotal; //票卷"總"利潤 (票卷銷售總額ticketSaleTotal * 拆帳profitRatio)
	Integer foodCostTotal; //將所有訂單的food成本加總??
	Integer foodEarnTotal;
	Integer earnSubtotal; //foodEarnTotal + ticketEarnTotal
	//勾選上映區間
	String release;
	String offDate; //實際下映 default 為2999-01-01, if default => now date
	String expectedOffDate; //預計下映
	String playStartTime; //會有場次時間
	
	//用來比較的欄位
	Integer showtimeID;
	List<Integer> showTimeLists;
	List<String> playStartTimes;
	String OrderID;

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public List<String> getPlayStartTimes() {
		return playStartTimes;
	}

	public void setPlayStartTimes(List<String> playStartTimes) {
		this.playStartTimes = playStartTimes;
	}

	public Double getAvgSalePerHour() {
		return avgSalePerHour;
	}

	public void setAvgSalePerHour(Double avgSalePerHour) {
		this.avgSalePerHour = avgSalePerHour;
	}

	public List<Integer> getShowTimeLists() {
		return showTimeLists;
	}

	public void setShowTimeLists(List<Integer> showTimeLists) {
		this.showTimeLists = showTimeLists;
	}

	public MOrderBean getMob() {
		return mob;
	}

	public void setMob(MOrderBean mob) {
		this.mob = mob;
	}

	private MOrderBean mob;
	
	public Integer getEarnSubtotal() {
		return earnSubtotal;
	}

	public void setEarnSubtotal(Integer earnSubtotal) {
		this.earnSubtotal = earnSubtotal;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getOffDate() {
		return offDate;
	}

	public void setOffDate(String offDate) {
		this.offDate = offDate;
	}

	public String getExpectedOffDate() {
		return expectedOffDate;
	}

	public void setExpectedOffDate(String expectedOffDate) {
		this.expectedOffDate = expectedOffDate;
	}

	public String getPlayStartTime() {
		return playStartTime;
	}

	public void setPlayStartTime(String playStartTime) {
		this.playStartTime = playStartTime;
	}

	public Integer getShowtimeID() {
		return showtimeID;
	}

	public void setShowtimeID(Integer showtimeID) {
		this.showtimeID = showtimeID;
	}
	
	//銷售表所需Bean
	
	//有用到這個建構子 => daoimpl站存
	public TicketSaleBean(Integer showtimeID, String title,Integer genre, Integer movieHours, 
			Integer countShowTime, Integer hallSeats, Integer hallSaleSeats,
			Integer avgHallSaleSeats, Double avgPerOrder, Long ticketSaleSubtotal, 
			String release,String expectedOffDate, String offDate, String playStartTime) {
		this.showtimeID = showtimeID;
//		this.hallID = hallID;
		this.title = title;
		this.genre = genre;
		this.movieHours = movieHours;
		this.countShowTime = countShowTime;
		this.hallSeats = hallSeats;
		this.hallSaleSeats = hallSaleSeats;
		this.avgHallSaleSeats = avgHallSaleSeats;
		this.avgPerOrder = avgPerOrder;
		this.ticketSaleSubtotal = ticketSaleSubtotal;
		this.release= release;
		this.expectedOffDate= expectedOffDate;
		this.offDate = offDate;
		this.playStartTime = playStartTime;
	}
	
	//有用到這個建構子 => 最後輸出用p1-2
	public TicketSaleBean(List<Integer> showTimeLists, String title,Integer genre,Integer countShowTime, 
			Integer hallSeats, Integer hallSaleSeats,Integer avgHallSaleSeats, Double avgPerOrder, 
			Long ticketSaleTotal,Long foodSaleTotal,Double avgSalePerHour, Long ticketSaleSubtotal) {
		this.showTimeLists = showTimeLists;
		this.title = title;
		this.genre = genre;
		this.countShowTime = countShowTime;
		this.hallSeats = hallSeats;
		this.hallSaleSeats = hallSaleSeats;
		this.avgHallSaleSeats = avgHallSaleSeats;
		this.avgPerOrder = avgPerOrder;
		this.ticketSaleTotal = ticketSaleTotal;
		this.foodSaleTotal = foodSaleTotal;
		this.avgSalePerHour = avgSalePerHour;
		this.ticketSaleSubtotal = ticketSaleSubtotal;
	}
	
	
	
	//有用到這個建構子 => 最後輸出用p3
	public TicketSaleBean(String hallID, String playStartTime, String title, Integer movieHours, Integer genre, 
			Integer hallSeats,Integer hallSaleSeats,Integer avgHallSaleSeats, Double avgPerOrder, Long ticketSaleTotal,
			Long foodSaleTotal,Double avgSalePerHour, Long ticketSaleSubtotal) {
		this.hallID = hallID;
		this.playStartTime = playStartTime;
		this.title = title;
		this.movieHours = movieHours;
		this.genre = genre;
		this.hallSeats = hallSeats;
		this.hallSaleSeats = hallSaleSeats;
		this.avgHallSaleSeats = avgHallSaleSeats;
		this.avgPerOrder = avgPerOrder;
		this.ticketSaleTotal = ticketSaleTotal;
		this.foodSaleTotal = foodSaleTotal;
		this.avgSalePerHour = avgSalePerHour;
		this.ticketSaleSubtotal = ticketSaleSubtotal;
	}
	
	
	
	//有用到存放sumInfo
	public TicketSaleBean(Integer hallSaleSeats, Long ticketSaleTotal, Long foodSaleTotal, Long ticketSaleSubtotal) {
		this.hallSaleSeats = hallSaleSeats;
		this.ticketSaleTotal = ticketSaleTotal;
		this.foodSaleTotal = foodSaleTotal;
		this.ticketSaleSubtotal = ticketSaleSubtotal;
	}
	
	//有用到這些
	Integer orderID;
	Integer unitPrice;
	Integer quantity;
	Integer productID;
	Integer category;
	Double discount;
	
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}


	//有用到這個建構子
	public TicketSaleBean(Integer productID, Integer category,Integer unitPrice,Integer quantity, Double discount) {
		this.productID = productID;
		this.category = category;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
	}
	
//	public TicketSaleBean(String title,Integer genre, Integer countShowTime, Integer hallSeats, Integer hallSaleSeats,
//			Integer avgHallSaleSeats, Double avgPerOrder, Long ticketSaleSubtotal, Long ticketSaleTotal,
//			Long foodSaleTotal, Double avgEarnPerHour) {
//		this.genre = genre;
//		this.title = title;
//		this.countShowTime = countShowTime;
//		this.hallSeats = hallSeats;
//		this.hallSaleSeats = hallSaleSeats;
//		this.avgHallSaleSeats = avgHallSaleSeats;
//		this.avgPerOrder = avgPerOrder;
//		this.ticketSaleSubtotal = ticketSaleSubtotal;
//		this.ticketSaleTotal = ticketSaleTotal;
//		this.foodSaleTotal = foodSaleTotal;
//		this.avgSalePerHour = avgEarnPerHour;
//	}
//
//	public TicketSaleBean(String hallID,String title,Integer genre, Integer countShowTime, Integer hallSeats,
//			Integer hallSaleSeats, Integer avgHallSaleSeats, Double avgPerOrder, Long ticketSaleSubtotal,
//			Long ticketSaleTotal, Long foodSaleTotal, Double avgEarnPerHour) {
//		this.hallID = hallID;
//		this.genre = genre;
//		this.title = title;
//		this.countShowTime = countShowTime;
//		this.hallSeats = hallSeats;
//		this.hallSaleSeats = hallSaleSeats;
//		this.avgHallSaleSeats = avgHallSaleSeats;
//		this.avgPerOrder = avgPerOrder;
//		this.ticketSaleSubtotal = ticketSaleSubtotal;
//		this.ticketSaleTotal = ticketSaleTotal;
//		this.foodSaleTotal = foodSaleTotal;
//		this.avgSalePerHour = avgEarnPerHour;
//	}
	
	//營收表所需Bean
	public TicketSaleBean(Integer genre, String title, Integer countShowTime, Long ticketSaleTotal,
			Long foodSaleTotal, Double profitRatio, Double ticketEarnTotal, Integer foodCostTotal,
			Integer foodEarnTotal, Integer earnSubtotal) {
		this.genre = genre;
		this.title = title;
		this.countShowTime = countShowTime;
		this.ticketSaleTotal = ticketSaleTotal;
		this.foodSaleTotal = foodSaleTotal;
		this.profitRatio = profitRatio;
		this.ticketEarnTotal = ticketEarnTotal;
		this.foodCostTotal = foodCostTotal;
		this.foodEarnTotal = foodEarnTotal;
	}
	
	public String getHallID() {
		return hallID;
	}

	public void setHallID(String hallID) {
		this.hallID = hallID;
	}

	public Integer getGenre() {
		return genre;
	}

	public void setGenre(Integer genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCountShowTime() {
		return countShowTime;
	}

	public void setCountShowTime(Integer countShowTime) {
		this.countShowTime = countShowTime;
	}

	public Integer getHallSeats() {
		return hallSeats;
	}

	public void setHallSeats(Integer hallSeats) {
		this.hallSeats = hallSeats;
	}

	public Integer getHallSaleSeats() {
		return hallSaleSeats;
	}

	public void setHallSaleSeats(Integer hallSaleSeats) {
		this.hallSaleSeats = hallSaleSeats;
	}

	public Integer getAvgHallSaleSeats() {
		return avgHallSaleSeats;
	}

	public void setAvgHallSaleSeats(Integer avgHallSaleSeats) {
		this.avgHallSaleSeats = avgHallSaleSeats;
	}

	public Double getAvgPerOrder() {
		return avgPerOrder;
	}

	public void setAvgPerOrder(Double avgPerOrder) {
		this.avgPerOrder = avgPerOrder;
	}

	public Long getTicketSaleSubtotal() {
		return ticketSaleSubtotal;
	}

	public void setTicketSaleSubtotal(Long ticketSaleSubtotal) {
		this.ticketSaleSubtotal = ticketSaleSubtotal;
	}

	public Integer getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Long getTicketSaleTotal() {
		return ticketSaleTotal;
	}

	public void setTicketSaleTotal(Long ticketSaleTotal) {
		this.ticketSaleTotal = ticketSaleTotal;
	}

	public Long getFoodSaleTotal() {
		return foodSaleTotal;
	}

	public void setFoodSaleTotal(Long foodSaleTotal) {
		this.foodSaleTotal = foodSaleTotal;
	}

	public Integer getMovieHours() {
		return movieHours;
	}

	public void setMovieHours(Integer movieHours) {
		this.movieHours = movieHours;
	}

	public Double getAvgEarnPerHour() {
		return avgSalePerHour;
	}

	public void setAvgEarnPerHour(Double avgEarnPerHour) {
		this.avgSalePerHour = avgEarnPerHour;
	}

	public Double getProfitRatio() {
		return profitRatio;
	}

	public void setProfitRatio(Double profitRatio) {
		this.profitRatio = profitRatio;
	}

	public Double getTicketEarnTotal() {
		return ticketEarnTotal;
	}

	public void setTicketEarnTotal(Double ticketEarnTotal) {
		this.ticketEarnTotal = ticketEarnTotal;
	}

	public Integer getFoodCostTotal() {
		return foodCostTotal;
	}

	public void setFoodCostTotal(Integer foodCostTotal) {
		this.foodCostTotal = foodCostTotal;
	}

	public Integer getFoodEarnTotal() {
		return foodEarnTotal;
	}

	public void setFoodEarnTotal(Integer foodEarnTotal) {
		this.foodEarnTotal = foodEarnTotal;
	}

}
