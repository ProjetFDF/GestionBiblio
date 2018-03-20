package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.BookshelfDto;
import com.infotel.gestionbiblio.entity.Bookshelf;
import com.infotel.gestionbiblio.mapper.BookshelfMapper;
import com.infotel.gestionbiblio.service.inter.BookshelfService;

@RestController
@RequestMapping("/bookshelf")
public class BookshelfController {
	
	@Autowired
	BookshelfService bookshelfService;

	@Autowired
	BookshelfMapper bookshelfMapper;

	@PostMapping("/add")
	public void addBookshelf(@RequestBody BookshelfDto bookshelfDto) {

		bookshelfService.insert(bookshelfMapper.dtoToBookshelf(bookshelfDto));
	}

	@PostMapping("/update")
	public void updateBookshelf(@RequestBody BookshelfDto bookshelfDto) 
	{
		bookshelfService.update(bookshelfMapper.dtoToBookshelf(bookshelfDto));
	}

	@GetMapping("/getlist")
	public List<BookshelfDto> getBookshelfs() 
	{
		List<BookshelfDto> viewBookshelfs = new ArrayList<BookshelfDto>();

		List<Bookshelf> bookshelfs = bookshelfService.getList();

		for (Bookshelf bookshelf : bookshelfs) {
			
			viewBookshelfs.add(bookshelfMapper.bookshelfToDto(bookshelf));
		}

		return viewBookshelfs;
	}
	
	@GetMapping("/get")
	public BookshelfDto getBookshelf(int id) 
	{
		Bookshelf bookshelf = bookshelfService.getById(id);

		BookshelfDto bookshelfDto = bookshelfMapper.bookshelfToDto(bookshelf);

		return bookshelfDto;
	}
	
	@GetMapping("/delete")
	public void deleteBookshelf(int id) 
	{
		Bookshelf bookshelf = bookshelfService.getById(id);

		bookshelfService.delete(bookshelf);
	}

}

