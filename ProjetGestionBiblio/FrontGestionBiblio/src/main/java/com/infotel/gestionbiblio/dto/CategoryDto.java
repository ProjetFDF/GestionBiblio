package com.infotel.gestionbiblio.dto;


public class CategoryDto {
	private int idCategory;
	private String name;
	private String description;
	
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
