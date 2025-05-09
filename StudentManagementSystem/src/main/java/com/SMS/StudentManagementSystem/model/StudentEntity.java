package com.SMS.StudentManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
	    name = "student",
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = "rollNo"),
	        @UniqueConstraint(columnNames = "studentEmail")
	    }
	)
public class StudentEntity {
	
	@Id
	private int rollNo;
	
	private String studentName;
	private String studentEmail;
	private String branch;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "StudentEntity [rollNo=" + rollNo + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", branch=" + branch + "]";
	}
	
	
}
