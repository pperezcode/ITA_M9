package com.rocket.application;

@SuppressWarnings("serial")
public class CodiFormatException extends Exception {
	
	public CodiFormatException() {}
	
	public CodiFormatException(String errorMessage) {
		super(errorMessage);
	}

}
