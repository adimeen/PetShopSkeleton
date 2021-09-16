package com.onlinepetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepetshop.model.Category;
import com.onlinepetshop.model.LoginDetails;
import com.onlinepetshop.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService service;
	
	@PostMapping("/category")
	public boolean createCategory(@RequestBody Category category){
		return service.createCategory(category);
	}
	
	@GetMapping("/category/{categoryid}")
	public Category getCategory(@PathVariable int categoryid) {
		return service.getByCategoryId(categoryid);
	}
	
	@GetMapping("/category")
	public Iterable<Category> getCategoryList() {
		return service.getCategoryList();
	}

}
