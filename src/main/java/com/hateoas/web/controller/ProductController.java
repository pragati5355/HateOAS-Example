package com.hateoas.web.controller;

import static com.hateoas.business.constant.GenericConstants.SUCESS;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hateoas.business.constant.UrlMapping;
import com.hateoas.business.service.ProductService;
import com.hateoas.business.util.AssemblerModel;
import com.hateoas.persistence.entity.Product;
import com.hateros.web.model.ResponseModel;

@RestController
public class ProductController extends BaseController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AssemblerModel assemblerModel;
	
	@Autowired
	private Environment env;
	
	public ProductController(ProductService productService , AssemblerModel assemblerModel) {
		
		this.productService = productService;
		this.assemblerModel = assemblerModel;
	}

	/**
	 * Normal Implementation
	 * @param id
	 * 
	 */
//	@GetMapping(UrlMapping.PRODUCT)
//	public ResponseEntity<ResponseModel>  getOneProduct(@PathVariable Integer id)  {
//		LOGGER.info("------------ In getServiceCategoryList [web service] --------------");
//		ResponseModel response = ResponseModel.getInstance();
//		response.setData(productService.getOneProduct(id));
//		response.setMessage(env.getProperty(SUCESS));
//		response.setStatusCode(HttpStatus.OK.value());
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
//	
//	@GetMapping(UrlMapping.LIST_PRODUCTS)
//	public ResponseEntity<ResponseModel>  getAllProduct()  {
//		LOGGER.info("------------ In getServiceCategoryList [web service] --------------");
//		ResponseModel response = ResponseModel.getInstance();
//		response.setData(productService.getAllProducts());
//		response.setMessage(env.getProperty(SUCESS));
//		response.setStatusCode(HttpStatus.OK.value());
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
	
	/**
	 * without assembler 
	 * @param id
	 *
	 */
//	@GetMapping(UrlMapping.PRODUCT)
//	public EntityModel<Product> getOneProduct(@PathVariable Integer id) {
//		LOGGER.info("------------ In getServiceCategoryList [web service] --------------");
//		Product product =  productService.getOneProduct(id);
//		
//		return EntityModel.of(product, 
//				linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel(),
//			      linkTo(methodOn(ProductController.class).getAllProduct()).withRel("products"));
//	}
//	
//	@GetMapping(UrlMapping.LIST_PRODUCTS)
//	public CollectionModel<EntityModel<Product>> getAllProduct() {
//    LOGGER.info("------------ In getServiceCategoryList [web service] --------------");
//	  List<EntityModel<Product>> product = productService.getAllProducts().stream()
//	      .map(products -> EntityModel.of(products,
//	          linkTo(methodOn(ProductController.class).getOneProduct(products.getId())).withSelfRel(),
//	          linkTo(methodOn(ProductController.class).getAllProduct()).withRel("products")))
//	      .collect(Collectors.toList());
//
//	  return CollectionModel.of(product, linkTo(methodOn(ProductController.class).getAllProduct()).withSelfRel());
//	}

	/**
	 *  With Assembler
	 * @param id
	 * 
	 */
	
	@GetMapping(UrlMapping.PRODUCT)
	public EntityModel<Product> getOneProduct(@PathVariable Integer id) {
		LOGGER.info("------------ In getServiceCategoryList [web service] --------------");
		Product product =  productService.getOneProduct(id);
		
		return assemblerModel.toModel(product);
	}
	
	@GetMapping(UrlMapping.LIST_PRODUCTS)
	public CollectionModel<EntityModel<Product>> getAllProduct() {
		
	  LOGGER.info("------------ In getServiceCategoryList [web service] --------------");
	  List<EntityModel<Product>> product = productService.getAllProducts().stream()
	      .map(assemblerModel :: toModel)
	      .collect(Collectors.toList());

	  return CollectionModel.of(product, linkTo(methodOn(ProductController.class).getAllProduct()).withSelfRel());
	}

	
	

}
