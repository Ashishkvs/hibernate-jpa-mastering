package com.imagegrafia;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.imagegrafia.entity.Course;
import com.imagegrafia.entity.Review;
import com.imagegrafia.repository.CourseRepository;
import com.imagegrafia.repository.ProductRepository;
import com.imagegrafia.repository.StudentRepository;

@SpringBootApplication
public class HibernateJpaMasteringApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger("HibernateJpaMasteringApplication");

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaMasteringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Review> reviews=new ArrayList<Review>();
		reviews.add(new Review("Awsome stuff", "5"));
		reviews.add(new Review("Great explanantions", "5"));
		
		courseRepository.addReviewsForCourse(1002L,reviews);
	}

}
