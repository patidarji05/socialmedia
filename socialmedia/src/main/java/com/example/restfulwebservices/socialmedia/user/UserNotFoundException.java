package com.example.restfulwebservices.socialmedia.user;

public class UserNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
		System.out.println("user not fori=und exception");
	}

}
