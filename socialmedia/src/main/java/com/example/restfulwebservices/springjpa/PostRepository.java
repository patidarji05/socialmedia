package com.example.restfulwebservices.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfulwebservices.socialmedia.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
