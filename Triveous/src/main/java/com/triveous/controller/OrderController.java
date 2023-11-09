package com.triveous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.model.Orders;
import com.triveous.service.OrdersService;

@RestController
public class OrderController {

	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/orders/{customerId}/cart/{cartId}")
	public ResponseEntity<Orders> placeOrder(@PathVariable Integer customerId,@PathVariable Integer cartId){
		
		Orders ord=ordersService.placeOrders(cartId, customerId);
		
		return new ResponseEntity<>(ord,HttpStatus.ACCEPTED);
	}
}
