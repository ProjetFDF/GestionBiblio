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
import com.infotel.gestionbiblio.utils.ControllerConstante;
import com.infotel.gestionbiblio.utils.Resultat;
import com.infotel.gestionbiblio.viewmodel.FiltresMultiplesVM;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	BookMapper bookMapper;

	@PostMapping("/add")
	public Resultat addBook(@RequestBody BookDto bookDto) {

		Resultat result = new Resultat();
		try 
		{
			
			bookService.insert(bookMapper.dtoToBook(bookDto));
			
			result.setPayload(bookDto);
			result.setMessage(ControllerConstante.LIST_SUCCESS);
			result.setSuccess(true);
		}
		catch(Exception e)
		{
			result.setSuccess(false);
			result.setMessage(ControllerConstante.LIST_ERROR);
			e.printStackTrace();
		}
		
		return result;
	}

	@PostMapping("/update")
	public Resultat updateBook(@RequestBody BookDto bookDto) 
	{
		Resultat result = new Resultat();
		try 
		{
			
			bookService.update(bookMapper.dtoToBook(bookDto));
			
			result.setPayload(bookDto);
			result.setMessage(ControllerConstante.LIST_SUCCESS);
			result.setSuccess(true);
		}
		catch(Exception e)
		{
			result.setSuccess(false);
			result.setMessage(ControllerConstante.LIST_ERROR);
			e.printStackTrace();
		}
		
		return result;
	}

	@GetMapping("/getlist")
	public Resultat getBooks() 
	{
		Resultat result = new Resultat();
		
		try 
		{
			List<BookDto> viewBooks = new ArrayList<BookDto>();
			List<Book> books = bookService.getList();
			for (Book book : books) {
				
				viewBooks.add(bookMapper.bookToDto(book));
			}
			
			result.setPayload(viewBooks);
			result.setMessage(ControllerConstante.LIST_SUCCESS);
			result.setSuccess(true);
		}
		catch(Exception e)
		{
			result.setSuccess(false);
			result.setMessage(ControllerConstante.LIST_ERROR);
			e.printStackTrace();
		}
		
		return result;
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
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Resultat getBooksSearch(@RequestBody FiltresMultiplesVM filtres) throws IOException 
	{
		Resultat result = new Resultat();
		try 
		{
			List<Integer> listeAuthorsId = filtres.getAuthorIds();
			List<Integer> listeEditorsId = filtres.getEditorsIds();
			List<Integer> listeCategoriesId = filtres.getCategoryIds();
			boolean recommande = filtres.isRecommande();
			String titlesearch = filtres.getTitre();
			
			List<Book> books = bookService.getList();
			
			if (recommande) {
				books = bookService.getBookRecommandes(books);
			}
	
			if (listeAuthorsId != null && listeAuthorsId.size() > 0) {
				books = bookService.getListLivreAuthorFilter(books, listeAuthorsId);
			}
	
			if (listeEditorsId != null && listeEditorsId.size() > 0) {
				books = bookService.getListLivreEditorFilter(books, listeEditorsId);
			}
	
			if (listeCategoriesId != null && listeCategoriesId.size() > 0) {
				books = bookService.getListLivreCategoryFilter(books, listeCategoriesId);
			}
	
			if (titlesearch != null && !titlesearch.isEmpty()) {
				books = bookService.getListLivreTitreFilter(books, titlesearch);
			}
			
			List<BookDto> booksDto = new ArrayList<BookDto>();
			for(Book book : books)
			{
				booksDto.add(bookMapper.bookToDto(book));
			}
			
			result.setPayload(booksDto);
			result.setMessage(ControllerConstante.LIST_SUCCESS);
			result.setSuccess(true);
		}
		catch(Exception e)
		{
			result.setSuccess(false);
			result.setMessage(ControllerConstante.LIST_ERROR);
			e.printStackTrace();
		}
		
		return result;
	}
}
