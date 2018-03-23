package com.infotel.gestionbiblio.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.infotel.gestionbiblio.entity.Author;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.entity.BookBasket;

public class BookBasketFull
{
    int bookBasketId;
	String bookBasketCreationDate;
	String bookBasketDeliveryDate;
	int idBook;
	int isbn;
	String bookTitre;
	String bookDescription;
	String  imagePath;
    boolean popularBook;
    boolean periodicBook;
	float bookPrice;
	String publicationDate;
	int categoryId;
	int editorId;
	List<Integer> authorIds;
	Integer memberId;
	
	public int getBookBasketId() {
		return bookBasketId;
	}
	public void setBookBasketId(int bookBasketId) {
		this.bookBasketId = bookBasketId;
	}
	public String getBookBasketCreationDate() {
		return bookBasketCreationDate;
	}
	public void setBookBasketCreationDate(String bookBasketCreationDate) {
		this.bookBasketCreationDate = bookBasketCreationDate;
	}
	public String getBookBasketDeliveryDate() {
		return bookBasketDeliveryDate;
	}
	public void setBookBasketDeliveryDate(String bookBasketDeliveryDate) {
		this.bookBasketDeliveryDate = bookBasketDeliveryDate;
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
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public void setBook(Book book)
	{
		this.idBook = book.getIdBook();
		this.isbn = book.getISBN();
		this.bookTitre = book.getBookTitre();
		this.bookDescription = book.getBookDescription();
		this.imagePath = book.getImagePath();
		this.popularBook = book.isPopularBook();
		this.periodicBook = book.isPeriodicBook();
		this.bookPrice = book.getBookPrice();
		this.publicationDate = book.getPublicationDate();
		this.categoryId = book.getCategory().getIdCategory();
		this.editorId = book.getEditor().getIdEditor();
		this.authorIds = new ArrayList<Integer>();
		
		for(Author author : book.getAuthors())
		{
			this.authorIds.add(author.getAuthorId());
		}
		
	}
	
	public void setBookBasket(BookBasket bookBasket)
	{
		this.bookBasketId = bookBasket.getIdBookBasket();
		this.bookBasketCreationDate = bookBasket.getCreationDate();
		this.bookBasketDeliveryDate = bookBasket.getDeliveryDate();
	}
}