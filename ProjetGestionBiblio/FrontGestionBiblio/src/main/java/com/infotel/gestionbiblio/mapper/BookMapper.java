package com.infotel.gestionbiblio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.BookDto;
import com.infotel.gestionbiblio.entity.Author;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.entity.BookCopy;
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

    public Book dtoToBook(BookDto bookDto) 
    {
		List<Author> authors = new ArrayList<Author>();
		for (int authorId : bookDto.getIdAuthor()) {
			authors.add(authorService.getById(authorId));
		}


		List<BookCopy> bookCopies = new ArrayList<BookCopy>();
		for (int bookCopiesId : bookDto.getIdBookCopy()) 
		{
			bookCopies.add(bookCopyService.getById(bookCopiesId));
		}
    	
		Book book = new Book(bookDto.getISBN(), bookDto.getBookTitre(), bookDto.getBookDescription(),
				bookDto.getImagePath(), bookDto.isPopularBook(), bookDto.isPeriodicBook(), bookDto.getBookPrice(),
				bookDto.getPublicationDate(),categoryService.getById(bookDto.getIdCategory()),editorService.getById(bookDto.getIdEditor()),bookCopies,authors,libraryService.getById(bookDto.getIdLibrary()));

		book.setEditor(editorService.getById(bookDto.getIdEditor()));
		book.setLibrary(libraryService.getById(bookDto.getIdLibrary()));
		book.setCategory(categoryService.getById(bookDto.getIdCategory()));

        return book;
    }
    
    public BookDto bookToDto(Book book)
    {
			List<Integer> auhtorIds = new ArrayList<Integer>();

			for (Author author : book.getAuthor()) 
			{
				auhtorIds.add(author.getAuthorId());
			}

			List<Integer> bookCopies = new ArrayList<Integer>();

			for (BookCopy bookCopy : book.getBookCopy()) 
			{
				bookCopies.add(bookCopy.getIdBookCopy());
			}
			
    	return new BookDto(book.getISBN(), book.getBookTitre(), book.getBookDescription(),
				book.getImagePath(), book.isPopularBook(), book.isPeriodicBook(), book.getBookPrice(),
				book.getPublicationDate(), book.getCategory().getCategoryId(), book.getEditor().getEditorId(),
				book.getLibrary().getIdLibrary(), bookCopies, auhtorIds);
    }
    
}