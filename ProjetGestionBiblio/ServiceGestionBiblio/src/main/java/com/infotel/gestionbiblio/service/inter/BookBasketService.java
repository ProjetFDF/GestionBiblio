 package com.infotel.gestionbiblio.service.inter;


import java.util.List;

import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.entity.BookBasket;

public interface BookBasketService {
	public void insert(final BookBasket monObjet);
	public void delete(final BookBasket object);
	public void update(final BookBasket object);
	public BookBasket getById(int id);
	public BookBasket getObjectByName(String nom) ;
	public List<BookBasket> getList();
	public List<Book> getListByIdMember(int memberId);
}
