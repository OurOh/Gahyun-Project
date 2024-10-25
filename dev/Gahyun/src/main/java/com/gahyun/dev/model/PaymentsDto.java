package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class PaymentsDto {
	private int payment_id;        // 결제 ID (오타 수정)
    private int reservation_id;    // 예약 ID (예약과 연동)
    private String payment_method; // 결제 수단
    private BigDecimal payment_amount; // 결제 금액
    private Timestamp payment_date;    // 결제 날짜
    private String payment_status;     // 결제 상태 (예: PAID, CANCELED 등)
	
}
