package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		User user = new User(101, "Chandan", "Jalandhar");
		model.addAttribute("user", user);
		return "home";
	}
//	@GetMapping("/products")
//	public String products(Model model) {
//		List<Product> products = 
//		model.addAttribute("products",products);
//	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
