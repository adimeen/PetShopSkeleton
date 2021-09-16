package com.onlinepetshop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.onlinepetshop.model.Product;
import com.onlinepetshop.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		
		return service.createCredential(product);
	}
	
	@PutMapping("/upload/{id}")
	public boolean uploadPhoto(@PathVariable int id,@RequestParam("file") MultipartFile file) throws IOException
	{
		
		if(file!=null) {
			service.uploadPhoto(file.getBytes(),id);
			return true;
		}
		return false;
		
	}
	
	
	@GetMapping("/product/{productid}")
	public Product getProductById(@PathVariable int productid) {
		return service.getByProductId(productid);
	}
	
	@GetMapping("/product")
	public Iterable<Product> getProductList() {
		return service.getProductList();
	}
	
	@GetMapping("/productbycategory/{name}")
	public Iterable<Product> getProductListByCategory(@PathVariable String name) {
		return service.getProductListByCategoryName(name);
	}

}
