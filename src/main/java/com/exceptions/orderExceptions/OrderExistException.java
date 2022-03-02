package com.exceptions.orderExceptions;

public class OrderExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2058303707164079747L;

	public OrderExistException() {
		
	}

	public OrderExistException(String message) {
		super(message);
		
	}

	public OrderExistException(Throwable cause) {
		super(cause);
	
	}

	public OrderExistException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public OrderExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
