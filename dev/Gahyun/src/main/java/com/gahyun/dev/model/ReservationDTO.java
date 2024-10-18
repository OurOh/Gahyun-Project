package com.gahyun.dev.model;

import lombok.Data;

@Data
public class ReservationDTO {
    private String checkInDate;
    private String checkOutDate;
    private String roomType;
    private int peopleCount;
    private String breakfastIncluded;
    private String image;

    // @Data 어노테이션으로 모든 getter, setter, toString, equals, hashCode 등이 자동으로 생성됨
}
