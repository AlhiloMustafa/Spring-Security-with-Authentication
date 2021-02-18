package com.example.login.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordBCrypt {
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		String newPassword="alhilo2020";
		String encodedPassword=encoder.encode(newPassword);
		System.out.println(encodedPassword);
		
		
	}

}
