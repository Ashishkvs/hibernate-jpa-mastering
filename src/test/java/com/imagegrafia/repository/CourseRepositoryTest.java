package com.imagegrafia.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.imagegrafia.HibernateJpaMasteringApplication;
import com.imagegrafia.entity.Course;
import com.imagegrafia.entity.Review;

//load spring entire context
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaMasteringApplication.class)
public class CourseRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(CourseRepositoryTest.class);
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EntityManager em;


	@Test
	public void testFindById() {
		Course course = courseRepository.findById(1000L);
		assertEquals("Java-OOPs", course.getName());
	}

	@Test
	// Reset the data after test
	@DirtiesContext
	public void testDeleteById() {
		courseRepository.deleteById(1002L);
		// check
		assertNull(courseRepository.findById(1002L));
	}

	@Test
	public void testSave() {
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
//	@DirtiesContext
	@Transactional
	public void retrieveReviewForCourse() {
		Course course = courseRepository.findById(1001L);
		log.info("Reviews : -> {}" ,course.getReviews());
	}
	
	/**
	 * @ManyToOne is always eager fetching by default
	 */
	@Test
//	@DirtiesContext
//	@Transactional
	public void retrieveCourseFromReview() {
		Review review = em.find(Review.class,5001L);
		log.info("Course : -> {}" ,review.getCourse());
	}

}
