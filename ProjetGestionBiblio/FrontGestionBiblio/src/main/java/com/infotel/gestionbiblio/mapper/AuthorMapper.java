package com.infotel.gestionbiblio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.AuthorDto;
import com.infotel.gestionbiblio.entity.Author;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.service.inter.AuthorService;
import com.infotel.gestionbiblio.service.inter.BookService;

@Component
public class AuthorMapper {
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	BookService bookService;
	
	public Author dtoToAuthor(AuthorDto authorDto) {
		
		List<Book> books = new ArrayList<Book>();
		for (int bookId : authorDto.getBookIds()) {
			books.add(bookService.getById(bookId));
		}

		Author author = new Author(authorDto.getAuthorLastname(),authorDto.getAuthorFirstname(),books);
		
		author.setAuthorId(authorDto.getAuthorId());

		return author;
	}

	public AuthorDto authorToDto(Author author) {
		
		List<Integer> bookIds = new ArrayList<Integer>();

		for (Book book : author.getBooks()) {
			bookIds.add(book.getIdBook());
		}
		
		AuthorDto authorDto = new AuthorDto(author.getAuthorLastname(), author.getAuthorFirstname(), bookIds);
		
		authorDto.setAuthorId(author.getAuthorId());

		return authorDto;
	}
	
}
