package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.data.ProductDataService;

@Controller
@RequestMapping("/product")
public class ProductViewController {

	@Autowired
	private ProductDataService service;
	
	@GetMapping("/{id}")
	public String display(@PathVariable("id") int id, Model model) {
		model.addAttribute("title", "View Product");
		
		model.addAttribute("product", service.findById(id));
		
		return "product";
	}
	
}
