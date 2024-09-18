package com.example.restfulwebservices.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restfulwebservices.entity.Users;
import com.example.restfulwebservices.repo.UsersRepo;

@Service
public class UsersService {
	
	
	private UsersRepo userRepo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public UsersService(UsersRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public Users registerUser(Users user) {
      user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

}
