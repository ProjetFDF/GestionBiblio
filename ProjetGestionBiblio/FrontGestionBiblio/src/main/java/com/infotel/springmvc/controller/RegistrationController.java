package com.infotel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gestionbiblio.entity.Registration;
import com.infotel.gestionbiblio.service.inter.RegistrationService;



@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired
    RegistrationService registrationService;
    
    @PostMapping("/add")
    public void addRegistration(@RequestBody Registration registration) 
    {
    	registrationService.insert(registration);            
    }

    @GetMapping("/getlist")
    public List<Registration> getRegistrations() 
    {
        List<Registration> Registrations = registrationService.getList();

        return Registrations;
    }
}
