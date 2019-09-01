package com.imagegrafia.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imagegrafia.entity.Course;

@Repository
public class CourseRepository {

	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {

		return entityManager.find(Course.class, id);
	}

//	public Course save(Course course) {
//
//	}
}
