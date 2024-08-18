package com.example.restfulwebservices.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restfulwebservices.jdbc.Course;

@Repository
public interface CourseSpringDataRespository extends JpaRepository<Course, Long> {

}
