package com.gahyun.dev.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gahyun.dev.dao.UserDao;
import com.gahyun.dev.model.UserDto;

@Controller
public class MainController {

	@Autowired
	private UserDao dao;
	
	/*
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	*/
	
	@GetMapping("/register")
	public String Register(Model model) {
		return "UserRegister";
	}
		
	@PostMapping("/register")
	public String RegisterForm(
			
			@RequestParam("userid") String userid,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("birth") String user_birth,
			@RequestParam("tel") String phone_num,
			HttpServletRequest request,
			RedirectAttributes redirectAttributes
			
			) {
	
		
	
			
			UserDto dto = new UserDto();
		

		    
			dto.setUserid(userid);
			dto.setPassword(password);
			dto.setName(name);
			dto.setPhone_num(phone_num);

		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
		    LocalDate birthDate = LocalDate.parse(user_birth, formatter);  // Ŀ���� �����ͷ� ��¥ ��ȯ
		    dto.setUser_birth(birthDate);

			System.out.println("Controller: insertUser called with UserDto: " + dto);
			
			
			dao.insertUser(dto);
			
			

	      //redirect �ϋ� ���� ���� ���
			redirectAttributes.addFlashAttribute("memberok", "ok");
			
		
			return "redirect:/";
			
		}	
		
		

	
	@GetMapping("/login")
	public String loginForm(@RequestParam(value="error", required=false) String error, Model model) {
		if(error != null) {
			model.addAttribute("errorMessage", "���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		return "login";
	}
	

	
	
}