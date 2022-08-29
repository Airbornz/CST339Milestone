package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.data.ProductDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/products/add")
public class ProductAddController {

	@Autowired
	private ProductDataService service;
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Add Product Form");
		model.addAttribute("productModel", new ProductModel());
		return "newproduct";
	}
	
	@PostMapping("/doAdd")
	public String doAdd(@Valid ProductModel pm, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("title", "Add Product Form");
			return "newproduct";
		}
		
		service.create(new ProductEntity(0, pm.getProductName(), pm.getProductType()));
		
		return "redirect:/success/";
	}
	
}
