package com.hateoas.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hateoas.persistence.dao.ProductDao;
import com.hateoas.persistence.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getOneProduct(Integer id) {
		return productDao.getOneProduct(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getALLProduct();
	}

}
