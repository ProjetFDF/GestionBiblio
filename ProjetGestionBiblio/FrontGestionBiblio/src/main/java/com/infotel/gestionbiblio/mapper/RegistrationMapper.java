package com.infotel.gestionbiblio.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.gestionbiblio.dto.RegistrationDto;
import com.infotel.gestionbiblio.entity.Registration;
import com.infotel.gestionbiblio.service.inter.LibraryService;
import com.infotel.gestionbiblio.service.inter.MemberService;
import com.infotel.gestionbiblio.service.inter.RegistrationService;

@Component
public class RegistrationMapper {
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	LibraryService libraryService;

	public Registration dtoToRegistration(RegistrationDto registrationDto) 
	{

		Registration registration = new Registration(registrationDto.getDate(),memberService.getById(registrationDto.getIdRegistration()),libraryService.getById(registrationDto.getLibraryId()));

		return registration;
	}

	public RegistrationDto registrationToDto(Registration registration) {


		return new RegistrationDto(registration.getDate(),registration.getMember().getIdMember(),registration.getLibrary().getIdLibrary());
	}


}
