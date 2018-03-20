package com.infotel.gestionbiblio.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Editor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEditor;
	private String name; 
	private String address;


	public Editor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Editor(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public int getIdEditor() {
		return idEditor;
	}

	public void setIdEditor(int idEditor) {
		this.idEditor = idEditor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
