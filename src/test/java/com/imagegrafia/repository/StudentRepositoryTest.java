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
	 * when we are having LAZY fetch we need @Transactional hibernate waits until
	 * last possible line flush() can send the changes to database till that method
	 * even do we call flush if some error occur hibernate will rollback all updates
	 * why we need @ Transactional in junit
	 * directly using entityManager we are doing changes we need @ Transactional in JUNIT
	 * see below example
	 */
	@Test
//	@Transactional
	public void testSomeThingTransactional() {
		studentRepository.someThingTransactional();
		/*Student student = em.find(Student.class, 2001L);
		Passport passport = student.getPassport();
		passport.setNumber("Pxwertyx123");
		student.setName("Ashish Yadhuvanshi");*/
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 4001L);
		log.info("passport -> {}", passport);

		Student student = passport.getStudent();
		log.info("student -> {}", student);
	}

}
