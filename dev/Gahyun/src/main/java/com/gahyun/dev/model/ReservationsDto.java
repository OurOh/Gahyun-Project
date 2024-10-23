package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReservationsDto {
	private int reservation_id;;
	private int user_id;
	private int room_id;
	private Date check_in_date;
	private Date check_out_date;
	private BigDecimal total_price;
	private String status;
	private Timestamp created_at;
	

	
}
