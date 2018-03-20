package com.infotel.gestionbiblio.dto;

import java.util.List;

public class AuthorDto {

	private int authorId;
	private String authorLastname; 
	private String authorFirstname;
	private List<Integer> bookIds;
	
	public AuthorDto() {
		// TODO Auto-generated constructor stub
	}

	public AuthorDto(String authorLastname, String authorFirstname, List<Integer> bookIds) {
		this.authorLastname = authorLastname;
		this.authorFirstname = authorFirstname;
		this.bookIds = bookIds;
	}

	public AuthorDto(String authorLastname, String authorFirstname) {
		this.authorLastname = authorLastname;
		this.authorFirstname = authorFirstname;
	}

	public String getAuthorLastname() {
		return authorLastname;
	}

	public void setAuthorLastname(String authorLastname) {
		this.authorLastname = authorLastname;
	}

	public String getAuthorFirstname() {
		return authorFirstname;
	}

	public void setAuthorFirstname(String authorFirstname) {
		this.authorFirstname = authorFirstname;
	}

	public List<Integer> getBookIds() {
		return bookIds;
	}

	public void setBookIds(List<Integer> bookIds) {
		this.bookIds = bookIds;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	
	
	
}
