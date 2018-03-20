package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.BookBasketDto;
import com.infotel.gestionbiblio.entity.BookBasket;
import com.infotel.gestionbiblio.mapper.BookBasketMapper;
import com.infotel.gestionbiblio.service.inter.BookBasketService;

@RestController
@RequestMapping("/bookbasket")
public class BookBasketController 
{
	@Autowired
	BookBasketService bookBasketService;
	
	@Autowired
	BookBasketMapper bookBasketMapper;

	@PostMapping("/add")
	public void addBookBasket(@RequestBody BookBasketDto bookDto) {

		bookBasketService.insert(bookBasketMapper.dtoToBook(bookDto));
	}

	@PostMapping("/update")
	public void updateBookBasket(@RequestBody BookBasketDto bookDto) 
	{
		bookBasketService.update(bookBasketMapper.dtoToBook(bookDto));
	}

	@GetMapping("/getlist")
	public List<BookBasketDto> getBookBaskets() 
	{
		List<BookBasketDto> viewBooks = new ArrayList<BookBasketDto>();

		List<BookBasket> bookBaskets = bookBasketService.getList();

		for (BookBasket bookBasket : bookBaskets) {
			
			viewBooks.add(bookBasketMapper.bookToDto(bookBasket));
		}

		return viewBooks;
	}
	
	@GetMapping("/get")
	public BookBasketDto getBookBasket(int id) 
	{
		BookBasket bookBasket = bookBasketService.getById(id);

		BookBasketDto bookBasketDto = bookBasketMapper.bookToDto(bookBasket);

		return bookBasketDto;
	}
	
	@GetMapping("/delete")
	public void deleteBookBasket(int id) 
	{
		BookBasket bookBasket = bookBasketService.getById(id);

		bookBasketService.delete(bookBasket);
	}
}
