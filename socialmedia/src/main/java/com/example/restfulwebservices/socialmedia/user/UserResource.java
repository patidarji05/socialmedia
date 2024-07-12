package com.example.restfulwebservices.socialmedia.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDao userDao;

	public UserResource(UserDao userDao) {
		this.userDao = userDao;
	}

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return userDao.getUsers();
	}

	@GetMapping("/user/{id}")
	public User retriveUser(@PathVariable int id) {
		return userDao.getUser(id);
	}
	
	public void createUsers() {
		
		
	}
	
	

}
