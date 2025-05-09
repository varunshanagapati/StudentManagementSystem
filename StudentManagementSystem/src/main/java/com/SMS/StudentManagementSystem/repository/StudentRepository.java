package com.SMS.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SMS.StudentManagementSystem.model.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>
{

}
