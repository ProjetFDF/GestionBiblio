package com.infotel.gestionbiblio.mapper;

import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.BorrowDto;
import com.infotel.gestionbiblio.entity.Borrow;
import com.infotel.gestionbiblio.service.inter.BookCopyService;
import com.infotel.gestionbiblio.service.inter.BorrowService;

@Component
public class BorowMapper {
	
	BorrowService borrowService;
	
	BookCopyService bookCopyService;

	public Borrow dtoToBorrow(BorrowDto borrowDto) {
		Borrow borrow = new Borrow(borrowDto.getBorrowDate(),borrowDto.getReturnDate(),bookCopyService.getById(borrowDto.getIdBookCopy()));

		return borrow;
	}

	public BorrowDto borrowToDto(Borrow borrow) {

		return new BorrowDto(borrow.getBorrowDate(),borrow.getReturnDate(),borrow.getBookCopy().getIdBookCopy());
	}

}
