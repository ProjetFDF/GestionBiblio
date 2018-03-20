package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.infotel.gestionbiblio.entity.Category;

import com.infotel.gestionbiblio.service.inter.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
    CategoryService categoryService;
    
    @PostMapping("/add")
    public void addCategory(@RequestBody Category category) 
    {
    	categoryService.insert(category);            
    }

    @GetMapping("/getlist")
    public List<Category> getCategorys() 
    {
        List<Category> categorys = categoryService.getList();

        return categorys;
    }
}
