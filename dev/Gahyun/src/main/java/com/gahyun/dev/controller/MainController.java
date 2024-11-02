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

    // �쉶�썝媛��엯 泥섎━
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

        // �븘�씠�뵒 以묐났 泥댄겕
        if (!userService.isUserIdAvailable(userid)) {
            redirectAttributes.addFlashAttribute("errorMessage", "�씠誘� �궗�슜 以묒씤 �븘�씠�뵒�엯�땲�떎.");
            return "redirect:/register";  // 以묐났�맂 寃쎌슦 �쉶�썝媛��엯 �럹�씠吏�濡� 由щ떎�씠�젆�듃
        }

        // �깉濡쒖슫 UserDto 媛앹껜 �깮�꽦 諛� �뜲�씠�꽣 �꽕�젙
        UserDto newUser = new UserDto();
        newUser.setUserid(userid);
        newUser.setPassword(passwordEncoder.encode(password));  // 鍮꾨�踰덊샇 �븫�샇�솕
        newUser.setName(name);
        newUser.setEmail(email);
        
        // �깮�뀈�썡�씪 寃고빀 (yyyy-MM-dd �삎�떇)
        String birth = year + "-" + month + "-" + day;
        newUser.setUser_birth(birth);

        // �쟾�솕踰덊샇 寃고빀 (�쟾�솕踰덊샇 �삎�떇)
        String tel = phone1 + "-" + phone2 + "-" + phone3;
        newUser.setPhone_num(tel);

        // �뜲�씠�꽣踰좎씠�뒪�뿉 �궗�슜�옄 �젙蹂� ���옣
        userService.insertUser(newUser);

        // �쉶�썝媛��엯 �셿猷� �썑 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
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
        System.out.println("resService resSetUsedStatus �떎�뻾!");
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
