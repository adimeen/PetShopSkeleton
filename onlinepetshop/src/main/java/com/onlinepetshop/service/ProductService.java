package com.onlinepetshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepetshop.model.LoginDetails;
import com.onlinepetshop.model.Product;
import com.onlinepetshop.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;

	public Product createCredential(Product product) {
		return repository.saveAndFlush(product);
	}

	public Product getByProductId(int productid) {
		Optional<Product> log=  repository.findById(productid);
		if(log.isPresent())
			return log.get();
		return null;
	}

	public Iterable<Product> getProductList() {
		return repository.findAll();
	}

	public void uploadPhoto(byte[] bytes,int id) {
		repository.updateProductImage(bytes,id);
		
	}

	public Iterable<Product> getProductListByCategoryName(String name) {
		// TODO Auto-generated method stub
		return repository.findByCategory(name);
	}

}
