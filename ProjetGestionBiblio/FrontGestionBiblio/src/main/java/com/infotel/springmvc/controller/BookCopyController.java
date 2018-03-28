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

import com.infotel.gestionbiblio.dto.AuthorDto;
import com.infotel.gestionbiblio.dto.BookCopyDto;
import com.infotel.gestionbiblio.dto.BookDto;
import com.infotel.gestionbiblio.entity.Author;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.entity.BookCopy;
import com.infotel.gestionbiblio.mapper.BookCopyMapper;
import com.infotel.gestionbiblio.mapper.BookMapper;
import com.infotel.gestionbiblio.service.inter.BookCopyService;
import com.infotel.gestionbiblio.service.inter.BookService;
import com.infotel.gestionbiblio.utils.ControllerConstante;
import com.infotel.gestionbiblio.utils.Resultat;

@RestController
@RequestMapping("/bookCopy")
public class BookCopyController 
{
	@Autowired
	BookCopyService bookCopyService;

	
	@Autowired
	BookCopyMapper bookCopyMapper;
	
	@Autowired
	BookMapper bookMapper;

	@PostMapping("/add")
	public void addBookCopy(@RequestBody BookCopyDto bookCopyDto) {

		bookCopyService.insert(bookCopyMapper.dtoToBookCopy(bookCopyDto));
	}

	@PostMapping("/update")
	public void updateBookCopy(@RequestBody BookCopyDto bookCopyDto) 
	{
		bookCopyService.update(bookCopyMapper.dtoToBookCopy(bookCopyDto));
	}

	@GetMapping("/getlist")
	public List<BookCopyDto> getBookCopys() 
	{
		List<BookCopyDto> viewBookCopys = new ArrayList<BookCopyDto>();

		List<BookCopy> bookCopys = bookCopyService.getList();

		for (BookCopy bookCopy : bookCopys) {
			
			viewBookCopys.add(bookCopyMapper.bookCopyToDto(bookCopy));
		}

		return viewBookCopys;
	}
	
	@GetMapping("/get")
	public BookCopyDto getBookCopy(int id) 
	{
		BookCopy bookCopy = bookCopyService.getById(id);

		BookCopyDto bookCopyDto = bookCopyMapper.bookCopyToDto(bookCopy);

		return bookCopyDto;
	}
	
	@PostMapping("/getbookbyidcopy")
	public Resultat getListAuthorByBookId(@RequestBody BookCopyDto bookCopyDto) 
	{
		Resultat result = new Resultat();
		
		try 
		{
			BookCopy bookCopy = bookCopyService.getById(bookCopyDto.getIdBookCopy());
			
			
			result.setPayload(bookMapper.bookToDto(bookCopy.getBook()));
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
	
	
	@GetMapping("/delete")
	public void deleteBookCopy(int id) 
	{
		BookCopy bookCopy = bookCopyService.getById(id);

		bookCopyService.delete(bookCopy);
	}
}
