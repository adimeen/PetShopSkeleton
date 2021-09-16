package com.onlinepetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepetshop.model.Customer;
import com.onlinepetshop.model.CustomerOrder;
import com.onlinepetshop.service.CustomerOrderService;

@RestController
public class CustomerOrderController {
	
	@Autowired
	CustomerOrderService service;
	
	@PostMapping("/order")
	public boolean createCredential(@RequestBody CustomerOrder order){
		return service.createCredential(order);
	}
	
	@GetMapping("/order/{orderid}")
	public CustomerOrder getCredential(@PathVariable int orderid) {
		return service.getByOrderId(orderid);
	}
	
	@GetMapping("/order")
	public Iterable<CustomerOrder> getOrderList() {
		return service.getOrderList();
	}

}
