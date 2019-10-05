package com.imagegrafia.repository;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imagegrafia.HibernateJpaMasteringApplication;
import com.imagegrafia.entity.Passport;
import com.imagegrafia.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaMasteringApplication.class)
public class StudentRepositoryTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EntityManager em;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * when we are having LAZY fetch we need @Transactional
	 */
	@Test
	@Transactional
	public void retrieveStudentAndPassport() {
		Student student= em.find(Student.class,2001L);
		log.info("student -> {}",student);
		
		Passport passport = student.getPassport();
		log.info("passport -> {}",passport);
	}

}
