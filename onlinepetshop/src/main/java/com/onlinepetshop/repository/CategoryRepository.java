package com.onlinepetshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepetshop.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
