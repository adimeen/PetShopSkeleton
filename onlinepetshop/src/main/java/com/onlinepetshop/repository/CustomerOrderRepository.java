package com.onlinepetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepetshop.model.CustomerOrder;
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer>{

}