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

	@Temporal(TemporalType.DATE)
	private Date borrowDate, returnDate;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBorrow;

    @ManyToOne
    private BookCopy bookCopy;

	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Borrow(Date borrowDate, Date returnDate, BookCopy bookCopy) {
		super();
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	//	this.member = member;
		this.bookCopy = bookCopy;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

/*	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}*/

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
