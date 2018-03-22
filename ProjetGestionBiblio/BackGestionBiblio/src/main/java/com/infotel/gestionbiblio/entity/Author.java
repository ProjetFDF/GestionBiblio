package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Author implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorId;
	private String authorLastname, authorFirstname;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
	private List<Book> books;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String authorLastname, String authorFirstname, List<Book> books) {
		super();
		this.authorLastname = authorLastname;
		this.authorFirstname = authorFirstname;
		this.books = books;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorLastname=" + authorLastname + ", authorFirstname="
				+ authorFirstname + "]";
	}

	
}
