package com.hateoas.persistence.dao;

import java.util.List;

import com.hateoas.persistence.entity.Product;

public interface ProductDao {
	
	public Product getOneProduct(Integer id);
	
	public List<Product> getALLProduct();
	
    
}
