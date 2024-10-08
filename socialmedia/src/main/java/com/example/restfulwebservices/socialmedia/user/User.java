package com.example.restfulwebservices.socialmedia.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	protected User() {

	}

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "userName should have atlesst 2 char ")
	// @JsonProperty("user_name")
	private String userName;

	@Past(message = "birthdate should be in the past")
	// @JsonProperty("birth_date")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

	public User(Integer id, String userName, LocalDate birthDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", birthDate=" + birthDate + ", posts=" + posts + "]";
	}

}
