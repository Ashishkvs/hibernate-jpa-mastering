package com.imagegrafia.repository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
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
class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@Before
	void setUp() throws Exception {
	}

	@Test
	void testFindById() {
		Course course = courseRepository.findById(1000L);
		assertEquals("Java-OOPs", course.getName());
	}

	@Test
	// Reset the data after test
	@DirtiesContext
	void testDeleteById() {
		courseRepository.deleteById(1002L);
		// check
		assertNull(courseRepository.findById(1002L));
	}

	@Test
	void testSave() {
		// find the course
		Course course = courseRepository.findById(1000L);
		assertEquals("Java-OOPs", course.getName());

		// update the course
		course.setName("Java-OOPs updated");
		courseRepository.save(course);

		// Again find the value byId

		Course updatedCourse = courseRepository.findById(1000L);
		assertEquals("Java-OOPs updated", updatedCourse.getName());

	}

	@Test
	@DirtiesContext
	public void testPlayWithEntityManager() {
		courseRepository.playWithEntityManager();
	}

}
