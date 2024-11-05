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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gahyun.dev.dao.UserDaoImpl;
import com.gahyun.dev.mapper.ReservationsMapper;
import com.gahyun.dev.model.CustomUserDetails;
import com.gahyun.dev.model.MypageDto;
import com.gahyun.dev.model.RoomDetailDto;
import com.gahyun.dev.model.RoomRequestDto;
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

	    // �쁽�옱 �씤利앸맂 �궗�슜�옄 �젙蹂� 媛��졇�삤湲�
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userid = authentication.getName(); // 濡쒓렇�씤�맂 �궗�슜�옄�쓽 �븘�씠�뵒瑜� 媛��졇�샂

	    // UserDto 媛앹껜�뿉 �뜲�씠�꽣 �꽕�젙
	    UserDto user = new UserDto();
	    user.setUserid(userid);
	    user.setName(name);
	    user.setPassword(password);
	    user.setEmail(email);

	    // �깮�뀈�썡�씪怨� �쟾�솕踰덊샇 寃고빀
	    user.setUser_birth(year + "-" + month + "-" + day);
	    user.setPhone_num(phone1 + "-" + phone2 + "-" + phone3);

	    // �뾽�뜲�씠�듃 �떎�뻾
	    userService.updateUser(user);

	    return "redirect:/home";
	}
	
	
	
	// �븘�씠�뵒 李얘린 �럹�씠吏� �씠�룞
	@PreAuthorize("permitAll()")
    @GetMapping("/findId")
    public String showFindIdPage() {
        return "findId"; // findId.jsp �럹�씠吏�濡� �씠�룞
    }

    // �븘�씠�뵒 李얘린 泥섎━
	@PreAuthorize("permitAll()")
	   @PostMapping("/findId")
	   public String findId(@RequestParam("name") String name,
	                        @RequestParam("email") String email,
	                        Model model) {
	       String userId = userService.findUserIdByNameAndEmail(name, email);

	       if (userId != null) {
	           model.addAttribute("userId", userId);  // 찾은 아이디를 JSP로 전달
	       } else {
	           model.addAttribute("errorMessage", "등록되지 않은 사용자입니다.");
	       }
	       return "findId";  // 아이디 찾기 페이지로 돌아가기
	   }
	

	// 鍮꾨�踰덊샇 �옱�꽕�젙 �럹�씠吏� �씠�룞
	@PreAuthorize("permitAll()")
	@GetMapping("/findPassword")
	public String showFindPasswordPage() {
	    return "findPassword"; // findPassword.jsp �럹�씠吏�濡� �씠�룞
	}

	// 鍮꾨�踰덊샇 �옱�꽕�젙 泥섎━
	@PreAuthorize("permitAll()")
	@PostMapping("/resetPassword")
	public String resetPassword(
	        @RequestParam("userid") String userid,
	        @RequestParam("name") String name,
	        @RequestParam("email") String email,
	        RedirectAttributes redirectAttributes) {

	    // �궗�슜�옄 �젙蹂� �쑀�슚�꽦 寃��궗
	    if (userService.isUserValidForPasswordReset(userid, name, email)) {
	        // �엫�떆 鍮꾨�踰덊샇 �깮�꽦
	        String tempPassword = generateTemporaryPassword();
	        String encodedPassword = passwordEncoder.encode(tempPassword);

	        // 鍮꾨�踰덊샇 �뾽�뜲�씠�듃 諛� �씠硫붿씪 諛쒖넚
	        userService.resetPassword(userid, encodedPassword, tempPassword);
	        redirectAttributes.addFlashAttribute("message", "�엫�떆 鍮꾨�踰덊샇媛� �씠硫붿씪濡� �쟾�넚�릺�뿀�뒿�땲�떎.");
	    } else {
	        redirectAttributes.addFlashAttribute("error", "�엯�젰�븯�떊 �젙蹂닿� �씪移섑븯吏� �븡�뒿�땲�떎.");
	    }

	    return "redirect:/findPassword";
	}

	// �엫�떆 鍮꾨�踰덊샇 �깮�꽦 硫붿꽌�뱶
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
		System.out.println("Getre2 紐⑤뜽媛�"+ model);
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
			System.out.println("postre2 紐⑤뜽媛�"+ model);	
		
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
	 	System.out.println("�떎�뻾�셿猷�");
	 	
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
		 System.out.println("availableRooms �떎�뻾");
		 List<RoomDetailDto> availableRooms = roomService.getAvailableRoomDetails(roomCount, guestCount, startDate, endDate);
		
		 System.out.println("�뜲�씠�꽣 :" + availableRooms);
		 return ResponseEntity.ok(availableRooms);
	}
	
	
	//메인페이지에서 에약확인처리
	@PostMapping("/available1")
	public  ResponseEntity<List<RoomDetailDto>> getAvailableRooms1(
			@RequestBody RoomRequestDto requestDto
			
	) {
		 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     
		 LocalDate startDate = LocalDate.parse(requestDto.getStartDate(), formatter);
		 LocalDate endDate = LocalDate.parse(requestDto.getEndDate(), formatter);
		 System.out.println(startDate+"+"+ endDate);
		 System.out.println("availableRooms1 실행");
		 List<RoomDetailDto> availableRooms = roomService.getAvailableRoomDetails(requestDto.getRoomCount(), requestDto.getGuestCount(), startDate, endDate);
		
		 System.out.println("데이터 :" + availableRooms);
		 return ResponseEntity.ok(availableRooms);
	}
	
	
	
	
	
	
    @GetMapping("/mypage")
    public String showMyPage(HttpSession session, Model model) {
        // findIdbyUsername�쓣 �샇異쒗븯�뿬 紐⑤뜽�뿉 user_id 異붽�
        findIdbyUsername(model);

        // 紐⑤뜽�뿉�꽌 user_id瑜� 媛��졇�샂
        String userId = (String) model.getAttribute("user_id");
        
        if (userId == null) {
            return "redirect:/login";
        }

        
        List<MypageDto> currentMypage = mypageService.getCurrentMypage(userId);
        List<MypageDto> pastMypage = mypageService.getPastMypage(userId);
        
        // �삁�빟 �뜲�씠�꽣媛� �뾾�쓣 寃쎌슦�쓽 硫붿떆吏� �꽕�젙
        if (currentMypage.isEmpty()) {
            model.addAttribute("currentMypageMessage", "�쁽�옱 �삁�빟�씠 �뾾�뒿�땲�떎.");
        }
        if (pastMypage.isEmpty()) {
            model.addAttribute("pastMypageMessage", "怨쇨굅 �삁�빟�씠 �뾾�뒿�땲�떎.");
        }        
        

        model.addAttribute("currentMypage", currentMypage);
        model.addAttribute("pastMypage", pastMypage);

        return "UserMypage";
    }
		


}
