package com.studentmanagement.student_recored_management.service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studentmanagement.student_recored_management.entity.UserEntity;
import com.studentmanagement.student_recored_management.repository.UserRepo;
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepo.findByUsername(username);
		// TODO Auto-generated method stub
		if(userEntity == null) {
			throw new  UsernameNotFoundException("User not found with username"+username);
		}
		return org.springframework.security.core.userdetails.User
				.withUsername(userEntity.getUsername())
				.password(userEntity.getPassword())
				.roles("USER").build();
	}

}
