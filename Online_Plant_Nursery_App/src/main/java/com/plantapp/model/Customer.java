package com.plantapp.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customer_id;
	private String customer_name;
	private String customer_email;
	private String customer_username;
	private String customer_password;
	
	@Embedded
	private Address customer_address;

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_username() {
		return customer_username;
	}

	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public Address getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(Address customer_address) {
		this.customer_address = customer_address;
	}

	public Customer(Integer customer_id, String customer_name, String customer_email, String customer_username,
			String customer_password, Address customer_address) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.customer_username = customer_username;
		this.customer_password = customer_password;
		this.customer_address = customer_address;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_email="
				+ customer_email + ", customer_username=" + customer_username + ", customer_password="
				+ customer_password + ", customer_address=" + customer_address + "]";
	}

	public Customer() {

	}
}
