package com.onlinepetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinepetshop.model.Product;
@Repository
@Transactional 
public interface ProductRepository extends JpaRepository<Product,Integer>{
	@Modifying(clearAutomatically = true)
	@Query("update Product p set p.productimage =:bytes where p.productid = :id")
	void updateProductImage(@Param("bytes") byte[] bytes, @Param("id") Integer id);
	
	@Query("SELECT p FROM Product p WHERE p.categoryname = :name")
	Iterable<Product> findByCategory(String name);


}