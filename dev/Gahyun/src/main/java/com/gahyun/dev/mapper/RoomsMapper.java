package com.gahyun.dev.mapper;

import java.util.List;

import com.gahyun.dev.model.UserDto;

// Mapper �������̽��� ������ ������ ������ �����ͺ��̽��� �����ϰų� ��ȸ�ϴ� ���
public interface RoomsMapper {
	   UserDto getMemberUserId(String userid); //���̵� ��������
	   void setInsertUser(UserDto userDto); //ȸ������ 

}