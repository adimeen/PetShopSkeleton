package com.onlinepetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepetshop.model.LoginDetails;
@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails,String>{

}
