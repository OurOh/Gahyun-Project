package com.gahyun.dev.model;

import java.sql.Date;

public class Room_availabilityDto {
	private int room_availability;
	private int room_id;
	private Date date;
	private boolean is_available;
	
	public Room_availabilityDto(int room_availability, int room_id, Date date, boolean is_available) {

		this.room_availability = room_availability;
		this.room_id = room_id;
		this.date = date;
		this.is_available = is_available;
	}

	public int getRoom_availability() {
		return room_availability;
	}

	public void setRoom_availability(int room_availability) {
		this.room_availability = room_availability;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isIs_available() {
		return is_available;
	}

	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}
	
	
}
