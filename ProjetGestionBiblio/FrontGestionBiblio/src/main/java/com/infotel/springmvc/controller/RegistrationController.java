package com.infotel.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.dto.RegistrationDto;
import com.infotel.gestionbiblio.entity.Registration;
import com.infotel.gestionbiblio.mapper.RegistrationMapper;
import com.infotel.gestionbiblio.service.inter.RegistrationService;



@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@Autowired
	RegistrationMapper registrationMapper;

	@PostMapping("/add")
	public void addRegistration(@RequestBody RegistrationDto registrationDto) {

		registrationService.insert(registrationMapper.dtoToRegistration(registrationDto));
	}

	@PostMapping("/update")
	public void updateRegistration(@RequestBody RegistrationDto registrationDto) 
	{
		registrationService.update(registrationMapper.dtoToRegistration(registrationDto));
	}

	@GetMapping("/getlist")
	public List<RegistrationDto> getRegistrations() 
	{
		List<RegistrationDto> viewRegistrations = new ArrayList<RegistrationDto>();

		List<Registration> registrations = registrationService.getList();

		for (Registration registration : registrations) {
			
			viewRegistrations.add(registrationMapper.registrationToDto(registration));
		}

		return viewRegistrations;
	}
	
	@GetMapping("/get")
	public RegistrationDto getRegistration(int id) 
	{
		Registration registration = registrationService.getById(id);

		RegistrationDto registrationDto = registrationMapper.registrationToDto(registration);

		return registrationDto;
	}
	
	@GetMapping("/delete")
	public void deleteRegistration(int id) 
	{
		Registration registration = registrationService.getById(id);

		registrationService.delete(registration);
	}

}
