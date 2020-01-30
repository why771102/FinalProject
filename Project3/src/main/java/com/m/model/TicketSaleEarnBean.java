package com.m.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a.model.GenreBean;
import com.a.model.MovieBean;
import com.a.model.ShowTimeHistoryBean;

@Entity
@Table(name = "ticketSaleEarn")
public class TicketSaleEarnBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer No;
	
	String orderDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movieBean;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="genre")
	private GenreBean genreBean;
	
//	Integer numbersOfPlayTime; //當天播放的場次數
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private ShowTimeHistoryBean showTimeHistoryBean;
	
	Integer hallSeats; //座位總數
	
	Integer hallSaleSeats; //實際售出當日的座位總數
	
	Integer ticketSaleTotal; //票卷銷售總額
	
	Integer foodSaleTotal; //飲食銷售總額
	
	Integer foodCost;
	
	@Transient
	String title;
	@Transient
	Double pricePerSeat;
	@Transient
	Integer movieHours;
	@Transient
	Integer subtotal;
	@Transient
	Integer noPlayTimes;
	@Transient
	Double avgSeats;
	
	public TicketSaleEarnBean() {}
	
	//p1 Sale
	public TicketSaleEarnBean(String title, Integer noPlayTimes, Integer hallSeats, 
			Integer hallSaleSeats, Double avgSeats, Double pricePerSeat, 
			Integer subtotal, MovieBean movieBean) {
		this.title = title;
		this.noPlayTimes = noPlayTimes;
		this.hallSeats = hallSeats;
		this.hallSaleSeats = hallSaleSeats;
		this.avgSeats = avgSeats;
		this.pricePerSeat = pricePerSeat;
		this.subtotal = subtotal;
		this.movieBean = movieBean;
	}
	
	@Transient
	Integer ticketCost;
	@Transient
	Integer ticketEarn;
	@Transient
	Integer foodCos;
	@Transient
	Integer foodEarn;
	
	//p1 Earn
	public TicketSaleEarnBean(String title, Integer noPlayTimes, Integer ticketCost, 
			Integer ticketEarn, Integer ticketSaleTotal, Integer foodCos, Integer foodEarn,
			Integer foodSaleTotal, Integer subtotal, MovieBean movieBean) {
		this.title = title;
		this.noPlayTimes = noPlayTimes;
		this.ticketCost = ticketCost;
		this.ticketSaleTotal = ticketSaleTotal;
		this.ticketEarn = ticketEarn;
		this.foodCos = foodCos;
		this.foodEarn = foodEarn;
		this.foodSaleTotal = foodSaleTotal;
		this.subtotal = subtotal;
		this.movieBean = movieBean;
	}
	
	
	public Integer getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Integer ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Integer getTicketEarn() {
		return ticketEarn;
	}

	public void setTicketEarn(Integer ticketEarn) {
		this.ticketEarn = ticketEarn;
	}

	public Integer getFoodCos() {
		return foodCos;
	}

	public void setFoodCos(Integer foodCos) {
		this.foodCos = foodCos;
	}

	public Integer getFoodEarn() {
		return foodEarn;
	}

	public void setFoodEarn(Integer foodEarn) {
		this.foodEarn = foodEarn;
	}

	public Integer getFoodCost() {
		return foodCost;
	}

	public void setFoodCost(Integer foodCost) {
		this.foodCost = foodCost;
	}

	public Double getAvgSeats() {
		return avgSeats;
	}

	public void setAvgSeats(Double avgSeats) {
		this.avgSeats = avgSeats;
	}

	public Integer getNoPlayTimes() {
		return noPlayTimes;
	}

	public void setNoPlayTimes(Integer noPlayTimes) {
		this.noPlayTimes = noPlayTimes;
	}

	public Integer getFoodSaleTotal() {
		return foodSaleTotal;
	}

	public void setFoodSaleTotal(Integer foodSaleTotal) {
		this.foodSaleTotal = foodSaleTotal;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getMovieHours() {
		return movieHours;
	}

	public void setMovieHours(Integer movieHours) {
		this.movieHours = movieHours;
	}

	public Double getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(Double pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getTicketSaleTotal() {
		return ticketSaleTotal;
	}

	public void setTicketSaleTotal(Integer ticketSaleTotal) {
		this.ticketSaleTotal = ticketSaleTotal;
	}

	public GenreBean getGenreBean() {
		return genreBean;
	}

	public void setGenreBean(GenreBean genreBean) {
		this.genreBean = genreBean;
	}

	public Integer getHallSeats() {
		return hallSeats;
	}

	public void setHallSeats(Integer hallSeats) {
		this.hallSeats = hallSeats;
	}

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

//	public Integer getNumbersOfPlayTime() {
//		return numbersOfPlayTime;
//	}
//
//	public void setNumbersOfPlayTime(Integer numbersOfPlayTime) {
//		this.numbersOfPlayTime = numbersOfPlayTime;
//	}

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
