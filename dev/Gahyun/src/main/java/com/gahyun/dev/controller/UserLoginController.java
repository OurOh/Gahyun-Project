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

    // �α��� ó��
    @PostMapping("/login")
    public String loginUser(
            @RequestParam("userid") String userid,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        // userid�� ����� ��ȸ
        UserDto user = userService.getUserByUserid(userid);

        if (user != null && user.getPassword().equals(password)) {  // ��й�ȣ ��ġ ���� Ȯ��
            session.setAttribute("user", user);  // �α��� ���� �� ���ǿ� ����� ���� ����
            return "redirect:/home";  // �α��� ���� �� Ȩ���� �̵�
        } else {
            model.addAttribute("error", "���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.");
            return "login";  // �α��� ���� �� �α��� �������� �ٽ� �̵�
        }
    }

    // �α׾ƿ� ó��
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // ���� ��ȿȭ
        return "redirect:/login";  // �α׾ƿ� �� �α��� �������� �̵�
    }
}
