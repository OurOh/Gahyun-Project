package com.gahyun.dev.mapper;

import java.util.List;

import com.gahyun.dev.model.UserDto;

// Mapper �������̽��� ������ ������ ������ �����ͺ��̽��� �����ϰų� ��ȸ�ϴ� ���
public interface MemberMapper {
	   UserDto getMemberUserId(String userid); //���̵� ��������
	   void setInsertUser(UserDto userDto); //ȸ������ 

}