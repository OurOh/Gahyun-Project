package com.gahyun.dev.mapper;


import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gahyun.dev.model.RoomDetailDto;

@Mapper
public interface RoomsMapper {
	List<RoomDetailDto> findAvailableRooms(
			@Param("roomCount") int roomCount, @Param("guestCount")int guestCount, @Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate ); 
	
	RoomDetailDto findRoomDetailsWithPhotos(@Param("roomId") int roomId);
	
	
	
	
}