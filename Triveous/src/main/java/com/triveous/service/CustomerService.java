package com.triveous.service;

import com.triveous.exception.CustomerException;
import com.triveous.model.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
}
