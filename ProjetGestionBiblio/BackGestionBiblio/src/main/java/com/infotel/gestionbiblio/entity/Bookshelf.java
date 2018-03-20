package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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

	public Bookshelf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookshelf(String name, String description, int bookNumber) {
		super();
		this.name = name;
		this.description = description;
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

	
}
