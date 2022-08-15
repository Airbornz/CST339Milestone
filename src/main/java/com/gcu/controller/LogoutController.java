package com.gcu.controller;

//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//@Controller
//@RequestMapping("/session")
//public class LogoutController {
//
//	@GetMapping("/logout")
//	public String display(Model model) {
//	
//		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		HttpSession session = attr.getRequest().getSession();
//		session.invalidate();
//		
//		return "index";
//	}
//	
//}
