package com.crud.repositories;

import java.util.List;

import com.crud.entities.Product;

public interface ProductRepository {
	
	public List<Product> findAll();

}
