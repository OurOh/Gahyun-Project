package com.gahyun.dev.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.gahyun.dev.model.PaymentsDto;

@Mapper
public interface PaymentMapper {
    // XML 파일에서 SQL을 매핑하도록 수정했으므로 어노테이션 제거
    void insertPayment(PaymentsDto payment); 
    int getLatestReservationId(@Param("userId") int userId, @Param("roomId") int roomId);
}
