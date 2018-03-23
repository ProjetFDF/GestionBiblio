package com.infotel.gestionbiblio.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.EditorDto;
import com.infotel.gestionbiblio.entity.Editor;
import com.infotel.gestionbiblio.service.inter.EditorService;



@Component
public class EditorMapper {
	
	@Autowired
	EditorService editorService;
	


	public Editor dtoToEditor(EditorDto editorDto) {
		
		Editor editor = new Editor(editorDto.getName(),editorDto.getAddress());

		editor.setIdEditor(editorDto.getIdEditor());

		return editor;
	}

	public EditorDto editorToDto(Editor editor) {

		EditorDto editorDto = new EditorDto(editor.getName(),editor.getAddress());
		
		editorDto.setIdEditor(editor.getIdEditor());
		
		return editorDto;
	}

}
