package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductModel {

	@NotNull(message="ID is a required field")
	private int id;
	
	@NotNull(message="Product name is a required field")
	@Size(min=1, max=32, message="Product name must be between 1 and 32 characters")
	private String productName;
	
	@NotNull(message="Product type is a required field")
	@Size(min=1, max=32, message="Product type must be between 1 and 32 characters")
	private String productType;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
}
