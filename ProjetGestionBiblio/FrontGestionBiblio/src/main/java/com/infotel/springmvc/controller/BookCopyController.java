package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.entity.BookCopy;
import com.infotel.gestionbiblio.service.inter.BookCopyService;

@RestController
@RequestMapping("/bookCopy")
public class BookCopyController 
{
	@Autowired
	BookCopyService bookCopyService;
	
	@PostMapping("/add")
	public void addBook(@RequestBody BookCopy bookCopy) 
	{
		bookCopyService.insert(bookCopy);			
	}

	@GetMapping("/getlist")
	public List<BookCopy> getBookCopies() 
	{
		List<BookCopy> bookCopies = bookCopyService.getList();

		return bookCopies;
	}
}
