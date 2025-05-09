package com.SMS.StudentManagementSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SMS.StudentManagementSystem.model.AdminEntity;
import com.SMS.StudentManagementSystem.model.AdminLoginEntity;
import com.SMS.StudentManagementSystem.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addAdmin(AdminEntity ae) {
		AdminEntity a1=new AdminEntity();
		a1.setAdminEmail(ae.getAdminEmail());
		a1.setAdminId(ae.getAdminId());
		a1.setAdminName(ae.getAdminName());
		a1.setAdminPassword(passwordEncoder.encode(ae.getAdminPassword()));
		adminRepo.save(a1);
		return "Admin Added Successfully.";
	}

	@Override
	public boolean verifyAdminLogin(AdminLoginEntity le) {
		Optional<AdminEntity> userOptional = adminRepo.findById(le.getAdminLoginId());
        if (userOptional.isPresent()) {
            AdminEntity user = userOptional.get();
            return passwordEncoder.matches(le.getAdminLoginPassword(), user.getAdminPassword());
        }
		return false;
	}

	@Override
	public String getAdminName(int loginId) {
		return adminRepo.findById(loginId).get().getAdminName();
	}

}
