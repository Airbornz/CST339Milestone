package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@GetMapping("/")
	public String display() {
		return "error";
	}
	
}
