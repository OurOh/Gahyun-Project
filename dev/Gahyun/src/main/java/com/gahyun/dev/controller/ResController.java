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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    @Autowired
    private PasswordEncoder passwordEncoder;
	
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
	public String updateUserInfo(@RequestParam("name") String name,
	                             @RequestParam("password") String password,
	                             @RequestParam("email") String email,
	                             @RequestParam("year") String year,
	                             @RequestParam("month") String month,
	                             @RequestParam("day") String day,
	                             @RequestParam("phone1") String phone1,
	                             @RequestParam("phone2") String phone2,
	                             @RequestParam("phone3") String phone3) {

	    // 현재 인증된 사용자 정보 가져오기
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userid = authentication.getName(); // 로그인된 사용자의 아이디를 가져옴

	    // UserDto 객체에 데이터 설정
	    UserDto user = new UserDto();
	    user.setUserid(userid);
	    user.setName(name);
	    user.setPassword(password);
	    user.setEmail(email);

	    // 생년월일과 전화번호 결합
	    user.setUser_birth(year + "-" + month + "-" + day);
	    user.setPhone_num(phone1 + "-" + phone2 + "-" + phone3);

	    // 업데이트 실행
	    userService.updateUser(user);

	    return "redirect:/home";
	}
	
	
	
	// 아이디 찾기 페이지 이동
	@PreAuthorize("permitAll()")
    @GetMapping("/findId")
    public String showFindIdPage() {
        return "findId"; // findId.jsp 페이지로 이동
    }

    // 아이디 찾기 처리
	@PreAuthorize("permitAll()")
    @PostMapping("/findId")
    public String findId(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         Model model) {

        // UserService를 통해 아이디 조회
        String userId = userService.findUserIdByNameAndEmail(name, email);

        if (userId != null) {
            model.addAttribute("userId", userId);  // 조회된 아이디 전달
        } else {
            model.addAttribute("message", "입력하신 정보와 일치하는 아이디가 없습니다.");
        }

        return "findId";  // 결과를 표시하기 위해 findId.jsp 페이지로 리턴
    }
	

	// 비밀번호 재설정 페이지 이동
	@PreAuthorize("permitAll()")
	@GetMapping("/findPassword")
	public String showFindPasswordPage() {
	    return "findPassword"; // findPassword.jsp 페이지로 이동
	}

	// 비밀번호 재설정 처리
	@PreAuthorize("permitAll()")
	@PostMapping("/resetPassword")
	public String resetPassword(
	        @RequestParam("userid") String userid,
	        @RequestParam("name") String name,
	        @RequestParam("email") String email,
	        RedirectAttributes redirectAttributes) {

	    // 사용자 정보 유효성 검사
	    if (userService.isUserValidForPasswordReset(userid, name, email)) {
	        // 임시 비밀번호 생성
	        String tempPassword = generateTemporaryPassword();
	        String encodedPassword = passwordEncoder.encode(tempPassword);

	        // 비밀번호 업데이트 및 이메일 발송
	        userService.resetPassword(userid, encodedPassword, tempPassword);
	        redirectAttributes.addFlashAttribute("message", "임시 비밀번호가 이메일로 전송되었습니다.");
	    } else {
	        redirectAttributes.addFlashAttribute("error", "입력하신 정보가 일치하지 않습니다.");
	    }

	    return "redirect:/findPassword";
	}

	// 임시 비밀번호 생성 메서드
	private String generateTemporaryPassword() {
	    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
	    StringBuilder tempPassword = new StringBuilder();
	    for (int i = 0; i < 8; i++) {
	        int randomIndex = (int) (Math.random() * chars.length());
	        tempPassword.append(chars.charAt(randomIndex));
	    }
	    return tempPassword.toString();
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
