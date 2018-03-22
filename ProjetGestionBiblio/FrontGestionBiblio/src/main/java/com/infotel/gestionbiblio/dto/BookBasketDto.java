package com.infotel.gestionbiblio.dto;



public class BookBasketDto {
	private int idBookBasket;
	private String creationDate;
	private String deliveryDate;
	private Integer bookCopyId;

	


	public BookBasketDto(String creationDate, String deliveryDate, Integer bookCopyId) {
		super();
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.bookCopyId = bookCopyId;
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


	public Integer getBookCopyId() {
		return bookCopyId;
	}


	public void setBookCopyId(Integer bookCopyIds) {
		this.bookCopyId = bookCopyIds;
	}

}
