package com.gahyun.dev.model;

import java.sql.Timestamp;

public class RoomsDto {
	private int room_id;
	private String room_name;
	private String room_type;
	private int capacity;
	private String description;
	private Timestamp created_at;
	
	public RoomsDto(int room_id, String room_name, String room_type, int capacity, String description,
			Timestamp created_at) {

		this.room_id = room_id;
		this.room_name = room_name;
		this.room_type = room_type;
		this.capacity = capacity;
		this.description = description;
		this.created_at = created_at;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	
}
