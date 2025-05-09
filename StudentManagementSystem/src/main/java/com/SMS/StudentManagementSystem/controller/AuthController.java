package com.SMS.StudentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SMS.StudentManagementSystem.model.AdminEntity;
import com.SMS.StudentManagementSystem.model.AdminLoginEntity;
import com.SMS.StudentManagementSystem.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	@Autowired
	private AdminService adminService;

    
	
	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/adminlogin")
	public String showLoginPage() {
		return "adminloginpage";
	}
	
	@GetMapping("/adminsignup")
	public String showSignupPage() {
		return "adminsignuppage";
	}
	
	@PostMapping("/adminlogin")
	public String adminLogin(@RequestParam("adminLoginId") int loginId,@RequestParam("adminLoginPassword") String loginPassword,Model model, HttpSession httpSession) {
		
		try {
			AdminLoginEntity adminLoginDto=new AdminLoginEntity();
			adminLoginDto.setAdminLoginId(loginId);
			adminLoginDto.setAdminLoginPassword(loginPassword);
			boolean isValid=adminService.verifyAdminLogin(adminLoginDto);
			if(isValid) {
				
				String uname=adminService.getAdminName(loginId);
				httpSession.setAttribute("LoggedInUser", uname);
//				System.out.println(uname);
				model.addAttribute("user",uname);
				return "redirect:/dashboard";
			}else {
				model.addAttribute("error", "Invalid username or password");
		        return "redirect:/";

			}
		}catch (Exception e) {
			//server related error mention her
			System.out.println(e);
			return "redirect:/adminlogin";
		}
	}
	
	@PostMapping("/adminsignup")
	public String adminsignup(@RequestParam("adminSignupName") String signupName,
			@RequestParam("adminsignupId") int signupId,
			@RequestParam("adminSignupEmail") String signupEmail,
			@RequestParam("adminSignupPassword") String signupPassword,
			Model model, HttpSession httpSession) {
		
		try {
			AdminEntity adminDto = new AdminEntity();
			adminDto.setAdminId(signupId);
			adminDto.setAdminName(signupName);
			adminDto.setAdminEmail(signupEmail);
			adminDto.setAdminPassword(signupPassword);
//			System.out.println(adminDto);
			String resp=adminService.addAdmin(adminDto);
//			System.out.println(resp);
			return "redirect:/adminlogin";
		}catch (Exception e) {
			//server related error mention her
			System.out.println(e);
			return "redirect:/";
		}
	}
}
