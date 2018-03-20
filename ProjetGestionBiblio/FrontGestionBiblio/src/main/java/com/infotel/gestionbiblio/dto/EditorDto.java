package com.infotel.gestionbiblio.dto;



public class EditorDto {
	private int idEditor;
	private String name; 
	private String address;
	
	public EditorDto() {
		// TODO Auto-generated constructor stub
	}

	public EditorDto(String name, String address) {
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
