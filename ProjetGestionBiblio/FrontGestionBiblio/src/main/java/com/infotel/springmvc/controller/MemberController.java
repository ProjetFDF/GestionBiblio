package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.MemberDto;
import com.infotel.gestionbiblio.entity.BookBasket;
import com.infotel.gestionbiblio.entity.Member;
import com.infotel.gestionbiblio.entity.Borrow;
import com.infotel.gestionbiblio.exception.ServiceException;
import com.infotel.gestionbiblio.service.inter.BookBasketService;
import com.infotel.gestionbiblio.service.inter.BorrowService;
import com.infotel.gestionbiblio.service.inter.MemberService;
import com.infotel.gestionbiblio.service.inter.RegistrationService;
import com.infotel.gestionbiblio.utils.ControllerConstante;
import com.infotel.gestionbiblio.utils.Resultat;
import com.infotel.gestionbiblio.viewmodel.IndentifiantsVM;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
    MemberService memberService;
	
	@Autowired
	BookBasketService bookBasketService;
	
	@Autowired
	BorrowService borrowService;
	
	@Autowired
	RegistrationService registrationDto;
    
    @PostMapping("/add")
    public void addMember(@RequestBody MemberDto memberDto) 
    {

		Member member = new Member(memberDto.getMemberLastname(),memberDto.getMemberFirstname(),memberDto.getMemberEmail(),memberDto.getMemberPassword(),memberDto.getMemberAddress(),memberDto.getMemberCity(),memberDto.getMemberPostalCode(),memberDto.getMemberPhone());


		List<BookBasket> bookBaskets = new ArrayList<BookBasket>();
		for (int bookBasketId : memberDto.getBookBasketsIds()) {
			bookBaskets.add(bookBasketService.getById(bookBasketId));
		}
		member.setBookBasket(bookBaskets);

		List<Borrow> borrows = new ArrayList<Borrow>();
		for (int borrowId : memberDto.getBorrowsIds()) {
			borrows.add(borrowService.getById(borrowId));
		}
		member.setBorrows(borrows);
		

		
		
		memberService.insert(member);         
    }
    
    @PostMapping("/update")
	public void updateMember(@RequestBody MemberDto memberDto) 
    {
		Member member = memberService.getById(memberDto.getIdMember());
		

		List<BookBasket> bookBaskets = new ArrayList<BookBasket>();
		for (int bookBasketId : memberDto.getBookBasketsIds()) {
			bookBaskets.add(bookBasketService.getById(bookBasketId));
		}
		member.setBookBasket(bookBaskets);

		List<Borrow> borrows = new ArrayList<Borrow>();
		for (int borrowId : memberDto.getBorrowsIds()) {
			borrows.add(borrowService.getById(borrowId));
		}
		member.setBorrows(borrows);
		

		
		memberService.update(member);
	}

 /*   @GetMapping("/getlist")
	public List<MemberDto> getMembers() {
		List<MemberDto> viewMembers = new ArrayList<MemberDto>();

		List<Member> members = memberService.getList();
		
		System.out.println(members);

		for (Member member : members) {
			List<Integer> auhtorIds = new ArrayList<Integer>();

			for (Author author : member.getAuthor()) {
				auhtorIds.add(author.getAuthorId());
			}

			List<Integer> MemberCopies = new ArrayList<Integer>();

//			for (MemberCopy MemberCopy : Member.getMemberCopy()) {
//				MemberCopies.add(MemberCopy.getIdMemberCopy());
//			}
			
			viewMembers.add(new MemberDto());
		}

		return viewMembers;
	}
    */
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public Resultat loginPage(@RequestBody IndentifiantsVM identifiant) 
	{
		Resultat result = new Resultat();
		
		try 
		{
			result.setPayload(memberService.getMemberByLogin(identifiant.getEmail(), identifiant.getPassword()));
			result.setMessage(ControllerConstante.LOGIN_SUCCESS);
			result.setSuccess(true);
		} 
		catch (ServiceException se) 
		{
			result.setSuccess(false);
			result.setMessage(se.getMessage());
			se.printStackTrace();
		}
		catch (Exception e) 
		{
			result.setSuccess(false);
			result.setMessage(ControllerConstante.LOGIN_ERROR);
			e.printStackTrace();
		}
		
		return result;
	}
}
