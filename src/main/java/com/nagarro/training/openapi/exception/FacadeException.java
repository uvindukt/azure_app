/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.exception;

/**
 * A custom exception to be thrown by facade classes
 */
public class FacadeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FacadeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FacadeException(String message) {
		super(message);
	}

}
