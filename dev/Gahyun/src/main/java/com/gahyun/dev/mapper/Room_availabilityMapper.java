package com.gahyun.dev.mapper;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface Room_availabilityMapper {
	int updateAvailabilityRooms(@Param("roomid") int roomid,@Param("endDate")LocalDate endDate, @Param("isAvail")boolean isAvail);

}