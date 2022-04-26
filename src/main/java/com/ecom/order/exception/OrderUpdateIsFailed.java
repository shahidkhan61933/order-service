package com.ecom.order.exception;

public class OrderUpdateIsFailed extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderUpdateIsFailed(String message) {
		super(message);

	}

}
