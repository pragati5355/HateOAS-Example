package com.hateoas.business.util;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.hateoas.persistence.entity.Product;
import com.hateoas.web.controller.ProductController;

@Component
public class AssemblerModel implements RepresentationModelAssembler<Product, EntityModel<Product>>{

	@Override
	public EntityModel<Product> toModel(Product product) {
		return EntityModel.of(product,
		        linkTo(methodOn(ProductController.class).getOneProduct(product.getId())).withSelfRel(),
		        linkTo(methodOn(ProductController.class).getAllProduct()).withRel("products"));
	}

}
