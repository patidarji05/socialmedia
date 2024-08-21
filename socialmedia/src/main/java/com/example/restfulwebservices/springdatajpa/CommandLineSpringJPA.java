package com.example.restfulwebservices.springdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.restfulwebservices.jdbc.Course;

@Component
public class CommandLineSpringJPA implements CommandLineRunner{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineSpringJPA.class);
	
	@Autowired
	private CourseSpringDataJPAReposiroty reposiroty;

	@Override
	public void run(String... args) throws Exception {
		
		reposiroty.save(new Course(10, "hjg","hjg"));
		reposiroty.save(new Course(11, "ghf","ghf"));
		reposiroty.save(new Course(12, "lkj","lkj"));
		
		reposiroty.deleteById(11l);
		
		LOGGER.info("Spring Data JPA: {}",reposiroty.findById(10l));
		LOGGER.info("Spring Data JPA: {}",reposiroty.findById(12l));
		
	
		
	}

}
