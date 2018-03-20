package com.infotel.gestionbiblio.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gestionbiblio.dao.inter.BookDao;
import com.infotel.gestionbiblio.entity.Book;

@Repository
@Transactional
public class BookDaoImpl extends CommonDaoImpl<Book> implements BookDao {

	Book book;
	List<Book> bookList;
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Book getObjectByName(String nom) 
	{
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from Book where bookTitre=:name");
		query.setParameter("name", nom);
		book = (Book) query.uniqueResult();
		
		return book;
	}
	
	@Override
	public List<Book> getList()
	{		
		bookList = super.getList();
	
		for (Book book : bookList) {
		Hibernate.initialize(book.getAuthors());
	
	}
		return bookList;
	}
	

	

}
 