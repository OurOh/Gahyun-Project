package com.gahyun.dev.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gahyun.dev.model.PaymentsDto;

@Mapper
public interface PaymentMapper {
	// 결제 정보 삽입
    void insertPayment(PaymentsDto payment); 
    
    // 가장 최근 예약 ID 조회
    int getLatestReservationId(@Param("userId") int userId, @Param("roomId") int roomId);
    
    // 결제 상태 업데이트
    void updatePaymentStatus(@Param("impUid") String impUid, @Param("status") String status);

    // 결제 키 조회 (추가한 부분)
    String getPaymentKeyFromReservation(@Param("reservationId") String reservationId);

    // Map<String, Object> 타입의 매개변수를 받는 updateReservationStatus 메서드
    void updateReservationStatus(Map<String, Object> params);
}
