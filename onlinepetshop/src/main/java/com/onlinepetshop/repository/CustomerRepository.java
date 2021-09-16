package com.onlinepetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepetshop.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}