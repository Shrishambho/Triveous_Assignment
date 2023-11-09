package com.triveous.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.exception.CartException;
import com.triveous.exception.ProductException;
import com.triveous.model.Cart;
import com.triveous.model.CartProduct;
import com.triveous.model.Product;
import com.triveous.repository.CartProductRepository;
import com.triveous.repository.CartRepository;
import com.triveous.repository.CustomerRepository;
import com.triveous.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartProductRepository cpRepository;
	
	@Autowired
	private CartRepository cartRepository; 
	
    public void createCart(Cart cart) {
		
		cartRepository.save(cart);
	}

	@Override
	public String addProducToCart(Integer cartId, Integer productId, Integer quantity)
			throws CartException, ProductException {
		
		Optional<Cart> opt1=cartRepository.findById(productId);
		
		if(opt1.isEmpty()) {
			throw new CartException("No cart with given id present.");
		}
		
		Optional<Product> opt2=productRepository.findById(productId);
		if(opt2.isEmpty()) {
			throw new ProductException("No product with given id present.");
		}
		
		Cart cart=opt1.get();
		Product product=opt2.get();
		
		List<CartProduct> cp=cart.getCartProduct();
		
		for(CartProduct x:cp) {
			if(x.getProduct().equals(product)) {
				x.setQuantity(quantity);
				CartProduct cp1=cpRepository.save(x);
				cart.setCartProduct(cp);
				cartRepository.save(cart);
				return "value updated successfully";
			}
		}
		
		CartProduct cp2=new CartProduct();
		cp2.setCart(cart);
		cp2.setProduct(product);
		cp2.setQuantity(quantity);
		cpRepository.save(cp2);
		cartRepository.save(cart);
		return "value added successfully";
		
		
		
	}

	
}
