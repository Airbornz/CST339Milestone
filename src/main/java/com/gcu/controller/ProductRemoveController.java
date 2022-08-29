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
@RequestMapping("/products/remove")
public class ProductRemoveController {

	@Autowired
	private ProductDataService service;
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Remove Product Form");
		model.addAttribute("productModel", new ProductModel());
		return "removeproduct";
	}
	
	@PostMapping("/doRemove")
	public String doRemove(@Valid ProductModel pm, BindingResult br, Model m) {
		try {
			service.delete(new ProductEntity(pm.getId(), "", ""));
			return "redirect:/success/";
		}
		catch (Exception e){
			return "redirect:/error/";
		}
	}
	
}
