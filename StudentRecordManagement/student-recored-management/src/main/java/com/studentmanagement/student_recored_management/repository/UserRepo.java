package com.studentmanagement.student_recored_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.student_recored_management.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long>{

UserEntity findByUsername(String username);
}