package com.example.restfulwebservices.socialmedia.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		User user = userDao.getUser(id);
		if(user == null)
			throw new UserNotFoundException("id :"+id );
		
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUsers(@RequestBody User user) {
		User savedUser = userDao.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
