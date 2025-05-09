package com.SMS.StudentManagementSystem.service;

import com.SMS.StudentManagementSystem.model.AdminEntity;
import com.SMS.StudentManagementSystem.model.AdminLoginEntity;

public interface AdminService {
	
	public String addAdmin(AdminEntity ae);
	public boolean verifyAdminLogin(AdminLoginEntity le);
	public String getAdminName(int loginId);
	
}
