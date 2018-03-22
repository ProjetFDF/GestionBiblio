package com.infotel.gestionbiblio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.BookDto;
import com.infotel.gestionbiblio.entity.Author;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.service.inter.AuthorService;
import com.infotel.gestionbiblio.service.inter.BookCopyService;
import com.infotel.gestionbiblio.service.inter.BookService;
import com.infotel.gestionbiblio.service.inter.CategoryService;
import com.infotel.gestionbiblio.service.inter.EditorService;
import com.infotel.gestionbiblio.service.inter.LibraryService;

@Component
public class BookMapper {

	@Autowired
	BookService bookService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	EditorService editorService;

	@Autowired
	LibraryService libraryService;

	@Autowired
	AuthorService authorService;

	@Autowired
	BookCopyService bookCopyService;

	public Book dtoToBook(BookDto bookDto) {
		List<Author> authors = new ArrayList<Author>();
		for (int authorId : bookDto.getAuthorIds()) {
			authors.add(authorService.getById(authorId));
		}

		Book book = new Book(bookDto.getISBN(), bookDto.getBookTitre(), bookDto.getBookDescription(),
				bookDto.getImagePath(), bookDto.isPopularBook(), bookDto.isPeriodicBook(), bookDto.getBookPrice(),
				bookDto.getPublicationDate());

		book.setEditor(editorService.getById(bookDto.getIdEditor()));
		book.setCategory(categoryService.getById(bookDto.getIdCategory()));
		book.setAuthors(authors);
		
		book.setIdBook(bookDto.getIdBook());

		return book;
	}

	public BookDto bookToDto(Book book) {
		List<Integer> auhtorIds = new ArrayList<Integer>();

		for (Author author : book.getAuthors()) {
			auhtorIds.add(author.getAuthorId());
		}
		
		BookDto bookDto = new BookDto(book.getISBN(), book.getBookTitre(), book.getBookDescription(), book.getImagePath(),
				book.isPopularBook(), book.isPeriodicBook(), book.getBookPrice(), book.getPublicationDate(),
				book.getCategory().getIdCategory(), book.getEditor().getIdEditor(),auhtorIds);

		bookDto.setIdBook(book.getIdBook());
		
		return bookDto;
	}

}