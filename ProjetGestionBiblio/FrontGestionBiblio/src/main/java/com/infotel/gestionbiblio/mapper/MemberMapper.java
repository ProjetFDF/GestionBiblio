package com.infotel.gestionbiblio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.MemberDto;
import com.infotel.gestionbiblio.entity.BookBasket;
import com.infotel.gestionbiblio.entity.Borrow;
import com.infotel.gestionbiblio.entity.Member;
import com.infotel.gestionbiblio.service.inter.BookBasketService;
import com.infotel.gestionbiblio.service.inter.BorrowService;
import com.infotel.gestionbiblio.service.inter.MemberService;


@Component
public class MemberMapper {

	@Autowired
	BookBasketService bookBasketService;
	
	@Autowired
	BorrowService borrowBasketService;
	


	public Member dtoToMember(MemberDto memberDto) {

		
		List<BookBasket> bookBaskets = new ArrayList<BookBasket>();
		for (int bookbasketId : memberDto.getBookBasketsIds()) {
			bookBaskets.add(bookBasketService.getById(bookbasketId));
		}
		
		List<Borrow> borrows = new ArrayList<Borrow>();
		for (int borrowId : memberDto.getBorrowsIds()) {
			borrows.add(borrowBasketService.getById(borrowId));
		}

		Member member = new Member(memberDto.getLastname(),memberDto.getFirstname(),memberDto.getEmail(),memberDto.getPassword(),memberDto.getAddress(),memberDto.getCity(),memberDto.getPostalCode(),memberDto.getPhone(),memberDto.isAdministrateur(),bookBaskets,borrows);
 
		member.setIdMember(memberDto.getIdMember());
		
		return member;
	}

	public MemberDto memberToDto(Member member) {
		
		List<Integer> bookBasketIds = new ArrayList<Integer>();
		for (BookBasket bookBasket : member.getBookBaskets()) {
			bookBasketIds.add(bookBasket.getIdBookBasket());
		}
		
		List<Integer> borrowIds = new ArrayList<Integer>();
		for (Borrow borrow : member.getBorrows()) {
			borrowIds.add(borrow.getIdBorrow());
		}

		
		MemberDto memberDto = new MemberDto(member.getLastname(),member.getFirstname(),member.getEmail(),member.getPassword(),member.getAddress(),member.getCity(),member.getPostalCode(),member.getPhone(),member.isAdministrateur(),bookBasketIds,bookBasketIds);
		
		memberDto.setIdMember(member.getIdMember());
		
		return memberDto;
		
	}
}
