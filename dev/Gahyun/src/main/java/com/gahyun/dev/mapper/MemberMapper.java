package com.gahyun.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gahyun.dev.model.UserDto;

@Mapper
public interface MemberMapper {
	   UserDto getMemberUserId(String userid); //���̵� ��������
	   void setInsertUser(UserDto userDto); //ȸ������ 

}