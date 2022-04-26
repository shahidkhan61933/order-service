package com.ecom.order.exception;

public class OrderUploadFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderUploadFailedException(String message) {
		super(message);

	}

}
