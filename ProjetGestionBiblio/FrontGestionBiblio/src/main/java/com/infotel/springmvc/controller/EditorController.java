package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.service.inter.EditorService;
import com.infotel.gestionbiblio.dto.EditorDto;
import com.infotel.gestionbiblio.entity.Editor;
import com.infotel.gestionbiblio.mapper.EditorMapper;

@RestController
@RequestMapping("/editor")
public class EditorController 
{
	@Autowired
	EditorService editorService;

	@Autowired
	EditorMapper editorMapper;

	@PostMapping("/add")
	public void addEditor(@RequestBody EditorDto editorDto) {

		editorService.insert(editorMapper.dtoToEditor(editorDto));
	}

	@PostMapping("/update")
	public void updateEditor(@RequestBody EditorDto editorDto) 
	{
		editorService.update(editorMapper.dtoToEditor(editorDto));
	}

	@GetMapping("/getlist")
	public List<EditorDto> getEditors() 
	{
		List<EditorDto> viewEditors = new ArrayList<EditorDto>();

		List<Editor> editors = editorService.getList();

		for (Editor editor : editors) {
			
			viewEditors.add(editorMapper.editorToDto(editor));
		}

		return viewEditors;
	}
	
	@GetMapping("/get")
	public EditorDto getEditor(int id) 
	{
		Editor editor = editorService.getById(id);

		EditorDto editorDto = editorMapper.editorToDto(editor);

		return editorDto;
	}
	
	@GetMapping("/delete")
	public void deleteEditor(int id) 
	{
		Editor editor = editorService.getById(id);

		editorService.delete(editor);
	}

}
