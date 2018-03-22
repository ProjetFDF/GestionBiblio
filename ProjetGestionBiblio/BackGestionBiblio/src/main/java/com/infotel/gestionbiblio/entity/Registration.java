package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Registration  implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRegistration;
	
	private String date;
	
	@ManyToOne
	private Member member;
	
	@ManyToOne
	private Library library;

	public Registration() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration( String registrationDate, Member member, Library library) {
		super();
		this.date = registrationDate;
		this.member = member;
		this.library = library;
	}

	public int getIdRegistration() {
		return idRegistration;
	}

	public void setIdRegistration(int registrationId) {
		this.idRegistration = registrationId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String registrationDate) {
		this.date = registrationDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	

}
