package com.example.restfulwebservices.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfulwebservices.socialmedia.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
