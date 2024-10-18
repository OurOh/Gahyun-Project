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

    // @Data ������̼����� ��� getter, setter, toString, equals, hashCode ���� �ڵ����� ������
}
