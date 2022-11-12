package com.plantapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private Integer address_id;
	private String house_no;
	private String colony;
	private String city;
	private String pincode;
	private String state;

	
}
