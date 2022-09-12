package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.gcu.data.entity.ProductEntity;

@XmlRootElement(name="products")
public class ProductsList {
	private List<ProductEntity> products = new ArrayList<ProductEntity>();
	
	@XmlElement
	public List<ProductEntity> getProducts(){
		return this.products;
	}
	
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
}
