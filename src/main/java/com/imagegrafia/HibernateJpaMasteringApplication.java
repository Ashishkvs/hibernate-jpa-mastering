package com.imagegrafia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.imagegrafia.entity.Course;
import com.imagegrafia.repository.CourseRepository;
import com.imagegrafia.repository.ProductRepository;

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
//		Course findById = courseRepository.findById(1000l);
//		logger.info("Course : {}", findById);
		// we will face transaction Issue if @Transactional not used in repository
		/*
		 * No EntityManager with actual transaction available for current thread -
		 * cannot reli ably process 'remove' call; nested exception is
		 * javax.persistence.TransactionRequiredException: No EntityManager with actual
		 * transaction available for current thread - cannot reliably process 'remove'
		 * call
		 */
//		courseRepository.deleteById(1001L);
//		//insert data
//		courseRepository.save(new Course("Python"));
		// entity manager Transactional side effect
		courseRepository.playWithEntityManager();
		ProductRepository productRepository = new ProductRepository();
		productRepository.playWithProduct();
	}

}
