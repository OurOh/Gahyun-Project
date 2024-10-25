package com.gahyun.dev.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.gahyun.dev.service.UserService;

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
			return "Mainpage";
	}

    @Autowired
    private UserService userService;
    
    public String mainPage(Model model) {
        return "MainPage";
    }
    
    
    
    @GetMapping("/facilites")
    public String showFacilites(Model model) {
        return "facilites";
    }
    
    @GetMapping("/resort")
    public String showResortDetail(Model model) {
        return "resort-detail";
    }
    
    @GetMapping("/event")
    public String showEvent(Model model) {
        return "event";
    }
    
    @GetMapping("/room")
    public String showRoomDetail(Model model) {
        return "roomdetail";
    }
    
    @GetMapping("/Customer-center")
    public String showCustomerCenter(Model model) {
        return "Customer-center";
    }
    
}
