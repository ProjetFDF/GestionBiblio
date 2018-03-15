package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Temporal(TemporalType.DATE)
	private Date publicationDate;

	@ManyToOne
	private Category category;
	@ManyToOne
	private Editor editor;
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
	private List<BookCopy> bookCopy;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Author> author = new ArrayList<Author>();
	@ManyToOne
	Library library;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int iSBN, String bookTitre, String bookDescription, String imagePath, boolean popularBook,
			boolean periodicBook, float bookPrice, Date publicationDate, Category category, Editor editor,
			List<BookCopy> bookCopy, List<Author> author, Library library) 
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
		this.bookCopy = bookCopy;
		this.author = author;
		this.library = library;
	}
	
	public Book(int iSBN, String bookTitre, String bookDescription, String imagePath, boolean popularBook,
			boolean periodicBook, float bookPrice, Date publicationDate) {
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

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
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

	public List<BookCopy> getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(List<BookCopy> bookCopy) {
		this.bookCopy = bookCopy;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}



	public boolean isPeriodicBook() {
		return periodicBook;
	}



	public void setPeriodicBook(boolean periodicBook) {
		this.periodicBook = periodicBook;
	}



	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", bookTitre=" + bookTitre + "]";
	}



	

}
