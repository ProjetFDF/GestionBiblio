package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Library implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibrary;
	private int code;
	private String name, address;

	@OneToMany(mappedBy = "library")
	private List<Registration> registrations;
	
	@OneToMany
	List<Book> books;

	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(int libraryCode, String libraryName, String libraryAddress, List<Registration> registrations,
			List<Book> books) {
		super();
		this.code = libraryCode;
		this.name = libraryName;
		this.address = libraryAddress;
		this.registrations = registrations;
		this.books = books;
	}
	public int getIdLibrary() {
		return idLibrary;
	}

	public void setIdLibrary(int idLibrary) {
		this.idLibrary = idLibrary;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	
}
