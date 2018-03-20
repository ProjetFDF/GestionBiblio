package com.infotel.gestionbiblio.dto;

import java.util.List;


public class BookCopyDto {
	private int idBookCopy;
	private String bookCopyTitle;
	private Integer bookshelf;
	private List<Integer> bookBaskets;
	private Integer book;
	
	public BookCopyDto() {
	}

	public BookCopyDto(String bookCopyTitle, Integer bookshelf, List<Integer> bookBaskets, Integer book) {
		this.bookCopyTitle = bookCopyTitle;
		this.bookshelf = bookshelf;
		this.bookBaskets = bookBaskets;
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

	public List<Integer> getBookBaskets() {
		return bookBaskets;
	}

	public void setBookBaskets(List<Integer> bookBaskets) {
		this.bookBaskets = bookBaskets;
	}

	public Integer getBook() {
		return book;
	}

	public void setBook(Integer book) {
		this.book = book;
	}
	
}
