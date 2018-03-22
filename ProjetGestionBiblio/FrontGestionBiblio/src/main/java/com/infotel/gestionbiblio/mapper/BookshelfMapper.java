package com.infotel.gestionbiblio.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.BookshelfDto;
import com.infotel.gestionbiblio.entity.Bookshelf;
import com.infotel.gestionbiblio.service.inter.BookCopyService;
import com.infotel.gestionbiblio.service.inter.BookshelfService;


@Component
public class BookshelfMapper {

	@Autowired
	BookshelfService bookshelfService;

	@Autowired
	BookCopyService bookCopyService;

	public Bookshelf dtoToBookshelf(BookshelfDto bookshelfDto) {

		Bookshelf bookshelf = new Bookshelf();

		bookshelf.setIdBookshelf(bookshelfDto.getIdBookshelf());

		return bookshelf;
	}

	public BookshelfDto bookshelfToDto(Bookshelf bookshelf) {

		BookshelfDto bookshelfDto = new BookshelfDto(bookshelf.getName(),bookshelf.getDescription(),bookshelf.getBookNumber());

		bookshelfDto.setIdBookshelf(bookshelf.getIdBookshelf());
		
		return bookshelfDto;
	}
}
