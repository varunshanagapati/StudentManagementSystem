package com.SMS.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SMS.StudentManagementSystem.model.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer>
{
	
}
