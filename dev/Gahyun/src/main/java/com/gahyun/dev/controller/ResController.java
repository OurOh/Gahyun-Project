package com.gahyun.dev.controller;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gahyun.dev.dao.UserDaoImpl;
import com.gahyun.dev.mapper.MemberMapper;
import com.gahyun.dev.mapper.ReservationsMapper;
import com.gahyun.dev.mapper.RoomsMapper;
import com.gahyun.dev.model.CustomUserDetails;
import com.gahyun.dev.model.MypageDto;
import com.gahyun.dev.model.RoomDetailDto;
import com.gahyun.dev.model.UserDto;
import com.gahyun.dev.service.MypageService;
import com.gahyun.dev.service.ResService;
import com.gahyun.dev.service.RoomsService;
import com.gahyun.dev.service.UserService;




@Controller
@PreAuthorize("isAuthenticated()")
public class ResController {
	
	
	
	
	private ReservationsMapper reservationsdao;
	@Autowired
	private UserService userService;
	
	@Autowired 
	private RoomsService roomService;

	@Autowired
	private ResService resService;
	
	@Autowired
	private MypageService mypageService;
	
	@Autowired
	UserDaoImpl uDao;

	
	public void findIdbyUsername(Model model ) {		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
		String username = user.getUsername();
		
		String  userPid = uDao.getPidByUserid(username);		
		if (userPid != null) {

	        model.addAttribute("user_id", userPid);
	    }
	}
	
	//edit
	@GetMapping("/edit")
    public String showEditUserInfoPage(Model model) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 if (authentication == null || !(authentication.getPrincipal() instanceof CustomUserDetails)) {
		        return "redirect:/home"; 
		    }      
        return "UserEdit"; 
    }

 
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(    							
    							 @RequestParam("name") String name,
    							 @RequestParam("password") String password,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("phone") String phone,
                                 HttpSession session, Model model,
                                 RedirectAttributes redirectAttributes) {

    	findIdbyUsername(model);
    	String userId = (String) model.getAttribute("user_id");    	
        
        if (userId == null) {
            return "redirect:/login";  
        }        
        UserDto loggedInUser = uDao.getUserByUserPid(userId);
        
        loggedInUser.setName(name);        
        loggedInUser.setUser_birth(birth);
        loggedInUser.setPassword(password);
        loggedInUser.setPhone_num(phone);
        System.out.println("loggInuser출력"+ loggedInUser);
   
        userService.updateUser(loggedInUser);

       
        redirectAttributes.addFlashAttribute("message", "회원정보가 수정되었습니다.");

        
        return "redirect:/home";
    }
	
	
	@PostMapping("/samePerson")
	public ResponseEntity<Map<String, Object>> samePerson(Model model) {
		findIdbyUsername(model);
    	String userId = (String) model.getAttribute("user_id");    	
    	UserDto loggedInUser = uDao.getUserByUserPid(userId);
    	Map<String, Object> response = new HashMap<>();
        response.put("phoneNum", loggedInUser.getPhone_num());
        response.put("name", loggedInUser.getName());
    	
    	
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/Reservation1")
	public String Reservation1(Model model) {
		return "Reservation_select";
	}
	
	@GetMapping("/Reservation2")
	public String Reservation2(Model model) {
		findIdbyUsername(model);
		System.out.println("Getre2 모델값"+ model);
		return "Reservation_confirm";
	}
	@PostMapping("/Reservation2")
	public String Reservation22(
			@RequestParam("roomId") int roomid,
			@RequestParam("startDate") String startDateStr,
			@RequestParam("endDate") String endDateStr,
			@RequestParam("guestCount") String guestCount,
			HttpServletRequest request,
			Model model
			) {
			findIdbyUsername(model);
			System.out.println("postre2 모델값"+ model);	
		
		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     
		 	LocalDate startDate = LocalDate.parse(startDateStr, formatter);
		 	LocalDate endDate = LocalDate.parse(endDateStr, formatter);
		 	
		 	RoomDetailDto resRooms = roomService.getAvailableRoomsPhoto(roomid);
		 	
		 	System.out.println(resRooms);
		 	
		 	model.addAttribute("resInfo", resRooms);
		 	model.addAttribute("resGuest", guestCount);
		 	model.addAttribute("startDate", startDate);
		 	model.addAttribute("endDate", endDate);
		 	
		 	System.out.println("model :" + model);
		return "Reservation_confirm";
	}
	@PostMapping("/ResComplte")
	public String ResComplte(
			@RequestParam("gname") String gName,
			@RequestParam("gtel") String gTel,
			@RequestParam("startDate") String startDateStr,
			@RequestParam("endDate") String endDateStr,
			@RequestParam("roomid") int roomid,
			@RequestParam("price") int price,
			HttpServletRequest request,
			Model model) {
		findIdbyUsername(model);
		String userId = (String) model.getAttribute("user_id");    
		int user_id = Integer.parseInt(userId);
		
		String status = "BOOKED";
		BigDecimal totalPrice = new BigDecimal(price); //test
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     
	 	LocalDate startDate = LocalDate.parse(startDateStr, formatter);
	 	LocalDate endDate = LocalDate.parse(endDateStr, formatter);
	 	
	 	
	 	
	 	
		resService.reservationInsert(user_id, roomid, startDate, endDate, totalPrice, status);
		//resService.resSetStatus(user_id, roomid, status);
	 	System.out.println("실행완료");
	 	
		return "home";
	}
	
	

	@PostMapping("/available")
	public  ResponseEntity<List<RoomDetailDto>> getAvailableRooms(
			@RequestParam("roomCount") int roomCount,
			@RequestParam("guestCount") int guestCount, 
			@RequestParam("startDate") String startDateStr,
			@RequestParam("endDate") String endDateStr
			
	) {
		 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     
		 LocalDate startDate = LocalDate.parse(startDateStr, formatter);
		 LocalDate endDate = LocalDate.parse(endDateStr, formatter);
		 System.out.println(startDate+"+"+ endDate);
		 System.out.println("availableRooms 실행");
		 List<RoomDetailDto> availableRooms = roomService.getAvailableRoomDetails(roomCount, guestCount, startDate, endDate);
		
		 System.out.println("데이터 :" + availableRooms);
		 return ResponseEntity.ok(availableRooms);
	}
	
    @GetMapping("/mypage")
    public String showMyPage(HttpSession session, Model model) {
        // findIdbyUsername을 호출하여 모델에 user_id 추가
        findIdbyUsername(model);

        // 모델에서 user_id를 가져옴
        String userId = (String) model.getAttribute("user_id");
        
        if (userId == null) {
            return "redirect:/login";
        }

        
        List<MypageDto> currentMypage = mypageService.getCurrentMypage(userId);
        List<MypageDto> pastMypage = mypageService.getPastMypage(userId);
        
        // 예약 데이터가 없을 경우의 메시지 설정
        if (currentMypage.isEmpty()) {
            model.addAttribute("currentMypageMessage", "현재 예약이 없습니다.");
        }
        if (pastMypage.isEmpty()) {
            model.addAttribute("pastMypageMessage", "과거 예약이 없습니다.");
        }        
        

        model.addAttribute("currentMypage", currentMypage);
        model.addAttribute("pastMypage", pastMypage);

        return "UserMypage";
    }
		


}
