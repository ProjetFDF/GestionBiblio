package com.infotel.gestionbiblio.dto;

import java.util.Date;
import java.util.List;


public class BookDto 
{
	//Attibuts simple
	private int idBook;
	private int ISBN;
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
	public BookDto(int iSBN, String bookTitre, String bookDescription, String imagePath, boolean popularBook,
			boolean periodicBook, float bookPrice, String publicationDate, int idCategory, int idEditor,
			List<Integer> authorIds) 
	{
		super();
		this.ISBN = iSBN;
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
	
	public BookDto(int iSBN, String bookTitre, String bookDescription, String imagePath, boolean popularBook,
			boolean periodicBook, float bookPrice, String publicationDate, int categoryId, int editorId) {
		super();
		ISBN = iSBN;
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
	

	public int getEditorId() {
		return editorId;
	}
	public void setEditorId(int editorId) {
		this.editorId = editorId;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public int getISBN() {
		return this.ISBN;
	}
	public void setISBN(int iSBN) {
		this.ISBN = iSBN;
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
	public int getIdCategory() {
		return categoryId;
	}
	public void setIdCategory(int idCategory) {
		this.categoryId = idCategory;
	}
	public int getIdEditor() {
		return editorId;
	}
	public void setIdEditor(int idEditor) {
		this.editorId = idEditor;
	}
	public List<Integer> getAuthorIds() {
		return authorIds;
	}
	public void setAuthorIds(List<Integer> idAuthor) {
		this.authorIds = idAuthor;
	}
	public int getIdBook() {
		return idBook;
	}

	
}
