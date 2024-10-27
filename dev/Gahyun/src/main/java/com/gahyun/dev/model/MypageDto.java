package com.gahyun.dev.model;

import lombok.Data;

@Data
public class MypageDto {
    private String checkInDate;
    private String checkOutDate;
    private String roomType;
    private int peopleCount;
    private String breakfastIncluded;
    private String image;

}
