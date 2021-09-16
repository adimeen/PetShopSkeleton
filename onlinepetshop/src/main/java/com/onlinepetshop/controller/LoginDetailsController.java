package com.onlinepetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepetshop.model.LoginDetails;
import com.onlinepetshop.service.LoginDetailsService;

@RestController
public class LoginDetailsController {
	
	@Autowired
	LoginDetailsService service;
	
	@PostMapping("/login")
	public boolean createCredential(@RequestBody LoginDetails login){
		return service.createCredential(login);
	}
	
	@PostMapping("/validate")
	public boolean getCredential(@RequestBody LoginDetails login) {
		return service.isValid(login);
	}


}
