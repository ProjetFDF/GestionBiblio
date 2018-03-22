package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class BookBasket implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBookBasket;
	private String creationDate, deliveryDate;

	@OneToOne
	private BookCopy bookCopy;

	public BookBasket() {
		super();
	}


	public BookBasket(String creationDate, String deliveryDate, BookCopy bookCopy) {
		super();
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.bookCopy = bookCopy;
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

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public int getIdBookBasket() {
		return idBookBasket;
	}

	public void setIdBookBasket(int idBookBasket) {
		this.idBookBasket = idBookBasket;
	}

	
}
