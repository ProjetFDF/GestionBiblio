package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.BookDto;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.mapper.BookMapper;
import com.infotel.gestionbiblio.service.inter.AuthorService;
import com.infotel.gestionbiblio.service.inter.BookCopyService;
import com.infotel.gestionbiblio.service.inter.BookService;
import com.infotel.gestionbiblio.service.inter.CategoryService;
import com.infotel.gestionbiblio.service.inter.EditorService;
import com.infotel.gestionbiblio.service.inter.LibraryService;

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
/*	
	@PostMapping("/update")
	public void updateBook(@RequestBody BookDto bookDto) 
	{
		Book book = bookService.getById(bookDto.getIdBook());
		

		book.setEditor(editorService.getById(bookDto.getIdEditor()));
		book.setLibrary(libraryService.getById(bookDto.getIdLibrary()));
		book.setCategory(categoryService.getById(bookDto.getIdCategory()));

		List<Author> authors = new ArrayList<Author>();
		for (int authorId : bookDto.getIdAuthor()) {
			authors.add(authorService.getById(authorId));
		}
		book.setAuthor(authors);

		List<BookCopy> bookCopies = new ArrayList<BookCopy>();
		for (int bookCopiesId : bookDto.getIdBookCopy()) 
		{
			bookCopies.add(bookCopyService.getById(bookCopiesId));
		}
		book.setBookCopy(bookCopies);
		
		bookService.update(book);
	}
*/
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
}
