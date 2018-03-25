package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.MemberDto;
import com.infotel.gestionbiblio.entity.Member;
import com.infotel.gestionbiblio.exception.ServiceException;
import com.infotel.gestionbiblio.mapper.MemberMapper;
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
	
	@Autowired
	MemberMapper memberMapper;
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public Resultat addMember(@RequestBody MemberDto memberDto) 
    {
    	Resultat result = new Resultat();
		System.out.println(memberDto);
		try 
		{
			memberService.insert(memberMapper.dtoToMember(memberDto));
			result.setPayload(memberDto);
			result.setMessage(ControllerConstante.INSCRIPTION_SUCCESS);
			result.setSuccess(true);
		} 
		catch (Exception e) 
		{
			result.setSuccess(false);
			result.setMessage(ControllerConstante.INSCRIPTION_ERROR);
			e.printStackTrace();
		}
		
		return result;
    }
    
    @PostMapping(value = {"/update"})
	public void updateMember(@RequestBody MemberDto memberDto) 
    {	
		memberService.update(memberMapper.dtoToMember(memberDto));
	}

    @GetMapping("/getlist")
	public List<MemberDto> getMembers() 
    {
		List<MemberDto> viewMembers = new ArrayList<MemberDto>();

		List<Member> members = memberService.getList();
		
		System.out.println(members);

		for (Member member : members) 
		{
			viewMembers.add(memberMapper.memberToDto(member));
		}

		return viewMembers;
	}
    
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public Resultat loginPage(@RequestBody IndentifiantsVM identifiant, HttpServletRequest request) 
	{
		Resultat result = new Resultat();
		
		try 
		{
			HttpSession session = request.getSession();
			session.setAttribute("USER", "Ton user");
			result.setPayload(memberMapper.memberToDto(memberService.getMemberByLogin(identifiant.getEmail(), identifiant.getPassword())));
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
	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public Resultat logoutPage(HttpServletRequest request) 
	{
		Resultat result = new Resultat();
		
		try 
		{
			HttpSession session = request.getSession();
			session.invalidate();
			result.setPayload("Logout OK");
			result.setMessage(ControllerConstante.LOGIN_SUCCESS);
			result.setSuccess(true);
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
