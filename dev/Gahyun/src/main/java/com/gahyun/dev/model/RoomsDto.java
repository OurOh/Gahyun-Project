package com.gahyun.dev.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RoomsDto {
	private int room_id;
	private String room_name;
	private String room_type;
	private double pricePerNight;
	private int capacity;
	private String description;
	private Timestamp created_at;
	
	
}
