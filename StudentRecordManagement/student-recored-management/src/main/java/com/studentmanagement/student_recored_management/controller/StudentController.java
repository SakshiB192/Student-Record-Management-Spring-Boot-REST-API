package com.studentmanagement.student_recored_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.student_recored_management.entity.StudentManagement;
import com.studentmanagement.student_recored_management.service.StudentService;

import jakarta.persistence.NamedStoredProcedureQueries;
@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	StudentService ss;
	
	@PostMapping("/add")
	public String addStudent(@RequestBody StudentManagement sm) {
		ss.saveStudent(sm);
		return "Student add successfully";
	}
	
	@GetMapping("/all")
	public List<StudentManagement> getAllStudents(){
		return ss.getAllStudents();
		
	}
	
	@PutMapping("/update/{id}")
	public String updateStudent(@PathVariable Long id, @RequestBody StudentManagement sm) {
		ss.updateStudent(id, sm);
		return "Student updated successfully";
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		ss.deleteStudent(id);
		return "Student deleted successfully";		
	}
	

}
