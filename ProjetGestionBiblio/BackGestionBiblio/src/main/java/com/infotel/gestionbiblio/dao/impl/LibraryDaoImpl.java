package com.infotel.gestionbiblio.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gestionbiblio.dao.inter.LibraryDao;
import com.infotel.gestionbiblio.entity.Library;

@Repository
@Transactional
public class LibraryDaoImpl extends CommonDaoImpl<Library> implements LibraryDao {

	Library library;
	List<Library> libraryList;
	
	@Autowired
	private SessionFactory sessionFactory;


	
	@Override
	public Library getObjectByName(String nom) 
	{
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from Library where name=:name");
		query.setParameter("name", nom);
		library = (Library) query.uniqueResult();
		
		return library;
	}
	
	@Override
	public List<Library> getList()
	{
		libraryList = super.getList();
		return libraryList;
	}

}
 