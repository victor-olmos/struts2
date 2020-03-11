package com.crud.repositories;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crud.entities.Product;

public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")

	
	public List<Product> findAll() {
		try {
			return entityManager.createQuery("from product").getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	
}
