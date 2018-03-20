package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.BookDto;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.mapper.BookMapper;
import com.infotel.gestionbiblio.service.inter.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	BookMapper bookMapper;

	@PostMapping("/add")
	public void addBook(@RequestBody BookDto bookDto) {

		bookService.insert(bookMapper.dtoToBook(bookDto));
	}

	@PostMapping("/update")
	public void updateBook(@RequestBody BookDto bookDto) 
	{
		bookService.update(bookMapper.dtoToBook(bookDto));
	}

	@GetMapping("/getlist")
	public List<BookDto> getBooks() 
	{
		List<BookDto> viewBooks = new ArrayList<BookDto>();

		List<Book> books = bookService.getList();

		for (Book book : books) {
			
			viewBooks.add(bookMapper.bookToDto(book));
		}

		return viewBooks;
	}
	
	@GetMapping("/get")
	public BookDto getBook(int id) 
	{
		Book book = bookService.getById(id);

		BookDto bookDto = bookMapper.bookToDto(book);

		return bookDto;
	}
	
	@GetMapping("/delete")
	public void deleteBook(int id) 
	{
		Book book = bookService.getById(id);

		bookService.delete(book);
	}
}
