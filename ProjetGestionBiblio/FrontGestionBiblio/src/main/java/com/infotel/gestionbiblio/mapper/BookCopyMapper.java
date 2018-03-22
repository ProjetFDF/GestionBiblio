package com.infotel.gestionbiblio.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.BookCopyDto;
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

		BookCopy bookCopy = new BookCopy();

		bookCopy.setIdBookCopy(bookCopyDto.getIdBookCopy());

		return bookCopy;
	}

	public BookCopyDto bookCopyToDto(BookCopy bookCopy) {
		
		BookCopyDto bookCopyDto = new BookCopyDto(bookCopy.getBookCopyTitle(),bookCopy.getBookshelf().getIdBookshelf(),bookCopy.getBook().getIdBook());
		
		bookCopyDto.setIdBookCopy(bookCopy.getIdBookCopy());
		
		return bookCopyDto;
	}

}
