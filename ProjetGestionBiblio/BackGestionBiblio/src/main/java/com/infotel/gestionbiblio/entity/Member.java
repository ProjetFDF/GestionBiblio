package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Member  implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMember")
	private int idMember;
	private String memberLastname, memberFirstname;
	
	@Column(unique=true)
	private String  memberEmail;
	
	private String memberPassword, memberAddress, memberCity,
			memberPostalCode, memberPhone;
	
	private boolean administrateur=false;
	
	@OneToMany(mappedBy = "member")
	private List<BookBasket> bookBasket;
	
	@OneToMany(mappedBy = "member")
	private List<Borrow> borrow;
	
	@OneToMany(mappedBy = "registrationMember")
	private List<Registration> registrations;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberLastname, String memberFirstname, String memberEmail, String memberPassword,
			String memberAddress, String memberCity, String memberPostalCode, String memberPhone,
			boolean administrateur, List<BookBasket> bookBasket, List<Borrow> borrow,
			List<Registration> registrations) {
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
		this.bookBasket = bookBasket;
		this.borrow = borrow;
		this.registrations = registrations;
	}

	public Member(String memberLastname, String memberFirstname, String memberEmail, String memberPassword,
			String memberAddress, String memberCity, String memberPostalCode, String memberPhone) 
	{
		this.memberLastname = memberLastname;
		this.memberFirstname = memberFirstname;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberAddress = memberAddress;
		this.memberCity = memberCity;
		this.memberPostalCode = memberPostalCode;
		this.memberPhone = memberPhone;
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

	public List<BookBasket> getBookBasket() {
		return bookBasket;
	}

	public void setBookBasket(List<BookBasket> bookBasket) {
		this.bookBasket = bookBasket;
	}

	public List<Borrow> getBorrow() {
		return borrow;
	}

	public void setBorrow(List<Borrow> borrow) {
		this.borrow = borrow;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public int getIdMember() {
		return idMember;
	}

	@Override
	public String toString() {
		return "Member [idMember=" + idMember + ", memberLastname=" + memberLastname + ", memberFirstname="
				+ memberFirstname + ", memberEmail=" + memberEmail + ", memberPassword=" + memberPassword
				+ ", memberAddress=" + memberAddress + ", memberCity=" + memberCity + ", memberPostalCode="
				+ memberPostalCode + ", memberPhone=" + memberPhone + ", administrateur=" + administrateur
				+ ", bookBasket=" + bookBasket + ", borrow=" + borrow + ", registrations=" + registrations + "]";
	}






}
