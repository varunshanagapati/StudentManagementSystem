package com.SMS.StudentManagementSystem.service;

import java.util.List;

import org.springframework.ui.Model;

import com.SMS.StudentManagementSystem.model.StudentEntity;

public interface StudentService {

	public void addStudent(StudentEntity se);
	public String updateStudent(StudentEntity se);
	public String deleteStudent(StudentEntity se);
	public List<StudentEntity> getAllStudents();
	public StudentEntity getById(int id);
}
