package com.gahyun.dev.model;

import lombok.Data;

@Data
public class MypageDto {
	private Integer reservationId;  // 예약 ID 필드 추가 integer은 데이터베이스에서 가져올 때 null 값을 처리할 수 있도록 하기 위함
	private String userId;
    private String checkInDate;
    private String checkOutDate;
    private String roomType;
    private int totalPrice;
    private String image;

}
