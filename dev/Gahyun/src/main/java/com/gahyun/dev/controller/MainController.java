package com.gahyun.dev.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gahyun.dev.dao.UserDao;
import com.gahyun.dev.model.RoomDetailDto;
import com.gahyun.dev.model.UserDto;
import com.gahyun.dev.service.RoomsService;

@Controller
public class MainController {

	@Autowired
	private UserDao dao;
	@Autowired
	private RoomsService roomService;
	
	/*
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	*/
	
	@GetMapping("/register")
	public String Register(Model model) {
		return "UserRegister";
	}
	
	@GetMapping("/facilites")
	public String Facilites(Model model) {
		return "facilites";
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
		    LocalDate birthDate = LocalDate.parse(user_birth, formatter);  // 커스텀 포매터로 날짜 변환
		    dto.setUser_birth(birthDate);

			System.out.println("Controller: insertUser called with UserDto: " + dto);
			
			
			dao.insertUser(dto);
			
			

	      //redirect 일떄 정보 전달 방법
			redirectAttributes.addFlashAttribute("memberok", "ok");
			
		
			return "redirect:/";
			
		}	
	
	@GetMapping("/Reservation1")
	public String Reservation1(Model model) {
		return "Reservation_select";
	}
	
	@GetMapping("/Reservation2")
	public String Reservation2(Model model) {
		return "Reservation_confirm";
	}
	@PostMapping("/Reservation2")
	public String Reservation22(
			@RequestParam("roomId") int roomid,
			@RequestParam("startDate") String startDateStr,
			@RequestParam("endDate") String endDateStr,
			@RequestParam("guestCount") String guestCount,
			HttpServletRequest request,
			Model model
			) {
		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	     
		 	LocalDate startDate = LocalDate.parse(startDateStr, formatter);
		 	LocalDate endDate = LocalDate.parse(endDateStr, formatter);
		 	
		 	RoomDetailDto resRooms = roomService.getAvailableRoomsPhoto(roomid);
		 	
		 	System.out.println(resRooms);
		 	
		 	model.addAttribute("resInfo", resRooms);
		 	model.addAttribute("resGuest", guestCount);
		 	model.addAttribute("startDate", startDate);
		 	model.addAttribute("endDate", endDate);
		 	
		 	System.out.println("model :" + model);
		return "Reservation_confirm";
	}
	

	
	@GetMapping("/login")
	public String loginForm(@RequestParam(value="error", required=false) String error, Model model) {
		if(error != null) {
			model.addAttribute("errorMessage", "아이디 또는 비밀번호가 틀렸습니다.");
		}
		return "login";
	}
	

	
	
}
