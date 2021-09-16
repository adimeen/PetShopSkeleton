package com.onlinepetshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepetshop.model.Customer;
import com.onlinepetshop.model.LoginDetails;
import com.onlinepetshop.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;

	public boolean createCustomer(Customer customer) {
		repository.saveAndFlush(customer);
		return true;
	}

	public Customer getByCustomerId(int customerid) {
		Optional<Customer> log=  repository.findById(customerid);
		if(log.isPresent())
			return log.get();
		return null;
	}

	public Iterable<Customer> getCustomerList() {
		return repository.findAll();
	}

}
