package com.plantapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantapp.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public Customer findByCusernameAndCpassword(String cusername,String cpassword);
	
	
	public Customer  findByCusername(String cusername);
}
