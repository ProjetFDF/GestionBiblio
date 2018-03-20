package com.infotel.gestionbiblio.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.CategoryDto;
import com.infotel.gestionbiblio.entity.Category;
import com.infotel.gestionbiblio.service.inter.CategoryService;



@Component
public class CategoryMapper {

	@Autowired
	CategoryService categoryService;

	public Category dtoToCategory(CategoryDto categoryDto) {

		Category category = new Category(categoryDto.getName(),categoryDto.getDescription());


		return category;
	}

	public CategoryDto categoryToDto(Category category) {

		return new CategoryDto(category.getName(),category.getDescription());
	}

}
