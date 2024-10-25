package com.gahyun.dev.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gahyun.dev.model.ReservationsDto;
import com.gahyun.dev.model.RoomsDto;

@Mapper
public interface ReservationsMapper {

    int insertResRooms(@Param("user_id")int user_id, @Param("roomid")int roomid, @Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate ,@Param("totalPrice")BigDecimal totalPrice);
	int setStatus(@Param("user_id")int user_id, @Param("roomid")int roomid, @Param("status")String status);
    // 예약 정보를 삽입하는 메서드
    void insertReservation(ReservationsDto reservation);

    // 특정 유저의 결제 세부 정보를 가져오는 메서드
    Map<String, Object> getPaymentDetailsByUserId(int userId);

    // 특정 유저의 예약 정보를 가져오는 메서드
    ReservationsDto getReservationByUserId(int userId);

    // 예약이 완료되지 않은 남은 방 목록을 가져오는 메서드
    @Select("SELECT * FROM rooms WHERE room_id NOT IN (SELECT room_id FROM reservations WHERE check_out_date >= CURDATE())")
    List<RoomsDto> getAvailableRooms();
}
