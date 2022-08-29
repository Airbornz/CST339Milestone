package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class ProductEntity {
	
	@Id
	@Column("productID")
	int id;
	
	@Column("productName")
	String productName;
	
	@Column("productType")
	String productType;

	public ProductEntity(int id, String productName, String productType) {
		super();
		this.id = id;
		this.productName = productName;
		this.productType = productType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	
	
}
