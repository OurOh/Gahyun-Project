package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class RoomsDto {
	private int roomId;
	private String roomName;
	private String roomType;
	private BigDecimal pricePerNight;  // 가격이 숫자 값일 경우
	private int capacity;
	private String description;
	private Date createdAt;
	
	
}
