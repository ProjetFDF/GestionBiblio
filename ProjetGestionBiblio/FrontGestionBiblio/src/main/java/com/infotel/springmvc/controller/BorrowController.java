package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.BookDto;
import com.infotel.gestionbiblio.dto.BorrowDto;
import com.infotel.gestionbiblio.entity.Book;
import com.infotel.gestionbiblio.entity.Borrow;
import com.infotel.gestionbiblio.mapper.BorowMapper;
import com.infotel.gestionbiblio.service.inter.BorrowService;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
	
	@Autowired
    BorrowService borrowService;
	
	@Autowired
	BorowMapper borrowMapper;
    
    @PostMapping("/add")
    public void addBorrow(@RequestBody BorrowDto borrowDto) 
    {
        borrowService.insert(borrowMapper.dtoToBorrow(borrowDto));            
    }
    
    @PostMapping("/update")
    public void updateBorrow(@RequestBody BorrowDto borrowDto) 
    {
        borrowService.update(borrowMapper.dtoToBorrow(borrowDto));            
    }

    @GetMapping("/getlist")
    public List<BorrowDto> getBorrows() 
    {
        List<Borrow> borrows = borrowService.getList();
        
		List<BorrowDto> viewBorrows = new ArrayList<BorrowDto>();


		for (Borrow borrow : borrows) {
			
			viewBorrows.add(borrowMapper.borrowToDto(borrow));
		}

		return viewBorrows;
    }
    
	@GetMapping("/get")
	public BorrowDto getBorrow(int id) 
	{
		Borrow borrow = borrowService.getById(id);

		BorrowDto borrowDto = borrowMapper.borrowToDto(borrow);

		return borrowDto;
	}
	
	@GetMapping("/delete")
	public void deleteBook(int id) 
	{
		Borrow borrow = borrowService.getById(id);

		borrowService.delete(borrow);
	}
}
