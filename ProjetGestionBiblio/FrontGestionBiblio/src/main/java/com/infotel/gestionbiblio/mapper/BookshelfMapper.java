package com.infotel.gestionbiblio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.BookshelfDto;
import com.infotel.gestionbiblio.entity.BookCopy;
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
		List<BookCopy> bookCopys = new ArrayList<BookCopy>();
		for (int bookCopyId : bookshelfDto.getBookCopyIds()) {
			bookCopys.add(bookCopyService.getById(bookCopyId));
		}


		Bookshelf bookshelf = new Bookshelf();


		return bookshelf;
	}

	public BookshelfDto bookshelfToDto(Bookshelf bookshelf) {
		List<Integer> bookCopyIds = new ArrayList<Integer>();

		for (BookCopy bookCopy : bookshelf.getBookshelfBookCopys()) {
			bookCopyIds.add(bookCopy.getIdBookCopy());
		}

		return new BookshelfDto();
	}
}
