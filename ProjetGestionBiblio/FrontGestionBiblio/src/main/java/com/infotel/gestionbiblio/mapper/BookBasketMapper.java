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
	
	public BookBasket dtoToBook(BookBasketDto bookBasketDto) {
		List<BookCopy> bookCopys = new ArrayList<BookCopy>();
		for (int bookCopyId : bookBasketDto.getBookCopyIds()) {
			bookCopys.add(bookCopyService.getById(bookCopyId));
		}

		BookBasket bookBasket = new BookBasket(bookBasketDto.getCreationDate(),bookBasketDto.getDeliveryDate(),bookCopys);

		return bookBasket;
	}

	public BookBasketDto bookToDto(BookBasket bookBasket) {
	
		List<Integer> bookCopysIds = new ArrayList<Integer>();

		for (BookCopy bookCopy : bookBasket.getBookCopys()) {
			bookCopysIds.add(bookCopy.getIdBookCopy());
		}

		return new BookBasketDto(bookBasket.getCreationDate(),bookBasket.getDeliveryDate(),bookCopysIds);
	}
}
