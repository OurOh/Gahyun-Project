package com.gahyun.dev.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gahyun.dev.model.PaymentsDto;
import com.siot.IamportRestClient.response.Payment;

@Mapper
public interface PaymentMapper {
    // XML 파일에서 SQL을 매핑하도록 수정했으므로 어노테이션 제거
    void insertPayment(PaymentsDto payment); 

    // 예약 ID로 결제 정보를 조회하는 메서드
    @Select("SELECT * FROM payments WHERE reservation_id = #{reservationId}")
    Payment selectPaymentByReservationId(Integer reservationId);
}
