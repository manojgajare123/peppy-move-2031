package com.plantapp.model;

public class Address {
	private Integer address_id;
	private String house_no;
	private String colony;
	private String city;
	private String pincode;
	private String state;

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", house_no=" + house_no + ", colony=" + colony + ", city=" + city
				+ ", pincode=" + pincode + ", state=" + state + "]";
	}

	public Address(Integer address_id, String house_no, String colony, String city, String pincode, String state) {
		super();
		this.address_id = address_id;
		this.house_no = house_no;
		this.colony = colony;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public Address() {

	}
}
