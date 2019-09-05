package com.imagegrafia.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imagegrafia.HibernateJpaMasteringApplication;
import com.imagegrafia.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaMasteringApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	@Test
	public void findById_basic() {
		List resultList = entityManager.createQuery("select c from Course c").getResultList();
		logger.info("Lists -> {}", resultList);
	}

	// Returning typed query
	@Test
	public void findById_typed() {
		List<Course> resultList = entityManager.createQuery("select c from Course c", Course.class).getResultList();
		logger.info("Lists -> {}", resultList);
	}
	
	//where query
	@Test
	public void jpqlWithWhere_typed() {
		List<Course> resultList = entityManager.createQuery("select c from Course c where name like '%a'", Course.class).getResultList();
		logger.info("Lists -> {}", resultList);
	}
}
