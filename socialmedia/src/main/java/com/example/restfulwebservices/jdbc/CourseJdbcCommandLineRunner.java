package com.example.restfulwebservices.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseJdbcCommandLineRunner.class);

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course( "Java Developer", "Pradeep"));
		courseJdbcRepository.insert(new Course( "python Developer", "Ram"));
		courseJdbcRepository.insert(new Course("sql Developer", "Shyam"));

		//courseJdbcRepository.delete(1);

		LOGGER.info("Result are: {}", courseJdbcRepository.findById(3));
	}

}
