package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Bookshelf implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBookshelf;
	private String name, description;
	private int bookNumber;
	
	@OneToMany(mappedBy = "bookshelf")
	private List<BookCopy> bookshelfBookCopys;

	public Bookshelf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookshelf(String name, String description, int bookNumber, List<BookCopy> bookshelfBookCopys) {
		super();
		this.name = name;
		this.description = description;
		this.bookNumber = bookNumber;
		this.bookshelfBookCopys = bookshelfBookCopys;
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

	public List<BookCopy> getBookshelfBookCopys() {
		return bookshelfBookCopys;
	}

	public void setBookshelfBookCopys(List<BookCopy> bookshelfBookCopys) {
		this.bookshelfBookCopys = bookshelfBookCopys;
	}

	
}
