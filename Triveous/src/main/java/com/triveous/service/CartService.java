package com.triveous.service;

import com.triveous.exception.CartException;
import com.triveous.exception.CustomerException;
import com.triveous.exception.ProductException;
import com.triveous.model.Cart;

public interface CartService {

	public void createCart(Cart cart);

	public String addProducToCart(Integer cartId, Integer productId, Integer quantity)throws CartException,ProductException;
	
	
}
