package com.onlinepetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepetshop.model.Category;
import com.onlinepetshop.model.Customer;
import com.onlinepetshop.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService service;
	
	@PostMapping("/customer")
	public boolean createCustomer(@RequestBody Customer customer){
		return service.createCustomer(customer);
	}
	
	
	@GetMapping("/customer/{customerid}")
	public Customer getCustomer(@PathVariable int customerid) {
		return service.getByCustomerId(customerid);
	}
	
	@GetMapping("/customer")
	public Iterable<Customer> getCustomerList() {
		return service.getCustomerList();
	}
	
}
