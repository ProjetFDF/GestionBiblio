package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.entity.Author;

import com.infotel.gestionbiblio.service.inter.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
    AuthorService authorService;
    
    @PostMapping("/add")
    public void addAuthor(@RequestBody Author author) 
    {
    	authorService.insert(author);            
    }

    @GetMapping("/getlist")
    public List<Author> getAuthors() 
    {
        List<Author> authors = authorService.getList();

        return authors;
    }
}
