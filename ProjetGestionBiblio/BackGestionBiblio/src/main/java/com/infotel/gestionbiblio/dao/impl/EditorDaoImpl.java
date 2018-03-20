package com.infotel.gestionbiblio.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gestionbiblio.dao.inter.EditorDao;
import com.infotel.gestionbiblio.entity.Editor;

@Repository
@Transactional
public class EditorDaoImpl extends CommonDaoImpl<Editor> implements EditorDao {

	Editor editor;
	List<Editor> editorList;
	
	@Autowired
	private SessionFactory sessionFactory;


	
	@Override
	public Editor getObjectByName(String nom) 
	{
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from Editor where name=:name");
		query.setParameter("name", nom);
		editor = (Editor) query.uniqueResult();
		
		return editor;
	}
	
	@Override
	public List<Editor> getList()
	{
		editorList = super.getList();
		return editorList;
	}

}
 