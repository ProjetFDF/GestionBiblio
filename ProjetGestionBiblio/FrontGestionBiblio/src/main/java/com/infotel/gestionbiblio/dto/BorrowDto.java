package com.infotel.gestionbiblio.dto;

import java.util.Date;


public class BorrowDto {
	private Date borrowDate;
    private Date returnDate;
	private int idBorrow;
	private Integer idBookCopy;
	
	public BorrowDto() {
		// TODO Auto-generated constructor stub
	}

	public BorrowDto(Date borrowDate, Date returnDate, Integer idBookCopy) {
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.idBookCopy = idBookCopy;
	}

	public BorrowDto(Date borrowDate, Date returnDate) {
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;

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

	public int getIdBorrow() {
		return idBorrow;
	}

	public void setIdBorrow(int idBorrow) {
		this.idBorrow = idBorrow;
	}

	public Integer getIdBookCopy() {
		return idBookCopy;
	}

	public void setIdBookCopy(Integer idBookCopy) {
		this.idBookCopy = idBookCopy;
	}
	
	
	
}
