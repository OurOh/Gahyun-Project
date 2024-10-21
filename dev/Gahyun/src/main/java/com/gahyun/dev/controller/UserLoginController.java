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
        return "login";  // �α��� �� �������� �̵�
    }

    @PostMapping("/login")
    public String login(UserDto user, HttpSession session, Model model) {
        UserDto loginUser = userService.authenticate(user.getUserid(), user.getPassword());
        
        if (loginUser != null) {
            session.setAttribute("user", loginUser);  // �α��� ���� �� ���ǿ� ����� ���� ����
            return "redirect:/home";  // �α��� ���� �� Ȩ���� �����̷�Ʈ
        } else {
            model.addAttribute("errorMessage", "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
            return "login";  // �α��� ���� �� �ٽ� �α��� ������ �̵�
        }
    }

   // @GetMapping("/logout")
   // public String logout(HttpSession session) {
    //    session.invalidate();  // ���� ��ȿȭ (�α׾ƿ� ó��)
    //    return "redirect:/login";  // �α׾ƿ� �� �α��� �������� �����̷�Ʈ
    //}
}
