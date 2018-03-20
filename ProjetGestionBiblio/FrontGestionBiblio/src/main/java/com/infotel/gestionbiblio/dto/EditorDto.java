package com.infotel.gestionbiblio.dto;

import java.util.List;


public class EditorDto {
	private int editorId;
	private String editorName; 
	private String editorAddress;
	private List<Integer> bookEditor;
	
	public EditorDto() {
		// TODO Auto-generated constructor stub
	}

	public EditorDto(String editorName, String editorAddress, List<Integer> bookEditor) {
		this.editorName = editorName;
		this.editorAddress = editorAddress;
		this.bookEditor = bookEditor;
	}

	public EditorDto(String editorName, String editorAddress) {
		this.editorName = editorName;
		this.editorAddress = editorAddress;
	}

	public int getEditorId() {
		return editorId;
	}

	public void setEditorId(int editorId) {
		this.editorId = editorId;
	}

	public String getEditorName() {
		return editorName;
	}

	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

	public String getEditorAddress() {
		return editorAddress;
	}

	public void setEditorAddress(String editorAddress) {
		this.editorAddress = editorAddress;
	}

	public List<Integer> getBookEditor() {
		return bookEditor;
	}

	public void setBookEditor(List<Integer> bookEditor) {
		this.bookEditor = bookEditor;
	}
	
	
	
}
