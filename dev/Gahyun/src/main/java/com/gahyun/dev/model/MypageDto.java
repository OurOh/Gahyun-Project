package com.gahyun.dev.model;

import lombok.Data;

@Data
public class MypageDto {
	private String userId;
    private String checkInDate;
    private String checkOutDate;
    private String roomType;
    private int totalPrice;
    private String image;

}
