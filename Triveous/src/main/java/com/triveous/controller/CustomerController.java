package com.triveous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.model.Cart;
import com.triveous.model.Customer;
import com.triveous.service.CartService;
import com.triveous.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody @Valid Customer customer){
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		customer.setRole("ROLE_"+customer.getRole().toUpperCase());
		
		
		Customer registeredCustomer= cService.saveCustomer(customer);
		 
		Cart cart= new Cart();
		
		cart.setCustomer(registeredCustomer);
		
		cartService.createCart(cart);
		
		return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		System.out.println(auth); // this Authentication object having Principle object details
		
		 Customer customer= cService.getCustomerDetailsByEmail(auth.getName());
		 
		 return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
	}
	
	
	
	
}
