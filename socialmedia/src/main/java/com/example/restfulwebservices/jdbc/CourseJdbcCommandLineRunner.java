package com.example.restfulwebservices.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course(1, "Java Developer", "Pradeep"));
		courseJdbcRepository.insert(new Course(2, "python Developer", "Ram"));
		courseJdbcRepository.insert(new Course(3, "sql Developer", "Shyam"));

		courseJdbcRepository.delete(1);

		System.out.println("Result are: " + courseJdbcRepository.findById(3));
	}

}
