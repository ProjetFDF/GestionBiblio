package com.infotel.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.BookDto;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.mapper.BookMapper;
import com.infotel.gestionbiblio.service.inter.BookService;
import com.infotel.gestionbiblio.utils.Resultat;

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
	
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public void getImageAsByteArray(@RequestParam String imagePath, HttpServletResponse response, HttpServletRequest request) throws IOException {
	    InputStream in = request.getServletContext().getResourceAsStream("/static/img/"+imagePath);
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}
	
/*	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Resultat getBookRecommanded(@RequestParam boolean recomande, HttpServletResponse response, HttpServletRequest request) throws IOException 
	{
		Resultat result = new Resultat();
		
		String[] listeAuthorsId = request.getParameterValues("authorsId");
		String[] listeEditorsId = request.getParameterValues("editorsId");
		String[] listeCategoriesId = request.getParameterValues("categoriesId");
		String titlesearch = request.getParameter("titleSearch");

		if (listeAuthorsId != null && listeAuthorsId.length > 0) {
			books = bookService.getListLivreAuthorFilter(books, listeAuthorsId);
		}

		if (listeEditorsId != null && listeEditorsId.length > 0) {
			books = bookService.getListLivreEditorFilter(books, listeEditorsId);
		}

		if (listeCategoriesId != null && listeCategoriesId.length > 0) {
			books = bookService.getListLivreCategoryFilter(books, listeCategoriesId);
		}

		if (titlesearch != null && !titlesearch.isEmpty()) {
			books = bookService.getListLivreTitreFilter(books, titlesearch);
		}

		model.addAttribute("books", books);
		
		return result;
	}*/
}
