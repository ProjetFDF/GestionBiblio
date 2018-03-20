package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity
public class BookCopy implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBookCopy;
	private String bookCopyTitle;
	
	@ManyToOne
	private Bookshelf bookshelf;
	
	@ManyToMany
	private List<BookBasket> bookBaskets;

	@ManyToOne
	private Book book;
	
	/*@ManyToOne
	Borrow borrow;*/

	public BookCopy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookCopy(String bookCopyTitle, Bookshelf bookshelf, List<BookBasket> bookBaskets, Book book) {
		super();
		this.bookCopyTitle = bookCopyTitle;
		this.bookshelf = bookshelf;
		this.bookBaskets = bookBaskets;
		this.book = book;
	//	this.borrow = borrow;
	}

	public String getBookCopyTitle() {
		return bookCopyTitle;
	}

	public void setBookCopyTitle(String bookCopyTitle) {
		this.bookCopyTitle = bookCopyTitle;
	}

	public Bookshelf getBookshelf() {
		return bookshelf;
	}

	public void setBookshelf(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}

	public List<BookBasket> getBookBaskets() {
		return bookBaskets;
	}

	public void setBookBaskets(List<BookBasket> bookBaskets) {
		this.bookBaskets = bookBaskets;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getIdBookCopy() {
		return idBookCopy;
	}

	
}
