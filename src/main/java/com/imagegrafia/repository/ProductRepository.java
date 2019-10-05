package com.imagegrafia.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imagegrafia.entity.Product;

@Repository
@Transactional
public class ProductRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EntityManager entityManager;
	
	public void playWithProduct() {
		Product product = new Product();
		product.setName("Lcd monitors");
		product.setQuantity(1520);
		entityManager.persist(product);
	}
	
	
}
