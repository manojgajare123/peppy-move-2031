package com.plantapp.model;

import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class CustomerDTO {
	@NotNull(message = "field should not be null")
	private String productName;
	@NotNull(message = "field should not be null")
	private Integer productQty;
	@NotNull(message = "field should not be null")
	private String transcationMode;



}
