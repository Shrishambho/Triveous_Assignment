package com.triveous.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.exception.CartException;
import com.triveous.exception.CustomerException;
import com.triveous.model.Cart;
import com.triveous.model.CartProduct;
import com.triveous.model.Customer;
import com.triveous.model.Orders;
import com.triveous.model.Product;
import com.triveous.repository.CartRepository;
import com.triveous.repository.CustomerRepository;
import com.triveous.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public Orders placeOrders(Integer cartId, Integer customerId) throws CartException, CustomerException {
		Optional<Customer> opt1=customerRepository.findById(customerId);
		if(opt1.isEmpty()) {
			throw new CustomerException("No customer with given id present.");
		}
		
		Optional<Cart> opt2=cartRepository.findById(cartId);
		if(opt2.isEmpty()) {
			throw new CartException("No cart with given id present");
		}
		
		Cart cart=opt2.get();
		Customer customer=opt1.get();
		List<Product> list1 = new ArrayList<>();
		List<CartProduct> list=cart.getCartProduct();
		Orders ord=new Orders();
		ord.setCustomer(customer);
		
		double amount=0;
		
		for(CartProduct x:list) {
		  amount+=x.getQuantity()*x.getProduct().getPrice();
		  list1.add(x.getProduct());
		}
		
		
		ord.setProduct(list1);
		ord.setTotalPrice(amount);
		
		Orders od=ordersRepository.save(ord);
		
		return od;
	}

}









