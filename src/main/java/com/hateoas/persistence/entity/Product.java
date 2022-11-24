package com.hateoas.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "products")
public class Product extends RepresentationModel<Product>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Integer id;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_description")
	private String productDescription;

}
