package com.gahyun.dev.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gahyun.dev.model.UserDto;
import com.gahyun.dev.service.UserService;

@Controller
public class UserLoginController {

    @Autowired
    private UserService userService;

    // 로그인 처리
    @PostMapping("/login")
    public String loginUser(
            @RequestParam("userid") String userid,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        // userid로 사용자 조회
        UserDto user = userService.getUserByUserid(userid);

        if (user != null && user.getPassword().equals(password)) {  // 비밀번호 일치 여부 확인
            session.setAttribute("user", user);  // 로그인 성공 시 세션에 사용자 정보 저장
            return "redirect:/home";  // 로그인 성공 시 홈으로 이동
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "login";  // 로그인 실패 시 로그인 페이지로 다시 이동
        }
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return "redirect:/login";  // 로그아웃 후 로그인 페이지로 이동
    }
}
