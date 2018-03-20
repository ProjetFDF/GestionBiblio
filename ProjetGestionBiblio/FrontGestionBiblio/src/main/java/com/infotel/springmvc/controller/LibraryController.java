package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.infotel.gestionbiblio.entity.Library;

import com.infotel.gestionbiblio.service.inter.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	@Autowired
    LibraryService libraryService;
    
    @PostMapping("/add")
    public void addLibrary(@RequestBody Library library) 
    {
    	libraryService.insert(library);            
    }

    @GetMapping("/getlist")
    public List<Library> getLibrarys() 
    {
        List<Library> librarys = libraryService.getList();

        return librarys;
    }
}
