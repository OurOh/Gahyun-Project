package com.gahyun.dev.model;

public class Room_photosDto {
	private int photo_id;
	private int room_id;
	private String photo_url;
	
	public Room_photosDto(int photo_id, int room_id, String photo_url) {

		this.photo_id = photo_id;
		this.room_id = room_id;
		this.photo_url = photo_url;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	
	
}
