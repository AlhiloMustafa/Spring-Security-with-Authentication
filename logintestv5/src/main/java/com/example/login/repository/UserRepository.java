package com.example.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.login.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email =?1")
	User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.password =?1")
	User findByPassword(String password);
	
	
	

}
