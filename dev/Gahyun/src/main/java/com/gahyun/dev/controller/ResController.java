package com.gahyun.dev.controller;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gahyun.dev.mapper.MemberMapper;
import com.gahyun.dev.mapper.ReservationsMapper;
import com.gahyun.dev.mapper.RoomsMapper;
import com.gahyun.dev.model.RoomDetailDto;
import com.gahyun.dev.service.AvailabilityService;
import com.gahyun.dev.service.ResService;
import com.gahyun.dev.service.RoomsService;



@Controller
public class ResController {
	
	@Autowired
	private MemberMapper userdao;
	
	@Autowired
	private RoomsMapper roomsdao;
	@Autowired
	private ReservationsMapper reservationsdao;
	@Autowired 
	private RoomsService roomService;
	@Autowired
	private AvailabilityService availService;
	@Autowired
	private ResService resService;
	
	@GetMapping("/Reservation1")
	public String Reservation1(Model model) {
		return "Reservation_select";
	}
	
	@GetMapping("/Reservation2")
	public String Reservation2(Model model) {
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
	public String home(
			@RequestParam("gname") String gName,
			@RequestParam("gtel") String gTel,
			@RequestParam("startDate") String startDateStr,
			@RequestParam("endDate") String endDateStr,
			@RequestParam("roomid") int roomid,
			@RequestParam("price") int price,
			@RequestParam("user_id") int user_id, //test
			HttpServletRequest request,
			Model model) {
		String status = "BOOKED";
		BigDecimal totalPrice = new BigDecimal(price); //test
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     
	 	LocalDate startDate = LocalDate.parse(startDateStr, formatter);
	 	LocalDate endDate = LocalDate.parse(endDateStr, formatter);
	 	
	 	
	 	
	 	
		resService.reservationInsert(user_id, roomid, startDate, endDate, totalPrice);
		resService.resSetStatus(user_id, roomid, status);
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
}
