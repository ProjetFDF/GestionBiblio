package com.infotel.gestionbiblio.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gestionbiblio.dao.inter.BookshelfDao;
import com.infotel.gestionbiblio.entity.Bookshelf;

@Repository
@Transactional
public class BookshelfDaoImpl extends CommonDaoImpl<Bookshelf> implements BookshelfDao {

	Bookshelf bookshelf;
	List<Bookshelf> bookshelfList;
	
	@Autowired
	private SessionFactory sessionFactory;


	
	@Override
	public Bookshelf getObjectByName(String nom) 
	{
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from Bookshelf where name=:name");
		query.setParameter("name", nom);
		bookshelf = (Bookshelf) query.uniqueResult();
		
		return bookshelf;
	}
	
	@Override
	public List<Bookshelf> getList()
	{
		bookshelfList = super.getList();
		return bookshelfList;
	}

}
 