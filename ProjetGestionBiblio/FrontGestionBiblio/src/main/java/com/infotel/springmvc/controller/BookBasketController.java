package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.entity.BookBasket;
import com.infotel.gestionbiblio.service.inter.BookBasketService;

@RestController
@RequestMapping("/bookbasket")
public class BookBasketController 
{
	@Autowired
	BookBasketService bookBasketService;
	
	@PostMapping("/add")
	public void addBook(@RequestBody BookBasket bookBasket) 
	{
		bookBasketService.insert(bookBasket);			
	}

	@GetMapping("/getlist")
	public List<BookBasket> getEditors() 
	{
		List<BookBasket> bookBaskets = bookBasketService.getList();

		return bookBaskets;
	}
}
