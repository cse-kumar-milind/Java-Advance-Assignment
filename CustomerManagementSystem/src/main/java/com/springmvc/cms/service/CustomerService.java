package com.springmvc.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.cms.model.Customer;
import com.springmvc.cms.repository.CustomerRepository;

@Service
public class CustomerService {
	
	public CustomerRepository customRepo;
	
	public CustomerService(CustomerRepository customRepo) {
		this.customRepo = customRepo;
	}
	
	public List<Customer> getAllCustomers(){
		return customRepo.findAll();
	}
	
	public void saveCustomer(Customer customer) {
		customRepo.save(customer);
	}
	
	public Customer getCustomerById(Long id) {
		return customRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
	}
	
	public void deleteCustomer(Long id) {
		customRepo.deleteById(id);
	}
	
}
