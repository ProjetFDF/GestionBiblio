 package com.infotel.gestionbiblio.service.inter;

import java.util.List;

import com.infotel.gestionbiblio.entity.Book;

public interface BookService {

	public List<Book> getBookRecommandes(List<Book> listBook); 
	public List<Book> getPeriodique(List<Book> listBook); 
	public List<Book> getBookByRecherche(List<Book> listBook, String recherche); 
	
	public void insert(final Book monObjet);
	public void delete(final Book object);
	public void update(final Book object);
	public Book getById(int id);
	public Book getObjectByName(String nom) ;
	public List<Book> getList();

	public List<Book> getListLivreTitreFilter(List<Book> listBook, String titre);
	public List<Book> getListLivreAuthorFilter(List<Book> listBook, List<Integer> listeAuthorsId);
	public List<Book> getListLivreCategoryFilter(List<Book> listBook, List<Integer> listeIdCategory);
	public List<Book> getListLivreEditorFilter(List<Book> listBook, List<Integer> listeIdEditor);
	
	public int getNbBookDispo();
	public boolean bookIsDispo();
	public int getIdBookDispo();
}
