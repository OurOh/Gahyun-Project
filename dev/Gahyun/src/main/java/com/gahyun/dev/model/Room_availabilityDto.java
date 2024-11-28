package com.gahyun.dev.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Room_availabilityDto {
	private int room_availability;
	private int room_id;
	private Date date;
	private boolean is_available;
	
	
	
}
