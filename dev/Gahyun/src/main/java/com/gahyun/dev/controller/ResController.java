package com.gahyun.dev.controller;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gahyun.dev.mapper.MemberMapper;
import com.gahyun.dev.mapper.ReservationsMapper;
import com.gahyun.dev.mapper.RoomsMapper;
import com.gahyun.dev.model.RoomDetailDto;
import com.gahyun.dev.model.Room_photosDto;
import com.gahyun.dev.model.RoomsDto;
import com.gahyun.dev.service.RoomsService;



@RestController
@RequestMapping("/available")
public class ResController {
	
	@Autowired
	private MemberMapper userdao;
	
	@Autowired
	private RoomsMapper roomsdao;
	@Autowired
	private ReservationsMapper reservationsdao;
	@Autowired RoomsService roomService;
	

	@PostMapping
	public  ResponseEntity<List<RoomDetailDto>> getAvailableRooms(
			@RequestParam("roomCount") int roomCount,
			@RequestParam("guestCount") int guestCount, 
			@RequestParam("startDate") String startDateStr,
			@RequestParam("endDate") String endDateStr
	) {
		 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	     
		 LocalDate startDate = LocalDate.parse(startDateStr, formatter);
		 LocalDate endDate = LocalDate.parse(endDateStr, formatter);
		 
		 System.out.println("availableRooms 실행");
		 List<RoomDetailDto> availableRooms = roomService.getAvailableRoomDetails(roomCount, guestCount, startDate, endDate);
		
		 System.out.println("데이터 :" + availableRooms);
		 return ResponseEntity.ok(availableRooms);
	}
}
