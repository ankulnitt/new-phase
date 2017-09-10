package com.abc.exception;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8193657463584780879L;

	private String message = null;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
		this.message = message;
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
