package com.triveous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.exception.CustomerException;
import com.triveous.model.Customer;
import com.triveous.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository cRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return cRepository.save(customer);
		
	}
	
	@Override
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException {
		
		return cRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer Not found with Email: "+email));
	}
}
