package com.crud.services;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.entities.Product;
import com.crud.repositories.ProductRepository;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{
	
	@PersistenceContext
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	public List<Product> findAll() {
		return this.productRepository.findAll();
	}
	
	

}


