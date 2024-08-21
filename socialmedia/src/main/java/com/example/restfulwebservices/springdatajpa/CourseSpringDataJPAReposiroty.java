package com.example.restfulwebservices.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfulwebservices.jdbc.Course;

public interface CourseSpringDataJPAReposiroty extends JpaRepository<Course, Long> {

}
