package com.exceptions.courierExceptions;

public class CourierExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7687517768807946211L;
	public CourierExistsException() {
	}

	public CourierExistsException(String message) {
		super(message);
	}

	public CourierExistsException(Throwable cause) {
		super(cause);
	}

	public CourierExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CourierExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
