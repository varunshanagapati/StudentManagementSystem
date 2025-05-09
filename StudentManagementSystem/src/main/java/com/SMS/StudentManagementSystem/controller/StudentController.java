package com.SMS.StudentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SMS.StudentManagementSystem.model.StudentEntity;
import com.SMS.StudentManagementSystem.repository.StudentRepository;
import com.SMS.StudentManagementSystem.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/dashboard")
	public String ShowDashboard(HttpSession httpSession, Model model) {
		
		
	    if (httpSession.getAttribute("LoggedInUser") == null) {
	        return "redirect:/?logintip=true";
	    }
	    String name=httpSession.getAttribute("LoggedInUser").toString();
		model.addAttribute("user",name);
		model.addAttribute("students",studentService.getAllStudents());
	    return "dashboard";
	}
	
	@GetMapping("/dashboard/addstudent")
	public String addStudentPage(HttpSession httpSession) {
		if (httpSession.getAttribute("LoggedInUser") == null) {
	        return "redirect:/?logintip=true";
	    }
		return "addstudent";
	}
	
	@PostMapping("/dashboard/addstudent")
	public String addStudent(
			@RequestParam("studentName") String studentName,
			@RequestParam("studentRollNo") int studentRollNo,
			@RequestParam("studentEmail") String studentEmail,
			@RequestParam("studentBranch") String studentBranch,
			Model model) {
		
		StudentEntity student= new StudentEntity();
		student.setRollNo(studentRollNo);
		student.setStudentName(studentName);
		student.setBranch(studentBranch);
		student.setStudentEmail(studentEmail);
		System.out.println(student);
		studentService.addStudent(student);
		
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/dashboard/update/{id}")
	public String updateStudentView(@PathVariable("id") int id,Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("LoggedInUser") == null) {
	        return "redirect:/?logintip=true";
	    }
		StudentEntity se = studentService.getById(id);
		model.addAttribute("updateStudent",se);
//        se.setBranch(studentBranch);
//        se.setStudentEmail(studentEmail);
//        studentService.addStudent(se); // JPA will update the record

		return "updatestudent";
	}
	
	@PostMapping("/dashboard/update/{id}")
	public String updateStudent(@PathVariable("id") int id,
			@RequestParam("studentName") String studentName,
			@RequestParam("studentRollNo") int studentRollNo,
			@RequestParam("studentEmail") String studentEmail,
			@RequestParam("studentBranch") String studentBranch,
			Model model) {
		StudentEntity se = studentService.getById(id);
		model.addAttribute("updateStudent",se);
		se.setRollNo(studentRollNo);
		se.setStudentName(studentName);
        se.setBranch(studentBranch);
        se.setStudentEmail(studentEmail);
        studentService.addStudent(se); // JPA will update the record

		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id, HttpSession httpSession) {
		if (httpSession.getAttribute("LoggedInUser") == null) {
	        return "redirect:/?logintip=true";
	    }
		StudentEntity se = studentService.getById(id);
		studentService.deleteStudent(se);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false); // Get session if exists

	    session.invalidate(); // Destroys session
	    

	    // Optional: Clear cache to prevent browser from accessing back pages
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    
	    return "redirect:/?logout=true";
	}
	
}
