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
	private UserDao userDao;
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
	

	// 회원가입 처리
    @PostMapping("/register")
    public String registerUser(@RequestParam("userid") String userid,
                               @RequestParam("password") String password,
                               @RequestParam("name") String name,
                               @RequestParam("year") String year,
                               @RequestParam("month") String month,
                               @RequestParam("day") String day,
                               @RequestParam("phone1") String phone1,
                               @RequestParam("phone2") String phone2,
                               @RequestParam("phone3") String phone3,
                               HttpSession session, Model model) {

        // 새로운 UserDto 객체 생성 및 데이터 설정
        UserDto newUser = new UserDto();
        newUser.setUserid(userid);
        newUser.setPassword(password);
        newUser.setName(name);

        // 생년월일 결합 (yyyy-MM-dd 형식)
        String birth = year + "-" + month + "-" + day;
        newUser.setUser_birth(birth);

        // 전화번호 결합 (전화번호 형식)
        String tel = phone1 + "-" + phone2 + "-" + phone3;
        newUser.setPhone_num(tel);

        // 데이터베이스에 사용자 정보 저장
        userService.insertUser(newUser);
        
        
        
        // 회원가입 완료 후 로그인 페이지로 이동
        return "redirect:/login";
    }

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

   
    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home";  
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
    @GetMapping("/login")
    public String login(Model model) {
    	return "login";
    }
//    
//    @PostMapping("/login")
//    public String loginUser(@RequestParam("userid") String userid,
//                            @RequestParam("password") String password,
//                            HttpSession session, Model model) {
//    	 System.out.println("로그인 시도 중: " + userid);
//        UserDto loginUser = userDao.getUserByUserId(userid);
//        System.out.println("사용자 조회 결과: " + (loginUser != null));
//       
//        if (loginUser != null && passwordEncoder.matches(password, loginUser.getPassword())) {
//            session.setAttribute("user", loginUser); 
//            System.out.println("로그인 성공");
//            return "redirect:/home"; 
//        } else {
//        	System.out.println("로그인 실패: 아이디 또는 비밀번호 불일치");
//            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 틀렸습니다.");
//            return "login"; 
//        }
//    }

    
    @GetMapping("/edit")
    public String showEditUserInfoPage(HttpSession session, Model model) {
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        
        if (loggedInUser == null) {
            return "redirect:/login"; 
        }

        model.addAttribute("user", loggedInUser);
        return "UserEdit"; 
    }

 
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("name") String name,
                                 @RequestParam("password") String password,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("phone") String phone,
                                 HttpSession session, Model model,
                                 RedirectAttributes redirectAttributes) {

     
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        
        if (loggedInUser == null) {
            return "redirect:/login";  
        }

        
        loggedInUser.setName(name);
        if (password != null && !password.isEmpty()) {
            loggedInUser.setPassword(passwordEncoder.encode(password)); 
        }
        loggedInUser.setUser_birth(birth);
        loggedInUser.setPhone_num(phone);

   
        userService.updateUser(loggedInUser);

     
        session.setAttribute("user", loggedInUser);

       
        redirectAttributes.addFlashAttribute("message", "회원정보가 수정되었습니다.");

        
        return "redirect:/home";
    }
    
}
