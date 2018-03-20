package com.infotel.gestionbiblio.dto;

import java.util.List;


public class CategoryDto {
	private int categoryId;
	private String categoryName;
	private String CategoryDescription;
	private List<Integer> bookCategory;
	
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(String categoryName, String categoryDescription, List<Integer> bookCategory) {
		this.categoryName = categoryName;
		CategoryDescription = categoryDescription;
		this.bookCategory = bookCategory;
	}

	public CategoryDto(String categoryName, String categoryDescription) {
		this.categoryName = categoryName;
		CategoryDescription = categoryDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

	public List<Integer> getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(List<Integer> bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	
}
