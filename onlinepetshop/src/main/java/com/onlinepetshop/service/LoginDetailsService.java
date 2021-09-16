package com.onlinepetshop.service;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepetshop.model.LoginDetails;
import com.onlinepetshop.repository.LoginDetailsRepository;

@Service
public class LoginDetailsService {
	@Autowired
	LoginDetailsRepository repository;

	public boolean createCredential(LoginDetails login) {
		repository.saveAndFlush(login);
		return true;
	}

	public LoginDetails getByEmail(String email) {
		Optional<LoginDetails> log=  repository.findById(email);
		if(log.isPresent())
			return log.get();
		return null;
	}

	public Iterable<LoginDetails> getLoginList() {
		return repository.findAll();
	}

	public boolean isValid(LoginDetails login) {
		// TODO Auto-generated method stub
		Iterable<LoginDetails> details= repository.findAll();
		Iterator<LoginDetails> itr= details.iterator();
		while(itr.hasNext())
		{
			LoginDetails dbDtetails = itr.next();
			if(dbDtetails.getEmail().equalsIgnoreCase(login.getEmail()) 
					&& dbDtetails.getPassword().equals(login.getPassword())
					&& dbDtetails.getRole().equals(login.getRole()))
			{
				return true;
			}
		}
		return false;
	}


}
