package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.data.ProductDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductsList;

@RestController
@RequestMapping("/api/products/")
public class ProductsRestService {

	@Autowired
	private ProductDataService service;
	
	@GetMapping(path="/all/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductEntity> getProductsAsJson(){
		return service.findAll();
	}
	
	@GetMapping(path="/all/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ProductsList getProductsAsXml() {
		ProductsList pl = new ProductsList();
		pl.setProducts(service.findAll());
		return pl;
	}
	
	@GetMapping(path="/product/{id}/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ProductEntity getProductAsJson(@PathVariable("id") int id){
		return service.findById(id);
	}
	
	@GetMapping(path="/product/{id}/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ProductsList getProductAsXml(@PathVariable("id") int id){
		ProductsList pl = new ProductsList();
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		list.add(service.findById(id));
		pl.setProducts(list);
		return pl;
	}
}
