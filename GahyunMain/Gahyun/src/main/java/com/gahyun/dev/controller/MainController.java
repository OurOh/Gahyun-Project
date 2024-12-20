package com.gahyun.dev.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gahyun.dev.model.UserDto;
import com.gahyun.dev.service.ResService;
import com.gahyun.dev.service.RoomsService;
import com.gahyun.dev.service.UserService;

@Controller
public class MainController {

    @Autowired
    private RoomsService roomService;

    @Autowired
    private ResService resService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String Register(Model model) {
        return "UserRegister";
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String registerUser(@RequestParam("userid") String userid,
                               @RequestParam("password") String password,
                               @RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("year") String year,
                               @RequestParam("month") String month,
                               @RequestParam("day") String day,
                               @RequestParam("phone1") String phone1,
                               @RequestParam("phone2") String phone2,
                               @RequestParam("phone3") String phone3,
                               RedirectAttributes redirectAttributes,
                               Model model) {

        // 아이디 중복 체크
        if (!userService.isUserIdAvailable(userid)) {
            redirectAttributes.addFlashAttribute("errorMessage", "이미 사용 중인 아이디입니다.");
            return "redirect:/register";  // 중복된 경우 회원가입 페이지로 리다이렉트
        }

        // 새로운 UserDto 객체 생성 및 데이터 설정
        UserDto newUser = new UserDto();
        newUser.setUserid(userid);
        newUser.setPassword(passwordEncoder.encode(password));  // 비밀번호 암호화
        newUser.setName(name);
        newUser.setEmail(email);
        
        // 생년월일 설정 (yyyy-MM-dd 형식)
        String birth = year + "-" + month + "-" + day;
        newUser.setUser_birth(birth);

        // 전화번호 설정 (전화번호 형식)
        String tel = phone1 + "-" + phone2 + "-" + phone3;
        newUser.setPhone_num(tel);

        // 데이터베이스에 사용자 정보 저장
        userService.insertUser(newUser);

        // 회원가입 성공 후 로그인 페이지로 이동
        return "redirect:/login";
    }

    @GetMapping("/checkUserId")
    @ResponseBody
    public Map<String, Boolean> checkUserId(@RequestParam String userid) {
        boolean isAvailable = userService.isUserIdAvailable(userid);
        Map<String, Boolean> response = new HashMap<>();
        response.put("available", isAvailable);
        return response;
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowDateStr = today.format(formatter);
        LocalDate nowDate = LocalDate.parse(nowDateStr, formatter);
        
        resService.resSetUsedStatus(nowDate);
        System.out.println("resService resSetUsedStatus 실행!");
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
}
