package com.infotel.gestionbiblio.dto;

import java.util.Date;


public class BorrowDto {
	private String borrowDate;
    private String returnDate;
	private int idBorrow;
	private Integer idBookCopy;
	
	public BorrowDto() {
		// TODO Auto-generated constructor stub
	}

	public BorrowDto(String borrowDate, String returnDate, Integer idBookCopy) {
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.idBookCopy = idBookCopy;
	}

	public BorrowDto(String borrowDate, String returnDate) {
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;

	}

	public String getBorrowDate() {
		return borrowDate;
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
