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
@RequestMapping("/products/update")
public class ProductUpdateController {

	@Autowired
	private ProductDataService service;
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Update Product Form");
		model.addAttribute("productModel", new ProductModel());
		return "updateproduct";
	}
	
	@PostMapping("/doUpdate")
	public String doUpdate(@Valid ProductModel pm, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("title", "Update Product Form");
			return "newproduct";
		}
		
		try {
			System.out.println("Got "+pm.getId()+" "+pm.getProductName()+" "+pm.getProductType());
			service.update(new ProductEntity(pm.getId(), pm.getProductName(), pm.getProductType()));
			return "redirect:/success/";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "redirect:/error/";
		}
		
		
	}
	
}
