package com.gahyun.dev.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gahyun.dev.model.RoomDetailDto;
import com.gahyun.dev.model.RoomsDto;

public interface RoomsMapper {
	List<RoomDetailDto> findAvailableRooms(
			@Param("roomCount") int roomCount, @Param("guestCount")int guestCount, @Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate ); 
	void setResRooms();
	RoomDetailDto findRoomDetailsWithPhotos(@Param("roomId") int roomId);
	
	
}