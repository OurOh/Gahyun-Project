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
	//방 예약 삽입
    int insertReservation(@Param("user_id")int user_id, @Param("roomid")int roomid, @Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate ,@Param("totalPrice")BigDecimal totalPrice, @Param("status")String status);
	
    // 상태 업데이트 
    int setStatus(@Param("user_id") int user_id, @Param("roomid")int roomid, @Param("status")String status);
    // �삁�빟 �젙蹂대�� �궫�엯�븯�뒗 硫붿꽌�뱶
    void insertReservation(ReservationsDto reservation);

    // �듅�젙 �쑀���쓽 寃곗젣 �꽭遺� �젙蹂대�� 媛��졇�삤�뒗 硫붿꽌�뱶
    Map<String, Object> getPaymentDetailsByUserId(int userId);

    // �듅�젙 �쑀���쓽 �삁�빟 �젙蹂대�� 媛��졇�삤�뒗 硫붿꽌�뱶
    ReservationsDto getReservationByUserId(int userId);

    // �삁�빟�씠 �셿猷뚮릺吏� �븡�� �궓�� 諛� 紐⑸줉�쓣 媛��졇�삤�뒗 硫붿꽌�뱶
    @Select("SELECT * FROM rooms WHERE room_id NOT IN (SELECT room_id FROM reservations WHERE check_out_date >= CURDATE())")
    List<RoomsDto> getAvailableRooms();

 // �삁�빟 ID瑜� 媛��졇�삤�뒗 硫붿꽌�뱶 異붽�
    int getLatestReservationId(int userId, int roomId);
    
    // 예약상태 최신화
    int updateUsedReservations(@Param("specificDate") LocalDate specificDate);
}
