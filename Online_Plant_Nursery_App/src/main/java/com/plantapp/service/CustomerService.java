package com.plantapp.service;

import java.util.List;

import com.plantapp.exception.CustomerException;
import com.plantapp.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Customer customer) throws CustomerException;

	public Customer deleteCustomer(Integer id) throws CustomerException;

	public Customer viewCustomer(Integer id) throws CustomerException;

	public List<Customer> viewAllCustomers() throws CustomerException;

	public Customer validateCustomer(String userName, String password) throws CustomerException;
}
