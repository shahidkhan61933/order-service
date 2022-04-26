package com.ecom.order.global.exceptonhandler;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecom.order.exception.OrderListIsEmptyException;
import com.ecom.order.exception.OrderNotFoundException;
import com.ecom.order.exception.OrderUpdateIsFailed;
import com.ecom.order.exception.OrderUploadFailedException;

@ControllerAdvice
public class GlobalExceptionHandling {
	
	ExceptionResponse response;
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> customerEmtyValueError(MethodArgumentNotValidException exception) {
		ExceptionResponse errorDetails = new ExceptionResponse("Validation Error", new Date(),
				HttpStatus.NOT_FOUND.name(), exception.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<ExceptionResponse> orderNotFoundexception(OrderNotFoundException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = OrderListIsEmptyException.class)
	public ResponseEntity<ExceptionResponse> orderListEmtyexception(OrderListIsEmptyException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = OrderUpdateIsFailed.class)
	public ResponseEntity<ExceptionResponse> orderrUpdateFailedException(OrderUpdateIsFailed exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = OrderUploadFailedException.class)
	public ResponseEntity<ExceptionResponse> orderUploadFailedException(OrderUploadFailedException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

}
