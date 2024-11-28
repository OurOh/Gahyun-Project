package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class RoomDetailDto {
	private int roomId;
	private String room_name;
	private String room_type;
	private int capacity;
	private String description;
	private Timestamp created_at;
	private String roomName;
	private String roomType;
	private BigDecimal pricePerNight;

	private Date createdAt;
	
	
	// 사진 리스트
	private List<Room_photosDto> photos;
	
}
