package com.imagegrafia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	/**
	 * Name cannot be null
	 */
	@Column(nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	/**
	 * owing side table @ManyToMany relationship
	 * we can handle Table name and its column name as well
	 */
	@ManyToMany
	@JoinTable(name="STUDENT_COURSE",
	joinColumns=@JoinColumn(name="S_ID"),
	inverseJoinColumns = @JoinColumn(name="C_ID"))
	//joinColumn STUDENT_ID
	//inverseJoinColumn COURSE_ID
	private List<Course> courses = new ArrayList<>();
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(Course course) {
		this.courses.add(course);
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	protected Student() {
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
