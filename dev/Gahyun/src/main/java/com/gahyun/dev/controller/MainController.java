package com.gahyun.dev.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Ȩ ������ �̵�
    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home";  // home.jsp�� �̵�
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

    // �α��� ó��
    @PostMapping("/login")
    public String loginUser(@RequestParam("userid") String userid,
                            @RequestParam("password") String password,
                            HttpSession session, Model model) {
        UserDto loginUser = userDao.getUserByUserId(userid);

        // ����� ������ �ְ� ��й�ȣ�� ��ġ�� ���
        if (loginUser != null && passwordEncoder.matches(password, loginUser.getPassword())) {
            session.setAttribute("user", loginUser); // �α��� ���� �� ���ǿ� ����� ���� ����
            return "redirect:/home"; // Ȩ �������� �����̷�Ʈ
        } else {
            model.addAttribute("errorMessage", "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
            return "login"; // �α��� ���� �� �α��� �������� ���ư�
        }
    }

    // �������� ���� ������ �̵�
    @GetMapping("/edit")
    public String showEditUserInfoPage(HttpSession session, Model model) {
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        // �α��ε��� ���� ��� �α��� �������� �����̷�Ʈ
        if (loggedInUser == null) {
            return "redirect:/login"; // �α��� �������� �̵�
        }

        model.addAttribute("user", loggedInUser);
        return "UserEdit";  // UserEdit.jsp�� �̵�
    }

    // �������� ���� ó��
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("name") String name,
                                 @RequestParam("password") String password,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("phone") String phone,
                                 HttpSession session, Model model,
                                 RedirectAttributes redirectAttributes) {

        // ���ǿ��� ���� �α��ε� ����� ���� ��������
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        // �α��ε��� ���� ���, �α��� �������� �����̷�Ʈ
        if (loggedInUser == null) {
            return "redirect:/login";  // �α��� �������� �̵�
        }

        // ����� ���� ����
        loggedInUser.setName(name);
        if (password != null && !password.isEmpty()) {
            loggedInUser.setPassword(passwordEncoder.encode(password));  // ��й�ȣ ��ȣȭ �� ����
        }
        loggedInUser.setUser_birth(birth);
        loggedInUser.setPhone_num(phone);

        // �����ͺ��̽� ������Ʈ
        userService.updateUser(loggedInUser);

        // ���ǿ� ������ ����� ���� �ݿ�
        session.setAttribute("user", loggedInUser);

        // ���� �Ϸ� �޽��� ����
        redirectAttributes.addFlashAttribute("message", "���������� ���������� �����Ǿ����ϴ�.");

        // ���� �Ϸ� �� Ȩ �������� �����̷�Ʈ
        return "redirect:/home";
    }
    
}
