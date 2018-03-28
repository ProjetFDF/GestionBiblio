package com.infotel.gestionbiblio.dto;

import java.util.List;


public class MemberDto 
{
	private int idMember;
	private String lastname;
	private String firstname;
	
	private String email;

	private String password;
	private String address;
	private String city;
	private String postalCode;
	private String phone;
	
	private boolean administrateur;
	
	private List<Integer> bookBasketsIds;
	private List<Integer> borrowsIds;
	
	public MemberDto() {
		super();
	}
	public MemberDto(String memberLastname, String memberFirstname, String memberEmail, String memberPassword,
			String memberAddress, String memberCity, String memberPostalCode, String memberPhone,
			boolean administrateur, List<Integer> bookBasketsIds, List<Integer> borrowsIds) 
	{
		super();
		this.lastname = memberLastname;
		this.firstname = memberFirstname;
		this.email = memberEmail;
		this.password = memberPassword;
		this.address = memberAddress;
		this.city = memberCity;
		this.postalCode = memberPostalCode;
		this.phone = memberPhone;
		this.administrateur = administrateur;
		this.bookBasketsIds = bookBasketsIds;
		this.borrowsIds = borrowsIds;
	}
	public MemberDto(String memberLastname, String memberFirstname, String memberEmail, String memberPassword,
			String memberAddress, String memberCity, String memberPostalCode, String memberPhone,
			boolean administrateur) {
		super();
		this.lastname = memberLastname;
		this.firstname = memberFirstname;
		this.email = memberEmail;
		this.password = memberPassword;
		this.address = memberAddress;
		this.city = memberCity;
		this.postalCode = memberPostalCode;
		this.phone = memberPhone;
		this.administrateur = administrateur;
	}
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	public List<Integer> getBookBasketsIds() {
		return bookBasketsIds;
	}
	public void setBookBasketsIds(List<Integer> bookBasketsIds) {
		this.bookBasketsIds = bookBasketsIds;
	}
	public List<Integer> getBorrowsIds() {
		return borrowsIds;
	}
	public void setBorrowsIds(List<Integer> borrowsIds) {
		this.borrowsIds = borrowsIds;
	}
	
	
	
}
