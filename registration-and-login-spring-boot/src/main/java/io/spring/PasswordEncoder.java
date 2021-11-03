package io.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String rawPassword = "min2000";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.print(encodedPassword);
	}

}
