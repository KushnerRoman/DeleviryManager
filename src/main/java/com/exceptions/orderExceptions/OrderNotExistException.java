package com.exceptions.orderExceptions;

public class OrderNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8499721052314863731L;

	public OrderNotExistException() {
	}

	public OrderNotExistException(String message) {
		super(message);
		
	}

	public OrderNotExistException(Throwable cause) {
		super(cause);
		
	}

	public OrderNotExistException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public OrderNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

}
