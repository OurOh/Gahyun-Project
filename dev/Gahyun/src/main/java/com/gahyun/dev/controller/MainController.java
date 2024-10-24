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

    // 홈 페이지 이동
    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home";  // home.jsp로 이동
    }

    // 로그인 페이지 이동
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp로 이동
    }

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

    // 로그인 처리
    @PostMapping("/login")
    public String loginUser(@RequestParam("userid") String userid,
                            @RequestParam("password") String password,
                            HttpSession session, Model model) {
        UserDto loginUser = userDao.getUserByUserId(userid);

        // 사용자 정보가 있고 비밀번호가 일치할 경우
        if (loginUser != null && passwordEncoder.matches(password, loginUser.getPassword())) {
            session.setAttribute("user", loginUser); // 로그인 성공 시 세션에 사용자 정보 저장
            return "redirect:/home"; // 홈 페이지로 리다이렉트
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login"; // 로그인 실패 시 로그인 페이지로 돌아감
        }
    }

    // 개인정보 수정 페이지 이동
    @GetMapping("/edit")
    public String showEditUserInfoPage(HttpSession session, Model model) {
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
        if (loggedInUser == null) {
            return "redirect:/login"; // 로그인 페이지로 이동
        }

        model.addAttribute("user", loggedInUser);
        return "UserEdit";  // UserEdit.jsp로 이동
    }

    // 개인정보 수정 처리
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("name") String name,
                                 @RequestParam("password") String password,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("phone") String phone,
                                 HttpSession session, Model model,
                                 RedirectAttributes redirectAttributes) {

        // 세션에서 현재 로그인된 사용자 정보 가져오기
        UserDto loggedInUser = (UserDto) session.getAttribute("user");

        // 로그인되지 않은 경우, 로그인 페이지로 리다이렉트
        if (loggedInUser == null) {
            return "redirect:/login";  // 로그인 페이지로 이동
        }

        // 사용자 정보 수정
        loggedInUser.setName(name);
        if (password != null && !password.isEmpty()) {
            loggedInUser.setPassword(passwordEncoder.encode(password));  // 비밀번호 암호화 후 저장
        }
        loggedInUser.setUser_birth(birth);
        loggedInUser.setPhone_num(phone);

        // 데이터베이스 업데이트
        userService.updateUser(loggedInUser);

        // 세션에 수정된 사용자 정보 반영
        session.setAttribute("user", loggedInUser);

        // 수정 완료 메시지 전달
        redirectAttributes.addFlashAttribute("message", "개인정보가 성공적으로 수정되었습니다.");

        // 수정 완료 후 홈 페이지로 리다이렉트
        return "redirect:/home";
    }
}
