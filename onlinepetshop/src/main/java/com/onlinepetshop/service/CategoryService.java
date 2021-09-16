package com.onlinepetshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepetshop.model.Category;
import com.onlinepetshop.model.LoginDetails;
import com.onlinepetshop.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;

	public boolean createCategory(Category category) {
		repository.saveAndFlush(category);
		return true;
	}

	public Category getByCategoryId(int categoryid) {
		Optional<Category> log=  repository.findById(categoryid);
		if(log.isPresent())
			return log.get();
		return null;
	}

	public Iterable<Category> getCategoryList() {
		return repository.findAll();
	}

}
