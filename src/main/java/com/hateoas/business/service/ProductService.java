package com.hateoas.business.service;

import java.util.List;

import com.hateoas.persistence.entity.Product;

public interface ProductService {
	
	public Product getOneProduct(Integer id);
	
	public List<Product> getAllProducts();

}
