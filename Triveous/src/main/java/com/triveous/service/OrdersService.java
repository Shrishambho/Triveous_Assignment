package com.triveous.service;

import com.triveous.exception.CartException;
import com.triveous.exception.CustomerException;
import com.triveous.model.Orders;

public interface OrdersService {

	public Orders placeOrders(Integer cartId,Integer customerId)throws CartException,CustomerException;
}
