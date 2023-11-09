package com.triveous.exception;

public class OrderException extends  RuntimeException {

	public OrderException() {
		
	}
	
	public OrderException(String msg) {
		super(msg);
	}
}
