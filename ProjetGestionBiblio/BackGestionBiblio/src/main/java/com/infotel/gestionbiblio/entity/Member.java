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

import org.hibernate.Hibernate;



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
	private String lastname, firstname;
	
	@Column(unique=true)
	private String  email;
	
	private String password, address, city,
			postalCode, phone;
	
	private boolean administrateur=false;
	
	@OneToMany
	private List<Borrow> borrows;
	@OneToMany(fetch=FetchType.EAGER)
	private List<BookBasket> bookBaskets;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberLastname, String memberFirstname, String memberEmail, String memberPassword,
			String memberAddress, String memberCity, String memberPostalCode, String memberPhone,
			boolean administrateur, List<BookBasket> bookBasket, List<Borrow> borrows) {
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
		this.bookBaskets = bookBasket;
		this.borrows = borrows;

	}

	public Member(String memberLastname, String memberFirstname, String memberEmail, String memberPassword,
			String memberAddress, String memberCity, String memberPostalCode, String memberPhone) 
	{
		this.lastname = memberLastname;
		this.firstname = memberFirstname;
		this.email = memberEmail;
		this.password = memberPassword;
		this.address = memberAddress;
		this.city = memberCity;
		this.postalCode = memberPostalCode;
		this.phone = memberPhone;
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

	public void setPostalCode(String memberPostalCode) {
		this.postalCode = memberPostalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String memberPhone) {
		this.phone = memberPhone;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	public List<BookBasket> getBookBaskets() {
		
		return bookBaskets;
	}

	public void setBookBaskets(List<BookBasket> bookBaskets) {
		this.bookBaskets = bookBaskets;
	}







}
