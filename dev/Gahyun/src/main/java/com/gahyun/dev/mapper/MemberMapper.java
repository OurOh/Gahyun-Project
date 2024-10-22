package com.gahyun.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gahyun.dev.model.UserDto;

@Mapper
public interface MemberMapper {
	   UserDto getMemberUserId(String userid); //아이디 가져오기
	   void setInsertUser(UserDto userDto); //회원가입 

}