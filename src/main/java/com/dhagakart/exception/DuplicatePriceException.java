package com.dhagakart.exception;

public class DuplicatePriceException extends RuntimeException {

	public DuplicatePriceException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;

}
