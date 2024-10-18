package com.gahyun.dev.mapper;

import java.util.List;

import com.gahyun.dev.model.UserDto;

// Mapper 인터페이스는 유저와 유저의 역할을 데이터베이스에 삽입하거나 조회하는 기능
public interface ReservationsMapper {
	   UserDto getMemberUserId(String userid); //아이디 가져오기
	   void setInsertUser(UserDto userDto); //회원가입 

}