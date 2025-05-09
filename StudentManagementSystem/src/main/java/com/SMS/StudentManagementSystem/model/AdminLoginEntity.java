package com.SMS.StudentManagementSystem.model;

public class AdminLoginEntity {
	
	private int adminLoginId;
	private String adminLoginPassword;
	public int getAdminLoginId() {
		return adminLoginId;
	}
	public void setAdminLoginId(int adminLoginId) {
		this.adminLoginId = adminLoginId;
	}
	public String getAdminLoginPassword() {
		return adminLoginPassword;
	}
	public void setAdminLoginPassword(String adminLoginPassword) {
		this.adminLoginPassword = adminLoginPassword;
	}
	@Override
	public String toString() {
		return "AdminLoginEntity [adminLoginId=" + adminLoginId + ", adminLoginPassword=" + adminLoginPassword + "]";
	}
	
}
