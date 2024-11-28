package com.gahyun.dev.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gahyun.dev.mapper.RoomsMapper;
import com.gahyun.dev.model.RoomDetailDto;
import com.gahyun.dev.model.RoomsDto;

@Service
public class RoomsService {
	
	@Autowired
	private RoomsMapper roomsMapper;
	
	public List<RoomDetailDto> getAvailableRoomDetails(int roomCount, int guestCount, LocalDate startDate, LocalDate endDate){

	
        
		
		return roomsMapper.findAvailableRooms(roomCount, guestCount, startDate, endDate);
	}
	public RoomDetailDto getAvailableRoomsPhoto(int roomId) {
		
		return roomsMapper.findRoomDetailsWithPhotos(roomId);
	}
	
}
