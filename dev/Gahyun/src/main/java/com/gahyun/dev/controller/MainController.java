package com.gahyun.dev.controller;

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
import com.gahyun.dev.model.UserDto;
import com.gahyun.dev.service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Ȩ ������ �̵�
    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home";  // home.jsp�� �̵�
    }

    // �α��� ������ �̵�
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp�� �̵�
    }

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
                               @RequestParam("year") String year,
                               @RequestParam("month") String month,
                               @RequestParam("day") String day,
                               @RequestParam("phone1") String phone1,
                               @RequestParam("phone2") String phone2,
                               @RequestParam("phone3") String phone3,
                               HttpSession session, Model model) {

        // ���ο� UserDto ��ü ���� �� ������ ����
        UserDto newUser = new UserDto();
        newUser.setUserid(userid);
        newUser.setPassword(password);
        newUser.setName(name);

        // ������� ���� (yyyy-MM-dd ����)
        String birth = year + "-" + month + "-" + day;
        newUser.setUser_birth(birth);

        // ��ȭ��ȣ ���� (��ȭ��ȣ ����)
        String tel = phone1 + "-" + phone2 + "-" + phone3;
        newUser.setPhone_num(tel);

        // �����ͺ��̽��� ����� ���� ����
        userService.insertUser(newUser);

        // ȸ������ �Ϸ� �� �α��� �������� �̵�
        return "redirect:/login";
    }

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
