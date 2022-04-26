package com.ecom.order.global.exceptonhandler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ExceptionResponse {
	private String message;
	private Date timestamp;
	private String status;
	private String error;

}
