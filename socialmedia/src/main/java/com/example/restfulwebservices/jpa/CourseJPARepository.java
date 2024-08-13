package com.example.restfulwebservices.jpa;

import org.springframework.stereotype.Repository;

import com.example.restfulwebservices.jdbc.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course findById(int id) {
		return entityManager.find(Course.class, id);
	}

	public void delete(int id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

}
