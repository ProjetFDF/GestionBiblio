package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Borrow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String borrowDate, returnDate;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBorrow;

    @ManyToOne
    private BookCopy bookCopy;

	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Borrow(String borrowDate, String returnDate, BookCopy bookCopy) {
		super();
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	//	this.member = member;
		this.bookCopy = bookCopy;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setIdBorrow(int idBorrow) {
		this.idBorrow = idBorrow;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public int getIdBorrow() {
		return idBorrow;
	}

    

}
