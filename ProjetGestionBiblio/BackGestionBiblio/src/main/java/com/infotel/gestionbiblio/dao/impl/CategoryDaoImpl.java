package com.infotel.gestionbiblio.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gestionbiblio.dao.inter.CategoryDao;
import com.infotel.gestionbiblio.entity.Category;

@Repository
@Transactional
public class CategoryDaoImpl extends CommonDaoImpl<Category> implements CategoryDao {

	Category category;
	List<Category> categoryList;
	
	@Autowired
	private SessionFactory sessionFactory;


	
	@Override
	public Category getObjectByName(String nom) 
	{
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from Category where name=:name");
		query.setParameter("name", nom);
		category = (Category) query.uniqueResult();
		
		return category;
	}
	
	@Override
	public List<Category> getList()
	{
		categoryList = super.getList();
		return categoryList;
	}

}
 