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

@Controller
public class MainController {

    @Autowired
    private UserDao dao;

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
        LocalDate birthDate = LocalDate.parse(user_birth, formatter);
//dto.setUser_birth(birthDate);

        System.out.println("Controller: insertUser called with UserDto: " + dto);
//dao.insertUser(dto);

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
    
    
    @Autowired
    private UserDao userDao;

    // 로그인 페이지 이동
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // login.jsp로 이동
    }
    
    
    @PostMapping("/login")
    public String login(@RequestParam("userid") String userid,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {
    	
        UserDto loginUser = userDao.getUserByUserId(userid);
        
        // 사용자 정보가 있고 비밀번호가 일치할 경우
        if (loginUser != null && loginUser.getPassword().equals(password)) {
            session.setAttribute("user", loginUser);  // 로그인 성공 시 세션에 사용자 정보 저장
            return "redirect:/";  // 홈 페이지로 리다이렉트
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login";  // 로그인 실패 시 로그인 페이지로 돌아감
        }
    }
    
    
    
    
}
