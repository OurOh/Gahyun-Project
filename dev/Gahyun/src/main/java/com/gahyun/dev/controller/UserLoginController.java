package com.gahyun.dev.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gahyun.dev.model.UserDto;
import com.gahyun.dev.service.UserService;

@Controller
public class UserLoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";  // 로그인 폼 페이지로 이동
    }

    @PostMapping("/login")
    public String login(UserDto user, HttpSession session, Model model) {
        UserDto loginUser = userService.authenticate(user.getUserid(), user.getPassword());
        
        if (loginUser != null) {
            session.setAttribute("user", loginUser);  // 로그인 성공 시 세션에 사용자 정보 저장
            return "redirect:/home";  // 로그인 성공 후 홈으로 리다이렉트
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login";  // 로그인 실패 시 다시 로그인 폼으로 이동
        }
    }

   // @GetMapping("/logout")
   // public String logout(HttpSession session) {
    //    session.invalidate();  // 세션 무효화 (로그아웃 처리)
    //    return "redirect:/login";  // 로그아웃 후 로그인 페이지로 리다이렉트
    //}
}
