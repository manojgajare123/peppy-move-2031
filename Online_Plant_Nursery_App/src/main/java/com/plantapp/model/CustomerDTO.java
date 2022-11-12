package com.plantapp.model;

public class CustomerDTO {

	private String productName;
	private Integer productQty;
	private String transcationMode;

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(String productName, Integer productQty, String transcationMode) {
		super();
		this.productName = productName;
		this.productQty = productQty;
		this.transcationMode = transcationMode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	public String getTranscationMode() {
		return transcationMode;
	}

	public void setTranscationMode(String transcationMode) {
		this.transcationMode = transcationMode;
	}

}
