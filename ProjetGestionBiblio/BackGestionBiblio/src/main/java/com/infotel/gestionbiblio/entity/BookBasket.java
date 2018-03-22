package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


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

	@OneToMany(fetch=FetchType.EAGER)
	private List<BookCopy> bookCopys;

	public BookBasket() {
		super();
	}

	public BookBasket(String creationDate, String deliveryDate, List<BookCopy> bookCopys) {
		super();
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.bookCopys = bookCopys;
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

	public List<BookCopy> getBookCopys() {
		return bookCopys;
	}

	public void setBookCopys(List<BookCopy> bookCopys) {
		this.bookCopys = bookCopys;
	}

	public int getIdBookBasket() {
		return idBookBasket;
	}

	public void setIdBookBasket(int idBookBasket) {
		this.idBookBasket = idBookBasket;
	}

	
}
