package com.example.restfulwebservices.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restfulwebservices.entity.Users;
import com.example.restfulwebservices.entity.UsersPrinciple;
import com.example.restfulwebservices.repo.UsersRepo;
import com.example.restfulwebservices.socialmedia.user.UserNotFoundException;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);

	private UsersRepo usersrepo;
	

	public MyUserDetailsService(UsersRepo usersrepo) {
		this.usersrepo = usersrepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username:" + username);
		try {
			Users user = usersrepo.findByUserName(username);
			if (user == null) {
				LOGGER.info("USer not found!");
				throw new UserNotFoundException("USER NOT FOUND!");
			}
			System.out.println("USers: +"+ user.toString());
			return new UsersPrinciple(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
