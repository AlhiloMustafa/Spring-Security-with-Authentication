package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		User user = repo.findByEmail(email);
		
		if (user==null) {
			throw new UsernameNotFoundException("user not found");
			
		}
		
		
		return new CustomUserDetails(user);
	}

}
