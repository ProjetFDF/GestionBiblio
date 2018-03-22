package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book  implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBook;
	private int ISBN;
	private String bookTitre, bookDescription, imagePath;
	private boolean popularBook, periodicBook;
	private float bookPrice;
	
	private String publicationDate;

	@ManyToOne
	private Category category;
	@ManyToOne
	private Editor editor;
	@ManyToMany
	private List<Author> authors;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int iSBN, String bookTitre, String bookDescription, String imagePath, boolean popularBook,
			boolean periodicBook, float bookPrice, String publicationDate, Category category, Editor editor, List<Author> authors) 
	{
		super();
		ISBN = iSBN;
		this.bookTitre = bookTitre;
		this.bookDescription = bookDescription;
		this.imagePath = imagePath;
		this.popularBook = popularBook;
		this.periodicBook = periodicBook;
		this.bookPrice = bookPrice;
		this.publicationDate = publicationDate;
		this.category = category;
		this.editor = editor;
		this.authors = authors;
	}
	
	public Book(int iSBN, String bookTitre, String bookDescription, String imagePath, boolean popularBook,
			boolean periodicBook, float bookPrice, String publicationDate) {
		super();
		ISBN = iSBN;
		this.bookTitre = bookTitre;
		this.bookDescription = bookDescription;
		this.imagePath = imagePath;
		this.popularBook = popularBook;
		this.periodicBook = periodicBook;
		this.bookPrice = bookPrice;
		this.publicationDate = publicationDate;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getBookTitre() {
		return bookTitre;
	}

	public void setBookTitre(String bookTitre) {
		this.bookTitre = bookTitre;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isPopularBook() {
		return popularBook;
	}

	public void setPopularBook(boolean popularBook) {
		this.popularBook = popularBook;
	}

	public boolean isPeriodicBook() {
		return periodicBook;
	}

	public void setPeriodicBook(boolean periodicBook) {
		this.periodicBook = periodicBook;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	


	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public int getIdBook() {
		return idBook;
	}

	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", bookTitre=" + bookTitre + ", bookDescription=" + bookDescription
				+ ", imagePath=" + imagePath + ", popularBook=" + popularBook + ", periodicBook=" + periodicBook
				+ ", bookPrice=" + bookPrice + ", publicationDate=" + publicationDate + "]";
	}


}
