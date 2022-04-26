package com.ecom.order.exception;

public class OrderListIsEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderListIsEmptyException(String message) {
		super(message);

	}

}
