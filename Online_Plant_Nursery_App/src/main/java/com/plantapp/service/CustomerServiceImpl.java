package com.plantapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantapp.exception.CustomerException;
import com.plantapp.model.Customer;
import com.plantapp.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo cr;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
    Customer c= cr.save(customer);
     if(c!=null) {
    	 return c;
     }
     else {
    	 throw new CustomerException("Customer can not be added");
     }
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt=cr.findById(customer.getCid());
		if(opt.isPresent()) {
			Customer c= cr.save(customer);
			return c;
		}
		else {
			throw new CustomerException("Invalid customer details");
		}
	}

	@Override
	public Customer deleteCustomer(Integer id) throws CustomerException {
	  Optional<Customer> opt=cr.findById(id);
	  if(opt.isPresent()) {
		  cr.delete(opt.get());
		  return opt.get();
	  }
	  else {
		  throw new CustomerException("Invalid customer Id");
	  }
	}

	@Override
	public Customer viewCustomer(Integer id) throws CustomerException {
		Optional<Customer> opt=cr.findById(id);
		  if(opt.isPresent()) {
			  return opt.get();
		  }
		  else {
			  throw new CustomerException("Invalid customer Id");
		  }
	}

	@Override
	public List<Customer> viewAllCustomers() throws CustomerException {
		List<Customer> customers=cr.findAll();
		if(customers.size()>0) {
			return customers;
		}
		else {
			throw new CustomerException("No customer found");
		}
	}

	@Override
	public Customer validateCustomer(String userName, String password) throws CustomerException {
		Customer c= cr.findByCusernameAndCpassword(userName, password);
		if(c!=null) {
			return c;
		}
		else {
			throw new CustomerException("Invalid username or password");
		}
	}

}
