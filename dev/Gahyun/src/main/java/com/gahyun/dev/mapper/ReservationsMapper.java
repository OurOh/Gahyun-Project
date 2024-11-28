package com.gahyun.dev.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ReservationsMapper {
	int insertResRooms(@Param("user_id")int user_id, @Param("roomid")int roomid, @Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate ,@Param("totalPrice")BigDecimal totalPrice);
	int setStatus(@Param("user_id")int user_id, @Param("roomid")int roomid, @Param("status")String status);
}