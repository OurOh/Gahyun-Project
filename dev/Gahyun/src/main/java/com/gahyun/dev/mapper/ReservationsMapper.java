package com.gahyun.dev.mapper;

import java.util.List;

import com.gahyun.dev.model.ReservationsDto;
import com.gahyun.dev.model.UserDto;

public interface ReservationsMapper {
	   UserDto getMemberUserId(String userid); 
	   void setInsertUser(UserDto userDto);
	static ReservationsDto selectReservationById(int reservationId) {
		// TODO Auto-generated method stub
		return null;
	} 

}