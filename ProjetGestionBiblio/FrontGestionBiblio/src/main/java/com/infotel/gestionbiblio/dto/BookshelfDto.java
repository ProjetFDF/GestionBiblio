package com.infotel.gestionbiblio.dto;

import java.util.List;


public class BookshelfDto {
	private int idBookshelf;
	private String name;
	private String description;
	private int bookNumber;
	private List<Integer> bookCopyIds;
	
	public BookshelfDto() {
		// TODO Auto-generated constructor stub
	}

	public BookshelfDto(String bookshelfName, String bookshelfDescription, int bookNumber,
			List<Integer> bookshelfBookCopy) {
		this.name = bookshelfName;
		this.description = bookshelfDescription;
		this.bookNumber = bookNumber;
		this.bookCopyIds = bookshelfBookCopy;
	}

	public BookshelfDto(String bookshelfName, String bookshelfDescription, int bookNumber) {
		this.name = bookshelfName;
		this.description = bookshelfDescription;
		this.bookNumber = bookNumber;
	}

	public int getIdBookshelf() {
		return idBookshelf;
	}

	public void setIdBookshelf(int idBookshelf) {
		this.idBookshelf = idBookshelf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public List<Integer> getBookCopyIds() {
		return bookCopyIds;
	}

	public void setBookCopyIds(List<Integer> bookCopyIds) {
		this.bookCopyIds = bookCopyIds;
	}

	
}
