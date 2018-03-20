package com.infotel.gestionbiblio.dto;

import java.util.List;


public class BookCopyDto {
	private int idBookCopy;
	private String bookCopyTitle;
	private Integer bookshelf;
	private Integer book;
	
	public BookCopyDto() {
	}

	public BookCopyDto(String bookCopyTitle, Integer bookshelf, Integer book) {
		this.bookCopyTitle = bookCopyTitle;
		this.bookshelf = bookshelf;
		this.book = book;

	}

	public int getIdBookCopy() {
		return idBookCopy;
	}

	public void setIdBookCopy(int idBookCopy) {
		this.idBookCopy = idBookCopy;
	}

	public String getBookCopyTitle() {
		return bookCopyTitle;
	}

	public void setBookCopyTitle(String bookCopyTitle) {
		this.bookCopyTitle = bookCopyTitle;
	}

	public Integer getBookshelf() {
		return bookshelf;
	}

	public void setBookshelf(Integer bookshelf) {
		this.bookshelf = bookshelf;
	}


	public Integer getBook() {
		return book;
	}

	public void setBook(Integer book) {
		this.book = book;
	}
	
}
