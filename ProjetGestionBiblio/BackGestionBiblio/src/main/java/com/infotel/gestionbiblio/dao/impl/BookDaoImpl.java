package com.infotel.gestionbiblio.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
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

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Book getObjectByName(String nom) 
	{
		Query query= getSession().
		        createQuery("from Book where bookTitre=:name");
		query.setParameter("name", nom);
		Book book = (Book) query.uniqueResult();
		
		return book;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Book> getList()
	{		
		
		Session session = getSession();
		Criteria crit = session.createCriteria(Book.class).setMaxResults(200);
		List<Book> bookList = crit.list();
		
	
		for (Book book : bookList) {
		Hibernate.initialize(book.getAuthors());
	
	}
		return bookList;
	}
	

	

}
 