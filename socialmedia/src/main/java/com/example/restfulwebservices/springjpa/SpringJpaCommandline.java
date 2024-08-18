package com.example.restfulwebservices.springjpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.restfulwebservices.jdbc.Course;


@Component
class SpringJpaCommandline implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringJpaCommandline.class);

	private CourseSpringDataRespository reposCourseSpringDataRespository;

	public SpringJpaCommandline(
			CourseSpringDataRespository reposCourseSpringDataRespository) {
		this.reposCourseSpringDataRespository = reposCourseSpringDataRespository;
	}

	@Override
	public void run(String... args) throws Exception {

		reposCourseSpringDataRespository.save(new Course(7, "hgdf", "hgdf"));
		reposCourseSpringDataRespository.save(new Course(8, "7689", "7685"));
		reposCourseSpringDataRespository.save(new Course(9, "kdjgh", "123"));

		reposCourseSpringDataRespository.deleteById(9l);

		LOGGER.info("Detail of {}",reposCourseSpringDataRespository.findById(7l));

		List<Course> findAll = reposCourseSpringDataRespository.findAll();
		findAll.forEach(e -> {
			System.out.println( "jpa data: " + e);
		});
	}

}
