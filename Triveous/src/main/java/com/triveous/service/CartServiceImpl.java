package com.triveous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.model.Cart;
import com.triveous.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository; 
	
    public void createCart(Cart cart) {
		
		cartRepository.save(cart);
	}
}
