package com.infotel.gestionbiblio.dto;

import java.util.List;


public class LibraryDto {
	private int idLibrary;
	private int code;
	private String name; 
	private String address;
	private List<Integer> registrations;
	List<Integer> books;
	
	public LibraryDto() {
		// TODO Auto-generated constructor stub
	}

	public LibraryDto(int code, String name, String address, List<Integer> registrations, List<Integer> books) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
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

	public List<Integer> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Integer> registrations) {
		this.registrations = registrations;
	}

	public List<Integer> getBooks() {
		return books;
	}

	public void setBooks(List<Integer> books) {
		this.books = books;
	}

	
}
