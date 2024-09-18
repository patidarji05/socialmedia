package com.example.restfulwebservices.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulwebservices.entity.Users;
import com.example.restfulwebservices.service.UsersService;

@RestController
public class UsersController {
	
	private UsersService usersService;
	
	public UsersController(UsersService usersService) {
		this.usersService= usersService;
	}
	
	@PostMapping("/register")
	public Users registerUser( @RequestBody Users user) {
		System.out.println("users:"+ user.toString());
		 return  usersService.registerUser(user);
	}

}
