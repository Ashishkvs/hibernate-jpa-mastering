package com.imagegrafia.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imagegrafia.HibernateJpaMasteringApplication;

@RunWith(SpringRunner.class)
public class ProductRepositoryTest {

	@Autowired
	ProductRepository productRepository;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void textPlayWithProduct() {
		productRepository.playWithProduct();
	}

}
