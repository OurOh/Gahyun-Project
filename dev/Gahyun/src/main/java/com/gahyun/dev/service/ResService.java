package com.gahyun.dev.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gahyun.dev.mapper.ReservationsMapper;

@Service
public class ResService {
	@Autowired
	private ReservationsMapper reservationMapper;
	
	public int reservationInsert(int user_id, int roomid, LocalDate startDate, LocalDate endDate ,BigDecimal totalPrice) {
		
		return reservationMapper.insertResRooms(user_id, roomid, startDate, endDate, totalPrice);
	}
	public int resSetStatus(int user_id, int roomid, String status) {
		return reservationMapper.setStatus(user_id, roomid, status);
	}
}
