package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.service.inter.EditorService;
import com.infotel.gestionbiblio.entity.Editor;

@RestController
@RequestMapping("/editor")
public class EditorController 
{
	@Autowired
	EditorService editorService;


	@PostMapping("/add")
	public void addBook(@RequestBody Editor editor) 
	{
		editorService.insert(editor);			
	}

	@GetMapping("/getlist")
	public List<Editor> getEditors() 
	{
		List<Editor> editors = editorService.getList();

		return editors;
	}
}
