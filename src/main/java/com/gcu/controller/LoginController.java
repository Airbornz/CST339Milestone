package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel lm, BindingResult br, Model m) {
		
		if (br.hasErrors()) {
			m.addAttribute("title", "Login Form");
			return "login";
		}
		
		System.out.println(String.format("Form with a username of %s and password of %s", lm.getUsername(), lm.getPassword()));
		
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "0000000002", "Product 2", 2.00f, 2));
		orders.add(new OrderModel(2L, "0000000003", "Product 3", 3.00f, 3));
		orders.add(new OrderModel(3L, "0000000004", "Product 4", 4.00f, 4));
		orders.add(new OrderModel(4L, "0000000005", "Product 5", 5.00f, 5));

		m.addAttribute("title", "My Orders");
		m.addAttribute("orders", orders);
		
		return "orders";
		
		
	}
	
}
