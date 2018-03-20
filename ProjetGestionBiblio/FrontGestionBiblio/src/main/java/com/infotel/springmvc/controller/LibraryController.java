package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.LibraryDto;
import com.infotel.gestionbiblio.entity.Library;
import com.infotel.gestionbiblio.mapper.LibraryMapper;
import com.infotel.gestionbiblio.service.inter.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@Autowired
	LibraryMapper libraryMapper;

	@PostMapping("/add")
	public void addLibrary(@RequestBody LibraryDto libraryDto) {

		libraryService.insert(libraryMapper.dtoToLibrary(libraryDto));
	}

	@PostMapping("/update")
	public void updateLibrary(@RequestBody LibraryDto libraryDto) 
	{
		libraryService.update(libraryMapper.dtoToLibrary(libraryDto));
	}

	@GetMapping("/getlist")
	public List<LibraryDto> getLibrarys() 
	{
		List<LibraryDto> viewLibrarys = new ArrayList<LibraryDto>();

		List<Library> librarys = libraryService.getList();

		for (Library library : librarys) {
			
			viewLibrarys.add(libraryMapper.libraryToDto(library));
		}

		return viewLibrarys;
	}
	
	@GetMapping("/get")
	public LibraryDto getLibrary(int id) 
	{
		Library library = libraryService.getById(id);

		LibraryDto libraryDto = libraryMapper.libraryToDto(library);

		return libraryDto;
	}
	
	@GetMapping("/delete")
	public void deleteLibrary(int id) 
	{
		Library library = libraryService.getById(id);

		libraryService.delete(library);
	}

}
