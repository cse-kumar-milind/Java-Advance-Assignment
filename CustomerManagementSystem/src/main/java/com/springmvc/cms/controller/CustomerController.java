package com.springmvc.cms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.cms.model.Customer;
import com.springmvc.cms.service.CustomerService;

@Controller
public class CustomerController {
	
	public CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@GetMapping("/addCustomer")
	public String showAddCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers";
		
	}
	
	@GetMapping("/customers")
	public ModelAndView getCustomerDetails() {
		List<Customer> customers = customerService.getAllCustomers();
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers", customers);
		mv.setViewName("customers");
		return mv;
	}
	
	@GetMapping("/editCustomer/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		return "addCustomer";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return "redirect:/customers";
	}
	
}
