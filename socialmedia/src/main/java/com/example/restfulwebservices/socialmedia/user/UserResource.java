package com.example.restfulwebservices.socialmedia.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public EntityModel<User> retriveUser(@PathVariable int id) {
		User user = userDao.getUser(id);
		if(user == null) {
			 throw new UserNotFoundException("id :" + id);
		}
		EntityModel<User> entity = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()). retriveAllUsers());
		entity.add(link.withRel("all-users"));
		return entity;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
	     userDao.deleteById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUsers(@Valid @RequestBody User user) {
		User savedUser = userDao.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
