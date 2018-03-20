package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.AuthorDto;
import com.infotel.gestionbiblio.entity.Author;
import com.infotel.gestionbiblio.mapper.AuthorMapper;
import com.infotel.gestionbiblio.service.inter.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;

	@Autowired
	AuthorMapper authorMapper;

	@PostMapping("/add")
	public void addAuthor(@RequestBody AuthorDto auhtorDto) {

		authorService.insert(authorMapper.dtoToAuthor(auhtorDto));
	}

	@PostMapping("/update")
	public void updateAuthor(@RequestBody AuthorDto authorDto) 
	{
		authorService.update(authorMapper.dtoToAuthor(authorDto));
	}

	@GetMapping("/getlist")
	public List<AuthorDto> getAuthors() 
	{
		List<AuthorDto> viewAuthors = new ArrayList<AuthorDto>();

		List<Author> authors = authorService.getList();

		for (Author author : authors) {
			
			viewAuthors.add(authorMapper.authorToDto(author));
		}

		return viewAuthors;
	}
	
	@GetMapping("/get")
	public AuthorDto getAuthor(int id) 
	{
		Author author = authorService.getById(id);

		AuthorDto authorDto = authorMapper.authorToDto(author);

		return authorDto;
	}
	
	@GetMapping("/delete")
	public void deleteAuthor(int id) 
	{
		Author author = authorService.getById(id);

		authorService.delete(author);
	}
}
