package com.infotel.gestionbiblio.dto;

import java.util.List;


public class MemberDto 
{
	private int idMember;
	private String memberLastname;
	private String memberFirstname;
	
	private String memberEmail;

	private String memberPassword;
	private String memberAddress;
	private String memberCity;
	private String memberPostalCode;
	private String memberPhone;
	
	private boolean administrateur;
	
	private List<Integer> bookBasketsIds;
	private List<Integer> borrowsIds;
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(String memberLastname, String memberFirstname, String memberEmail, String memberPassword,
			String memberAddress, String memberCity, String memberPostalCode, String memberPhone,
			boolean administrateur, List<Integer> bookBasketsIds, List<Integer> borrowsIds) 
	{
		super();
		this.memberLastname = memberLastname;
		this.memberFirstname = memberFirstname;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberAddress = memberAddress;
		this.memberCity = memberCity;
		this.memberPostalCode = memberPostalCode;
		this.memberPhone = memberPhone;
		this.administrateur = administrateur;
		this.bookBasketsIds = bookBasketsIds;
		this.borrowsIds = borrowsIds;
	}
	public MemberDto(String memberLastname, String memberFirstname, String memberEmail, String memberPassword,
			String memberAddress, String memberCity, String memberPostalCode, String memberPhone,
			boolean administrateur) {
		super();
		this.memberLastname = memberLastname;
		this.memberFirstname = memberFirstname;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberAddress = memberAddress;
		this.memberCity = memberCity;
		this.memberPostalCode = memberPostalCode;
		this.memberPhone = memberPhone;
		this.administrateur = administrateur;
	}
	public String getMemberLastname() {
		return memberLastname;
	}
	public void setMemberLastname(String memberLastname) {
		this.memberLastname = memberLastname;
	}
	public String getMemberFirstname() {
		return memberFirstname;
	}
	public void setMemberFirstname(String memberFirstname) {
		this.memberFirstname = memberFirstname;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberCity() {
		return memberCity;
	}
	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}
	public String getMemberPostalCode() {
		return memberPostalCode;
	}
	public void setMemberPostalCode(String memberPostalCode) {
		this.memberPostalCode = memberPostalCode;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
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
	public int getIdMember() {
		return idMember;
	}
	
	
	
}
