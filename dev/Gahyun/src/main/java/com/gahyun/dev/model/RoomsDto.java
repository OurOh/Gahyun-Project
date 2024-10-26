package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class RoomsDto {
	private int room_id;
	private String room_name;
	private String room_type;
	private BigDecimal pricePerNight;  // BigDecimal로 변경
	private int capacity;
	private String description;
	private Date createdAt;
	
	
}
