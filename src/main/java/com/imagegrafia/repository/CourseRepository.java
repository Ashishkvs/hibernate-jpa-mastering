package com.imagegrafia.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imagegrafia.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(CourseRepository.class);
	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {

		return entityManager.find(Course.class, id);
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}

	public Course save(Course course) {
		if (course.getId() == null) {
			// insert
			entityManager.persist(course);
		} else {
			// update
			entityManager.merge(course);
		}
		logger.info("Check Course Id : {}", course);// here if it is insert it will update with id
		return course;
	}
}
