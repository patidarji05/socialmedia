package com.example.restfulwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfulwebservices.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{

	Users findByUserName(String username);

	boolean existsByUserName(String userName);

}
