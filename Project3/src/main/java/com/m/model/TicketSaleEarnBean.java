package com.m.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.a.model.MovieBean;
import com.a.model.ShowTimeHistoryBean;

@Entity
@Table(name = "ticketSaleEarn")
public class TicketSaleEarnBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	String orderDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movieBean;
	
	Integer numbersOfPlayTime; //當天播放的場次數
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private ShowTimeHistoryBean showTimeHistoryBean;
	
	Integer hallSaleSeats; //實際售出當日的座位總數
	
	public TicketSaleEarnBean() {}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public MovieBean getMovieBean() {
		return movieBean;
	}

	public void setMovieBean(MovieBean movieBean) {
		this.movieBean = movieBean;
	}

	public Integer getNumbersOfPlayTime() {
		return numbersOfPlayTime;
	}

	public void setNumbersOfPlayTime(Integer numbersOfPlayTime) {
		this.numbersOfPlayTime = numbersOfPlayTime;
	}

	public ShowTimeHistoryBean getShowTimeHistoryBean() {
		return showTimeHistoryBean;
	}

	public void setShowTimeHistoryBean(ShowTimeHistoryBean showTimeHistoryBean) {
		this.showTimeHistoryBean = showTimeHistoryBean;
	}

	public Integer getHallSaleSeats() {
		return hallSaleSeats;
	}

	public void setHallSaleSeats(Integer hallSaleSeats) {
		this.hallSaleSeats = hallSaleSeats;
	}
}
