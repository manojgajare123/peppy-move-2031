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
	private Integer cid;
	private String cname;
	private String cemail;
	private String cusername;
	private String cpassword;

	@Embedded
	private Address customer_address;

	public Customer(Integer cid, String cname, String cemail, String cusername, String cpassword,
			Address customer_address) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.cusername = cusername;
		this.cpassword = cpassword;
		this.customer_address = customer_address;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCusername() {
		return cusername;
	}

	public void setCusername(String cusername) {
		this.cusername = cusername;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public Address getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(Address customer_address) {
		this.customer_address = customer_address;
	}

	public Customer() {

	}
}
