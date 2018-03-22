package com.infotel.gestionbiblio.dto;

import java.util.Date;

public class RegistrationDto {
	private int idRegistration;
	private String date;
	private Integer memberId;
	private Integer libraryId;
	
	public RegistrationDto() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationDto(String date, Integer memberId, Integer libraryId) {
		super();
		this.date = date;
		this.memberId = memberId;
		this.libraryId = libraryId;
	}

	public int getIdRegistration() {
		return idRegistration;
	}

	public void setIdRegistration(int idRegistration) {
		this.idRegistration = idRegistration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	
}
