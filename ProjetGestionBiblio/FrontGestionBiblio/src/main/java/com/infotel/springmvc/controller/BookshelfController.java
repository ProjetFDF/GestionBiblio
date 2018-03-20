package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.entity.Bookshelf;
import com.infotel.gestionbiblio.service.inter.BookshelfService;

@RestController
@RequestMapping("/bookshelf")
public class BookshelfController {
	@Autowired
    BookshelfService bookshelfService;
    
    @PostMapping("/add")
    public void addBookshelf(@RequestBody Bookshelf bookshelf) 
    {
        bookshelfService.insert(bookshelf);            
    }

    @GetMapping("/getlist")
    public List<Bookshelf> getBookshelfs() 
    {
        List<Bookshelf> bookshelfs = bookshelfService.getList();

        return bookshelfs;
    }
}

