package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class BookBasket implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookBasketId;
	private Date bookBasketCreationDate, bookBasketDeliveryDate;

	@ManyToMany(mappedBy = "bookBaskets")
	private List<BookCopy> bookBasketBookCopy;
	
	@ManyToOne
	private Member member;

	public BookBasket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookBasket(Date bookBasketCreationDate, Date bookBasketDeliveryDate, List<BookCopy> bookBasketBookCopy,
			Member member) {
		super();
		this.bookBasketCreationDate = bookBasketCreationDate;
		this.bookBasketDeliveryDate = bookBasketDeliveryDate;
		this.bookBasketBookCopy = bookBasketBookCopy;
		this.member = member;
	}

	public Date getBookBasketCreationDate() {
		return bookBasketCreationDate;
	}

	public void setBookBasketCreationDate(Date bookBasketCreationDate) {
		this.bookBasketCreationDate = bookBasketCreationDate;
	}

	public Date getBookBasketDeliveryDate() {
		return bookBasketDeliveryDate;
	}

	public void setBookBasketDeliveryDate(Date bookBasketDeliveryDate) {
		this.bookBasketDeliveryDate = bookBasketDeliveryDate;
	}

	public List<BookCopy> getBookBasketBookCopy() {
		return bookBasketBookCopy;
	}

	public void setBookBasketBookCopy(List<BookCopy> bookBasketBookCopy) {
		this.bookBasketBookCopy = bookBasketBookCopy;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getBookBasketId() {
		return bookBasketId;
	}

	@Override
	public String toString() {
		return "BookBasket [bookBasketId=" + bookBasketId + ", bookBasketCreationDate=" + bookBasketCreationDate
				+ ", bookBasketDeliveryDate=" + bookBasketDeliveryDate + ", bookBasketBookCopy=" + bookBasketBookCopy
				+ ", member=" + member + "]";
	}

	
}
