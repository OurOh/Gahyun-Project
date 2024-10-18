package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class PaymentsDto {
	private int pament_id;
	private int reservation_id;
	private String payment_method;
	private BigDecimal payment_amount;
	private Timestamp payment_date;
	private String payment_status;
	
	
	
}
