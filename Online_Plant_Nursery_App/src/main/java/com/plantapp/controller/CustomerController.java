package com.plantapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.CustomerException;
import com.plantapp.model.Customer;
import com.plantapp.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
	@Autowired
	CustomerServiceImpl csi;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException {
		Customer c=csi.addCustomer(customer);
		return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
	}

    @PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException {
    	Customer c=csi.updateCustomer(customer);
    	return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}

    @DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) throws CustomerException {
		Customer c=csi.deleteCustomer(id);
		return new ResponseEntity<Customer>(c,HttpStatus.ACCEPTED);
	}

    @GetMapping("/view/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") Integer id) throws CustomerException {
		Customer c=csi.viewCustomer(id);
		return new ResponseEntity<Customer>(c,HttpStatus.FOUND);
	}

    @GetMapping("/view")
	public ResponseEntity<List<Customer>> viewAllCustomers() throws CustomerException {
		List<Customer> customers=csi.viewAllCustomers();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}

    @GetMapping("/validation/{username}/{pass}")
	public ResponseEntity<Customer> validateCustomer(@PathVariable("username") String username,@PathVariable("pass") String password) throws CustomerException {
		Customer c=csi.validateCustomer(username, password);
		return new ResponseEntity<Customer>(c,HttpStatus.FOUND);
	}

}
