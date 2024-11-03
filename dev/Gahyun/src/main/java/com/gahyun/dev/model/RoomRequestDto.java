package com.gahyun.dev.model;

import lombok.Data;

@Data
public class RoomRequestDto {
	private int roomCount;
	private int guestCount;
	private String startDate;
	private String endDate;
}
