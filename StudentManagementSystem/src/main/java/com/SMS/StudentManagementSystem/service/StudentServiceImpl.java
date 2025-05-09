package com.SMS.StudentManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.SMS.StudentManagementSystem.model.StudentEntity;
import com.SMS.StudentManagementSystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public void addStudent(StudentEntity se) {
		
		studentRepo.save(se);
	}

	@Override
	public String updateStudent(StudentEntity se) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(StudentEntity se) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(se.getRollNo());
		return "DEleted";
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public StudentEntity getById(int id) {
		
		return studentRepo.findById(id).get();
	}
	

}
