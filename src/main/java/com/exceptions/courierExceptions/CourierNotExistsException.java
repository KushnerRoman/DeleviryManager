package com.exceptions.courierExceptions;

public class CourierNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8840089156925670815L;

	public CourierNotExistsException() {
		
	}

	public CourierNotExistsException(String message) {
		super(message);
		
	}

	public CourierNotExistsException(Throwable cause) {
		super(cause);
		
	}

	public CourierNotExistsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CourierNotExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
