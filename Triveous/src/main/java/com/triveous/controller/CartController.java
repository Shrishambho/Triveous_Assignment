package com.triveous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.model.Cart;
import com.triveous.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PatchMapping("/cart/{cartId}/product/{productId}/quantity/{quantity}")
	public ResponseEntity<String> addProduct(@PathVariable Integer cartId,@PathVariable Integer productId,@PathVariable Integer quantity){
		
		String str=cartService.addProducToCart(cartId,productId,quantity);
		
		return new ResponseEntity<>(str,HttpStatus.ACCEPTED);
	}
}
