package com.gahyun.dev.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.gahyun.dev.model.UserDto;
import com.gahyun.dev.service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;
    
    //MainPage jsp 미제작
    /*@GetMapping("/home")
    public String mainPage(Model model) {
        return "MainPage";
    }*/
    
    // 회원가입 페이지 이동
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        return "UserRegister";
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String registerUser(@RequestParam("userid") String userid,
                               @RequestParam("password") String password,
                               @RequestParam("name") String name,
                               @RequestParam("birth") String birth,
                               @RequestParam("tel") String tel,  // phone -> tel로 변경
                               HttpSession session, Model model) {

        // 새로운 UserDto 객체 생성 및 데이터 설정
        UserDto newUser = new UserDto();
        newUser.setUserid(userid);           // userid 폼 필드와 매핑
        newUser.setPassword(password);       // password 폼 필드와 매핑
        newUser.setName(name);               // name 폼 필드와 매핑
        newUser.setUser_birth(birth);        // birth 필드를 user_birth로 매핑
        newUser.setPhone_num(tel);        // tel 값을 phone_num에 저장

        // 데이터베이스에 사용자 정보 저장
        userService.insertUser(newUser);

        // 회원가입 완료 후 로그인 페이지로 이동
        return "redirect:/login";
    }

    
    // 로그인 페이지 이동
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp로 이동
    }

    // 로그인 처리
    @PostMapping("/login")
    public String loginUser(@RequestParam("userid") String userid,
                            @RequestParam("password") String password,
                            HttpSession session, Model model) {
        UserDto loginUser = userDao.getUserByUserId(userid);
        
        // 사용자 정보가 있고 비밀번호가 일치할 경우
        if (loginUser != null && loginUser.getPassword().equals(password)) {
            session.setAttribute("user", loginUser); // 로그인 성공 시 세션에 사용자 정보 저장
            return "redirect:/"; // 홈 페이지로 리다이렉트
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login"; // 로그인 실패 시 로그인 페이지로 돌아감
        }
    }

    
    // UserEdit 이동
    // @GetMapping("/edit")
	///public String UserEdit(Model model) {
	//	return "UserEdit";
	//}

    
    
 // 개인정보 수정 페이지 이동
    @GetMapping("/edit")
    public String showEditUserInfoPage(HttpSession session, Model model) {
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        // 로그인되지 않은 경우, 빈 사용자 객체를 전달하여 UserEdit 페이지로 이동
        if (loggedInUser == null) {
            loggedInUser = new UserDto(); // 빈 사용자 객체 생성
        }

        model.addAttribute("user", loggedInUser); // 세션에서 사용자 정보를 불러오거나 빈 객체 전달
        return "UserEdit";  // UserEdit.jsp로 이동
    }

    // 개인정보 수정 처리
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("name") String name,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirmPassword,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("phone") String phone,
                                 HttpSession session, Model model) {

        // 세션에서 로그인된 사용자 정보 가져오기
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        // 비밀번호 확인이 일치하는지 확인
        if (!password.equals(confirmPassword)) {
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            model.addAttribute("user", loggedInUser);  // 기존 사용자 정보 유지
            return "UserEdit";
        }

        // 사용자 정보 업데이트
        loggedInUser.setName(name);
        loggedInUser.setPassword(password);
        loggedInUser.setUser_birth(birth);
        loggedInUser.setPhone_num(phone);

        // DB에 사용자 정보 업데이트
        userService.updateUser(loggedInUser);

        // 세션에 수정된 사용자 정보 반영
        session.setAttribute("user", loggedInUser);

        // 수정 완료 후 홈 페이지로 이동
        return "redirect:/home";
    }

    // 예약 관련 메서드들
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
    
}
