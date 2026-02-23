package com.wipro.bank.util;

public class InsufficientFundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientFundException(String message) {
        super(message);
    }
}