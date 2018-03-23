package com.infotel.gestionbiblio.dto;

import java.util.List;


public class BookDto 
{
	//Attibuts simple
	private int idBook;
	private int isbn;
	private String bookTitre, bookDescription, imagePath;
	private boolean popularBook, periodicBook;
	private float bookPrice;
	private String publicationDate;

	//Id attributs complexes
	private int categoryId;
	private int editorId;
	private List<Integer> authorIds;
	
	public BookDto() 
	{
		super();
	}
	public BookDto(int isbn, String bookTitre, String bookDescription, String imagePath, boolean popularBook,
			boolean periodicBook, float bookPrice, String publicationDate, int idCategory, int idEditor,
			List<Integer> authorIds) 
	{
		super();
		this.isbn = isbn;
		this.bookTitre = bookTitre;
		this.bookDescription = bookDescription;
		this.imagePath = imagePath;
		this.popularBook = popularBook;
		this.periodicBook = periodicBook;
		this.bookPrice = bookPrice;
		this.publicationDate = publicationDate;
		this.categoryId = idCategory;
		this.editorId = idEditor;
		this.authorIds = authorIds;
	}
	
	public BookDto(int isbn, String bookTitre, String bookDescription, String imagePath, boolean popularBook,
			boolean periodicBook, float bookPrice, String publicationDate, int categoryId, int editorId) {
		super();
		this.isbn = isbn;
		this.bookTitre = bookTitre;
		this.bookDescription = bookDescription;
		this.imagePath = imagePath;
		this.popularBook = popularBook;
		this.periodicBook = periodicBook;
		this.bookPrice = bookPrice;
		this.publicationDate = publicationDate;
		this.categoryId = categoryId;
		this.editorId = editorId;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getEditorId() {
		return editorId;
	}
	public void setEditorId(int editorId) {
		this.editorId = editorId;
	}
	public List<Integer> getAuthorIds() {
		return authorIds;
	}
	public void setAuthorIds(List<Integer> authorIds) {
		this.authorIds = authorIds;
	}

	
}
