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
import com.imagegrafia.repository.StudentRepository;

@SpringBootApplication
public class HibernateJpaMasteringApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger("HibernateJpaMasteringApplication");

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaMasteringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		studentRepository.saveStudentWithPassport();
	}

}
