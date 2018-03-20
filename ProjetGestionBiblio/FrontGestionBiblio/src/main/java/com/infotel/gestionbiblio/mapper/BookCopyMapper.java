package com.infotel.gestionbiblio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.BookCopyDto;
import com.infotel.gestionbiblio.entity.BookBasket;
import com.infotel.gestionbiblio.entity.BookCopy;
import com.infotel.gestionbiblio.service.inter.BookBasketService;
import com.infotel.gestionbiblio.service.inter.BookCopyService;



@Component
public class BookCopyMapper {

	@Autowired
	BookCopyService bookCopyService;

	@Autowired
	BookBasketService bookBasketService;


	public BookCopy dtoToBookCopy(BookCopyDto bookCopyDto) {
		List<BookBasket> bookBaskets = new ArrayList<BookBasket>();
		for (int bookBasketId : bookCopyDto.getBookBaskets()) {
			bookBaskets.add(bookBasketService.getById(bookBasketId));
		}


		BookCopy bookCopy = new BookCopy();


		return bookCopy;
	}

	public BookCopyDto bookCopyToDto(BookCopy bookCopy) {
		List<Integer> bookBasketIds = new ArrayList<Integer>();

		for (BookBasket bookBasket : bookCopy.getBookBaskets()) {
			bookBasketIds.add(bookBasket.getIdBookBasket());
		}

		return new BookCopyDto();
	}

}
