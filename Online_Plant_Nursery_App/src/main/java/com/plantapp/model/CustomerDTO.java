package com.plantapp.model;

public class CustomerDTO {

	private String productName;
	private Integer productQty;

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(String productName, Integer productQty) {
		super();
		this.productName = productName;
		this.productQty = productQty;
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

	@Override
	public String toString() {
		return "CustomerDTO [productName=" + productName + ", productQty=" + productQty + "]";
	}

}
