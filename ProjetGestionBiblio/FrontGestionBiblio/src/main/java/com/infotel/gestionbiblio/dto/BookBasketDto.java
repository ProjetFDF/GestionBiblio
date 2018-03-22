package com.infotel.gestionbiblio.dto;

import java.util.Date;
import java.util.List;


public class BookBasketDto {
	private int idBookBasket;
	private String creationDate;
	private String deliveryDate;
	private List<Integer> bookCopyIds;

	
	public BookBasketDto(String creationDate, String deliveryDate, List<Integer> bookCopyIds) {
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


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public String getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public List<Integer> getBookCopyIds() {
		return bookCopyIds;
	}


	public void setBookCopyIds(List<Integer> bookCopyIds) {
		this.bookCopyIds = bookCopyIds;
	}

}
