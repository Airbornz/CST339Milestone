package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", new UserModel());
		return "registration";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel lm, BindingResult br, Model m) {
		
		if (br.hasErrors()) {
			m.addAttribute("title", "Register Form");
			return "registration";
		}
		
		return "redirect:/";
	}
	
}
