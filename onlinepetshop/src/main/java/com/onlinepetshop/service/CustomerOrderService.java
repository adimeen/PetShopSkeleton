package com.onlinepetshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepetshop.model.CustomerOrder;
import com.onlinepetshop.model.LoginDetails;
import com.onlinepetshop.repository.CustomerOrderRepository;

@Service
public class CustomerOrderService {
	
	@Autowired
	CustomerOrderRepository repository;

	public boolean createCredential(CustomerOrder order) {
		repository.saveAndFlush(order);
		return true;
	}

	public CustomerOrder getByOrderId(int orderid) {
		Optional<CustomerOrder> log=  repository.findById(orderid);
		if(log.isPresent())
			return log.get();
		return null;
	}

	public Iterable<CustomerOrder> getOrderList() {
		return repository.findAll();
	}

}
