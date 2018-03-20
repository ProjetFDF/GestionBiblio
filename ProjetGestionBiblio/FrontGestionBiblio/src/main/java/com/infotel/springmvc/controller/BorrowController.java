package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.infotel.gestionbiblio.entity.Borrow;

import com.infotel.gestionbiblio.service.inter.BorrowService;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
	@Autowired
    BorrowService borrowService;
    
    @PostMapping("/add")
    public void addBorrow(@RequestBody Borrow borrow) 
    {
        borrowService.insert(borrow);            
    }

    @GetMapping("/getlist")
    public List<Borrow> getBorrows() 
    {
        List<Borrow> borrows = borrowService.getList();

        return borrows;
    }
}
