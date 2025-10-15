package com.studentmanagement.student_recored_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.student_recored_management.entity.StudentManagement;
import com.studentmanagement.student_recored_management.repository.StudRepo;
@Service
public class StudentService {
	@Autowired
	private StudRepo sr;
	private double calcPercentage(StudentManagement sm) {
		return (sm.getMark1()+sm.getMark2()+sm.getMark3()+sm.getMark4()+sm.getMark5())/5;
		
	}
	private String division(double percentage) {
		if(percentage>=60)
			return "First Division";
		else if(percentage>=50)
			return "Second Division";
		else
			return "Fail";
	}
	
	public StudentManagement saveStudent(StudentManagement sm) {

		double percentage = calcPercentage(sm);
		sm.setPercentage(percentage);
		sm.setDivision(division(percentage));
		return sr.save(sm);
		
}
public List<StudentManagement> getAllStudents(){
	return sr.findAll();
}
public StudentManagement updateStudent(Long id,StudentManagement updatedStudent) {
	StudentManagement existingStudent = sr.findById(id).orElseThrow(()-> new RuntimeException("Student not found with id"+id));
	return saveStudent(existingStudent);
}
public void deleteStudent(Long id) {
	sr.deleteById(id);
}
	
}

