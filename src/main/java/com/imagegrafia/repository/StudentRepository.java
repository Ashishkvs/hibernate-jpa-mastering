package com.imagegrafia.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imagegrafia.entity.Passport;
import com.imagegrafia.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger log = LoggerFactory.getLogger(StudentRepository.class);
	
	@Autowired
	EntityManager entityManager;

	public Student findById(Long id) {

		return entityManager.find(Student.class, id);
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			// insert
			entityManager.persist(student);
		} else {
			// update
			entityManager.merge(student);
		}
		log.info("Check Student Id : {}", student);// here if it is insert it will update with id
		return student;
	}

	public void saveStudentWithPassport() {
		Passport passport=new Passport("Zx123x123");
		entityManager.persist(passport);
		Student student = new Student("Surila");
		student.setPassport(passport);
		entityManager.persist(student);
	}
	
	@Transactional
	public void someThingTransactional() {
		
		Student student=entityManager.find(Student.class, 2001L);
		
		Passport passport = student.getPassport();
		
		passport.setNumber("Pxwertyx123");
		
		student.setName("Ashis Yadhuvanshi");
		
	}
}
