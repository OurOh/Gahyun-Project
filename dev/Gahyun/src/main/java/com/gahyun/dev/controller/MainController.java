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
		

    @Autowired
    private UserService userService;
    
    //MainPage jsp ������
    /*@GetMapping("/home")
    public String mainPage(Model model) {
        return "MainPage";
    }*/
    
    // ȸ������ ������ �̵�
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        return "UserRegister";
    }

    // ȸ������ ó��
    @PostMapping("/register")
    public String registerUser(@RequestParam("userid") String userid,
                               @RequestParam("password") String password,
                               @RequestParam("name") String name,
                               @RequestParam("birth") String birth,
                               @RequestParam("tel") String tel,  // phone -> tel�� ����
                               HttpSession session, Model model) {

        // ���ο� UserDto ��ü ���� �� ������ ����
        UserDto newUser = new UserDto();
        newUser.setUserid(userid);           // userid �� �ʵ�� ����
        newUser.setPassword(password);       // password �� �ʵ�� ����
        newUser.setName(name);               // name �� �ʵ�� ����
        newUser.setUser_birth(birth);        // birth �ʵ带 user_birth�� ����
        newUser.setPhone_num(tel);        // tel ���� phone_num�� ����

        // �����ͺ��̽��� ����� ���� ����
        userService.insertUser(newUser);

        // ȸ������ �Ϸ� �� �α��� �������� �̵�
        return "redirect:/login";
    }

    
    // �α��� ������ �̵�
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp�� �̵�
    }

    // �α��� ó��
    @PostMapping("/login")
    public String loginUser(@RequestParam("userid") String userid,
                            @RequestParam("password") String password,
                            HttpSession session, Model model) {
        UserDto loginUser = userDao.getUserByUserId(userid);
        
        // ����� ������ �ְ� ��й�ȣ�� ��ġ�� ���
        if (loginUser != null && loginUser.getPassword().equals(password)) {
            session.setAttribute("user", loginUser); // �α��� ���� �� ���ǿ� ����� ���� ����
            return "redirect:/"; // Ȩ �������� �����̷�Ʈ
        } else {
            model.addAttribute("errorMessage", "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
            return "login"; // �α��� ���� �� �α��� �������� ���ư�
        }
    }

    
    // UserEdit �̵�
    // @GetMapping("/edit")
	///public String UserEdit(Model model) {
	//	return "UserEdit";
	//}

    
    
 // �������� ���� ������ �̵�
    @GetMapping("/edit")
    public String showEditUserInfoPage(HttpSession session, Model model) {
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        // �α��ε��� ���� ���, �� ����� ��ü�� �����Ͽ� UserEdit �������� �̵�
        if (loggedInUser == null) {
            loggedInUser = new UserDto(); // �� ����� ��ü ����
        }

        model.addAttribute("user", loggedInUser); // ���ǿ��� ����� ������ �ҷ����ų� �� ��ü ����
        return "UserEdit";  // UserEdit.jsp�� �̵�
    }

    // �������� ���� ó��
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("name") String name,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirmPassword,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("phone") String phone,
                                 HttpSession session, Model model) {

        // ���ǿ��� �α��ε� ����� ���� ��������
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        // �α��ε��� ���� ��� �α��� �������� �����̷�Ʈ
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        // ��й�ȣ Ȯ���� ��ġ�ϴ��� Ȯ��
        if (!password.equals(confirmPassword)) {
            model.addAttribute("errorMessage", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
            model.addAttribute("user", loggedInUser);  // ���� ����� ���� ����
            return "UserEdit";
        }

        // ����� ���� ������Ʈ
        loggedInUser.setName(name);
        loggedInUser.setPassword(password);
        loggedInUser.setUser_birth(birth);
        loggedInUser.setPhone_num(phone);

        // DB�� ����� ���� ������Ʈ
        userService.updateUser(loggedInUser);

        // ���ǿ� ������ ����� ���� �ݿ�
        session.setAttribute("user", loggedInUser);

        // ���� �Ϸ� �� Ȩ �������� �̵�
        return "redirect:/home";
    }

    // ���� ���� �޼����
    @GetMapping("/Reservation1")
    public String showReservationPage1(Model model) {
        return "Reservation_select";
    }

    @GetMapping("/Reservation2")
    public String showReservationPage2(Model model) {
        return "Reservation_confirm";
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
