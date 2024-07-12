package com.example.restfulwebservices.socialmedia.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private static List<User> userList = new ArrayList<>();

	private static int userCount = 0;

	static {
		userList.add(new User(++userCount, "ABC", LocalDate.now().minusYears(25)));
		userList.add(new User(++userCount, "XYZ", LocalDate.now().minusYears(30)));
		userList.add(new User(++userCount, "YHG", LocalDate.now().minusYears(23)));
	}

	public List<User> getUsers() {
		return userList;
	}

	public User getUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return userList.stream().filter(predicate).findFirst().orElse(null);

	}

	public User save(User user) {
		user.setId(++userCount);
		userList.add(user);
		return user;
	}
}