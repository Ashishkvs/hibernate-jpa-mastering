package com.imagegrafia.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.imagegrafia.HibernateJpaMasteringApplication;
import com.imagegrafia.entity.Course;

//load spring entire context
@RunWith(SpringRunner.class)
//explict context
@SpringBootTest(classes = HibernateJpaMasteringApplication.class)
class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindById() {
		Course course = courseRepository.findById(1000L);
		assertEquals("Java-OOPs", course.getName());
	}

	@Test
	//Reset the data after test
	@DirtiesContext
	void testDeleteById() {
		courseRepository.deleteById(1002L);
		//check
		assertNull(courseRepository.findById(1002L));
	}

}
