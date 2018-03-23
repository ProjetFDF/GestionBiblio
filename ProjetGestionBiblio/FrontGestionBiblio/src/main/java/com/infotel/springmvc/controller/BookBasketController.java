package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.BookBasketDto;
import com.infotel.gestionbiblio.dto.BookDto;
import com.infotel.gestionbiblio.dto.MemberDto;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.entity.BookBasket;
import com.infotel.gestionbiblio.entity.BookCopy;
import com.infotel.gestionbiblio.mapper.BookBasketMapper;
import com.infotel.gestionbiblio.mapper.MemberMapper;
import com.infotel.gestionbiblio.service.inter.BookBasketService;
import com.infotel.gestionbiblio.service.inter.BookCopyService;
import com.infotel.gestionbiblio.service.inter.BookService;
import com.infotel.gestionbiblio.service.inter.MemberService;
import com.infotel.gestionbiblio.utils.ControllerConstante;
import com.infotel.gestionbiblio.utils.Resultat;
import com.infotel.gestionbiblio.viewmodel.BookBasketFull;

@RestController
@RequestMapping("/bookbasket")
public class BookBasketController 
{
	@Autowired
	BookBasketService bookBasketService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BookCopyService bookCopyService;
	
	@Autowired
	BookBasketMapper bookBasketMapper;
	
	@Autowired
	MemberMapper memberMapper;

	@PostMapping("/add")
	public void addBookBasket(@RequestBody BookBasketDto bookDto) {

		bookBasketService.insert(bookBasketMapper.dtoToBookBasket(bookDto));
	}

	@PostMapping("/update")
	public void updateBookBasket(@RequestBody BookBasketDto bookDto) 
	{
		bookBasketService.update(bookBasketMapper.dtoToBookBasket(bookDto));
	}

	@GetMapping("/getlist")
	public List<BookBasketDto> getBookBaskets() 
	{
		List<BookBasketDto> viewBooks = new ArrayList<BookBasketDto>();

		List<BookBasket> bookBaskets = bookBasketService.getList();

		for (BookBasket bookBasket : bookBaskets) {
			
			viewBooks.add(bookBasketMapper.bookBasketToDto(bookBasket));
		}

		return viewBooks;
	}
	
	@PostMapping("/getlistbyidmember")
	public Resultat getBookBasketsByMember(@RequestBody int memberId) 
	{
		Resultat result = new Resultat();
		
		List<BookBasket> viewBookBaskets = new ArrayList<BookBasket>();
		List<BookBasketFull> bookbasketsFull = new ArrayList<BookBasketFull>();
		
		try 
		{
			viewBookBaskets = bookBasketService.getListByIdMember(memberId);
			
			int i =0;
			
			for(BookBasket bookbasket : viewBookBaskets )
			{
				bookbasketsFull.add(new BookBasketFull());
				bookbasketsFull.get(i).setBookBasket(bookbasket);
				bookbasketsFull.get(i).setBook(bookCopyService.getById(bookbasket.getBookCopy().getIdBookCopy()).getBook());
				bookbasketsFull.get(i).setMemberId(memberId);
				i++;
			}

			result.setPayload(bookbasketsFull);
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
	public BookBasketDto getBookBasket(int id) 
	{
		BookBasket bookBasket = bookBasketService.getById(id);

		BookBasketDto bookBasketDto = bookBasketMapper.bookBasketToDto(bookBasket);

		return bookBasketDto;
	}
	
	@GetMapping("/delete")
	public void deleteBookBasket(int id) 
	{
		BookBasket bookBasket = bookBasketService.getById(id);

		bookBasketService.delete(bookBasket);
	}
}
