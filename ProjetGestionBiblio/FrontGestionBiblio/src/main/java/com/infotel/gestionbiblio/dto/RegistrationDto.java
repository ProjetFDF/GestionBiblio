package com.infotel.gestionbiblio.dto;

import java.util.Date;
import java.util.List;

public class RegistrationDto {
	private int registrationId;
	private Date registrationDate;
	private Integer registrationMember;
	private List<Integer> libraries;
	
	public RegistrationDto() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationDto(Date registrationDate, Integer registrationMember, List<Integer> libraries) {
		this.registrationDate = registrationDate;
		this.registrationMember = registrationMember;
		this.libraries = libraries;
	}

	public RegistrationDto(Date registrationDate, Integer registrationMember) {
		this.registrationDate = registrationDate;
		this.registrationMember = registrationMember;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Integer getRegistrationMember() {
		return registrationMember;
	}

	public void setRegistrationMember(Integer registrationMember) {
		this.registrationMember = registrationMember;
	}

	public List<Integer> getLibraries() {
		return libraries;
	}

	public void setLibraries(List<Integer> libraries) {
		this.libraries = libraries;
	}
	
	
}
