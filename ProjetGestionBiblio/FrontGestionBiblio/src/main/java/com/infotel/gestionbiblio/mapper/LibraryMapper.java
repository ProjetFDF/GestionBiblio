package com.infotel.gestionbiblio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.LibraryDto;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.entity.Library;
import com.infotel.gestionbiblio.entity.Registration;
import com.infotel.gestionbiblio.service.inter.LibraryService;
import com.infotel.gestionbiblio.service.inter.RegistrationService;

@Component
public class LibraryMapper {
	@Autowired
	LibraryService libraryService;

	@Autowired
	RegistrationService registrationService;



	public Library dtoToLibrary(LibraryDto libraryDto) {
		List<Registration> registrations = new ArrayList<Registration>();
		for (int registrationId : libraryDto.getRegistrations()) {
			registrations.add(registrationService.getById(registrationId));
		}

		List<Book> books = new ArrayList<Book>();
		for (int bookId : libraryDto.getBooks()) {
			registrations.add(registrationService.getById(bookId));
		}
		
		Library library = new Library(libraryDto.getCode(),libraryDto.getName(),libraryDto.getAddress(),registrations,books);

		return library;
	}

	public LibraryDto libraryToDto(Library library) {
		List<Integer> registrationIds = new ArrayList<Integer>();
		for (Registration registration : library.getRegistrations()) {
			registrationIds.add(registration.getIdRegistration());
		}

		List<Integer> bookIds = new ArrayList<Integer>();

		for (Book book : library.getBooks()) {
			bookIds.add(book.getIdBook());
		}
		
		return new LibraryDto(library.getCode(),library.getName(),library.getAddress(),registrationIds,bookIds);
	}


}
