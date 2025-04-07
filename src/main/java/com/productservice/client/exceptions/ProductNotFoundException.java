package com.productservice.client.exceptions;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 2611921045784393158L;
	
	public ProductNotFoundException(String message) {
	   super(message);
	}

}
