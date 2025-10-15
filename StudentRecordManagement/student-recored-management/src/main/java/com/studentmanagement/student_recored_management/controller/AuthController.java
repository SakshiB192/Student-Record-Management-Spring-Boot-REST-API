package com.studentmanagement.student_recored_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.student_recored_management.entity.UserEntity;
import com.studentmanagement.student_recored_management.repository.UserRepo;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserRepo ur;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public String register(@RequestBody UserEntity userEntity) {
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userEntity.setRole("ROLE_USER");
		ur.save(userEntity);
		return "User registered successfully";
		
		
	}
	
	@PostMapping("/login")
	public String login() {
		return "Login successfully";
	}
}
