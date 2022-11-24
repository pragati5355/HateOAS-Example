package com.hateoas.business.constant;

public class UrlMapping {
	
	private UrlMapping() {
		throw new IllegalStateException("Constant class.can't instatiate");
	}
	
	public static final String BASE_URL = "api";
	
	public static final String PRODUCT = "product/{id}";
	
	public static final String LIST_PRODUCTS = "product/list";

}
