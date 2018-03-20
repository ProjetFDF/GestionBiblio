package com.infotel.gestionbiblio.dto;

import java.util.Date;
import java.util.List;


public class BookBasketDto {
	private int idBookBasket;
	private Date creationDate;
	private Date deliveryDate;
	private List<Integer> bookCopyIds;

	
	public BookBasketDto(Date creationDate, Date deliveryDate, List<Integer> bookCopyIds) {
		super();
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.bookCopyIds = bookCopyIds;
	}


	public BookBasketDto() {
		// TODO Auto-generated constructor stub
	}


	public int getIdBookBasket() {
		return idBookBasket;
	}


	public void setIdBookBasket(int idBookBasket) {
		this.idBookBasket = idBookBasket;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public List<Integer> getBookCopyIds() {
		return bookCopyIds;
	}


	public void setBookCopyIds(List<Integer> bookCopyIds) {
		this.bookCopyIds = bookCopyIds;
	}

}
