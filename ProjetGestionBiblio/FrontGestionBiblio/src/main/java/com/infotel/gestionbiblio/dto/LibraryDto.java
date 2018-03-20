package com.infotel.gestionbiblio.dto;

import java.util.List;


public class LibraryDto {
	private int idLibrary;
	private int libraryCode;
	private String libraryName; 
	private String libraryAddress;
	private List<Integer> registrations;
	List<Integer> books;
	
	public LibraryDto() {
		// TODO Auto-generated constructor stub
	}

	public LibraryDto(int libraryCode, String libraryName, String libraryAddress, List<Integer> registrations,
			List<Integer> books) {
		this.libraryCode = libraryCode;
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.registrations = registrations;
		this.books = books;
	}

	public LibraryDto(int libraryCode, String libraryName, String libraryAddress) {
		this.libraryCode = libraryCode;
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
	}

	public int getIdLibrary() {
		return idLibrary;
	}

	public void setIdLibrary(int idLibrary) {
		this.idLibrary = idLibrary;
	}

	public int getLibraryCode() {
		return libraryCode;
	}

	public void setLibraryCode(int libraryCode) {
		this.libraryCode = libraryCode;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
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
