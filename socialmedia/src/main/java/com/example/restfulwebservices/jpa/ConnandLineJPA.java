package com.example.restfulwebservices.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.restfulwebservices.jdbc.Course;

@Component
public class ConnandLineJPA implements CommandLineRunner{
	
	@Autowired
	private CourseJPARepository courseJPARepository;

	@Override
	public void run(String... args) throws Exception {
  
		courseJPARepository.insert(new Course("xyz", "xyz"));
		courseJPARepository.insert(new Course("abc", "abc"));
		courseJPARepository.insert(new Course("uvx", "uvx"));
		
	//	courseJPARepository.delete(5);
		
		System.out.println(courseJPARepository.findById(6));
		System.out.println(courseJPARepository.findById(6));
	}
	

}
