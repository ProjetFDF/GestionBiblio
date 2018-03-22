package com.infotel.gestionbiblio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.BookBasketDto;
import com.infotel.gestionbiblio.entity.BookBasket;
import com.infotel.gestionbiblio.entity.BookCopy;
import com.infotel.gestionbiblio.service.inter.BookBasketService;
import com.infotel.gestionbiblio.service.inter.BookCopyService;

@Component
public class BookBasketMapper {

	@Autowired
	BookCopyService bookCopyService;
	
	@Autowired
	BookBasketService bookBasketService;
	
	public BookBasket dtoToBookBasket(BookBasketDto bookBasketDto) {

		BookBasket bookBasket = new BookBasket(bookBasketDto.getCreationDate(),bookBasketDto.getDeliveryDate(),bookCopyService.getById(bookBasketDto.getBookCopyId()));

		bookBasket.setIdBookBasket(bookBasketDto.getIdBookBasket());
		
		return bookBasket;
	}

	public BookBasketDto bookBasketToDto(BookBasket bookBasket) {
	
	
		BookBasketDto bookBasketDto = new BookBasketDto(bookBasket.getCreationDate(),bookBasket.getDeliveryDate(),bookBasket.getBookCopy().getIdBookCopy());

		bookBasketDto.setIdBookBasket(bookBasket.getIdBookBasket());
		
		return bookBasketDto;
	}
}
