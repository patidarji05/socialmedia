package com.example.restfulwebservices.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restfulwebservices.entity.Users;
import com.example.restfulwebservices.repo.UsersRepo;

@Service
public class UsersService {

	private UsersRepo userRepo;

	private AuthenticationManager uthAuthenticationManager;

	private JWTService jwtService;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UsersService(UsersRepo userRepo, AuthenticationManager uthAuthenticationManager, JWTService jwtService) {
		this.userRepo = userRepo;
		this.uthAuthenticationManager = uthAuthenticationManager;
		this.jwtService = jwtService;
	}

	public Users registerUser(Users user) {
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new IllegalArgumentException("Password cannot be null or empty");
		} else if (userRepo.existsByUserName(user.getUserName())) {
			throw new IllegalArgumentException("UserName already Registered");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	public String verify(Users user) {
		Authentication authentication = uthAuthenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

		if (authentication.isAuthenticated())
			return jwtService.genrateToken(user.getUserName());
		return "fail";
	}

}
