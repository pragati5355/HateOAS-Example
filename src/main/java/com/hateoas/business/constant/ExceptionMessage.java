package com.hateoas.business.constant;

public class ExceptionMessage {
	
	private ExceptionMessage() {
		throw new IllegalStateException("Constant class.can't instatiate");
	}
	
	public static final String PRODUCT_NOT_FOUND = "product.not.found";

}
