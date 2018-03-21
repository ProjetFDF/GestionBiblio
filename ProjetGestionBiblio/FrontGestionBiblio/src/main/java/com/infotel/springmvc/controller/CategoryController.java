package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.CategoryDto;
import com.infotel.gestionbiblio.entity.Category;
import com.infotel.gestionbiblio.exception.ServiceException;
import com.infotel.gestionbiblio.mapper.CategoryMapper;
import com.infotel.gestionbiblio.service.inter.CategoryService;
import com.infotel.gestionbiblio.utils.ControllerConstante;
import com.infotel.gestionbiblio.utils.Resultat;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
    CategoryService categoryService;
    

	@Autowired
	CategoryMapper categoryMapper;

	@PostMapping("/add")
	public void addCategory(@RequestBody CategoryDto categoryDto) {

		categoryService.insert(categoryMapper.dtoToCategory(categoryDto));
	}

	@PostMapping("/update")
	public void updateCategory(@RequestBody CategoryDto categoryDto) 
	{
		categoryService.update(categoryMapper.dtoToCategory(categoryDto));
	}

	@GetMapping("/getlist")
	public Resultat getCategorys() 
	{
		
		Resultat result = new Resultat();
		
		try 
		{		
			List<CategoryDto> viewCategorys = new ArrayList<CategoryDto>();

			List<Category> categorys = categoryService.getList();
	
			for (Category category : categorys) {
				viewCategorys.add(categoryMapper.categoryToDto(category));
			}
			
			result.setPayload(viewCategorys);
			result.setMessage(ControllerConstante.LIST_SUCCESS);
			result.setSuccess(true);
		}
		catch (Exception e) 
		{
			result.setSuccess(false);
			result.setMessage(ControllerConstante.LIST_ERROR);
			e.printStackTrace();
		}
		
		return result;
	}
	
	@GetMapping("/get")
	public CategoryDto getCategory(int id) 
	{
		Category category = categoryService.getById(id);

		CategoryDto categoryDto = categoryMapper.categoryToDto(category);

		return categoryDto;
	}
	
	@GetMapping("/delete")
	public void deleteCategory(int id) 
	{
		Category category = categoryService.getById(id);

		categoryService.delete(category);
	}

}
